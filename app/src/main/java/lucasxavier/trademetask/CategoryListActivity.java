package lucasxavier.trademetask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import lucasxavier.trademetask.adapter.CategoryViewAdapter;
import lucasxavier.trademetask.model.Category;
import lucasxavier.trademetask.network.GsonRequest;
import lucasxavier.trademetask.network.RequestSingleton;
import lucasxavier.trademetask.view.RecyclerItemClickListener;
import lucasxavier.trademetask.view.SpacesItemDecoration;

public class CategoryListActivity extends Activity {

    private RecyclerView recyclerView;
    private View loading;
    private List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        int itemsPerLine = 2;
        final GridLayoutManager manager = new GridLayoutManager(this, itemsPerLine);
        recyclerView.setLayoutManager(manager);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_margin);
        final SpacesItemDecoration itemDecoration = new SpacesItemDecoration(spacingInPixels, itemsPerLine);
        recyclerView.addItemDecoration(itemDecoration);

        ViewTreeObserver viewTreeObserver = recyclerView.getViewTreeObserver();
        viewTreeObserver.addOnDrawListener(new ViewTreeObserver.OnDrawListener() {
            @Override
            public void onDraw() {
                int viewWidth = recyclerView.getMeasuredWidth();

                int childWidth = recyclerView.getChildAt(0).getMeasuredWidth();

                int newSpanCount = (int) Math.floor(viewWidth / childWidth);
                if (newSpanCount <= 0) {
                    newSpanCount = 1;
                }

                itemDecoration.setItemsPerLine(newSpanCount);

                manager.setSpanCount(newSpanCount);
                manager.requestLayout();
            }
        });

        loading = findViewById(R.id.loading);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                Category category = categoryList.get(pos);
                Intent intent = new Intent(CategoryListActivity.this, ListingListActivity.class);
                intent.putExtra(ListingListActivity.CATEGORY_ARG, category);
                startActivity(intent);
//                Toast.makeText(getApplicationContext(), category.getName(), Toast.LENGTH_LONG).show();
            }
        }));

        getCategories();
    }

    public void getCategories() {
        recyclerView.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);

        String categoryEndpoint = getString(R.string.category_endpoint);
        String url = getString(R.string.base_url) + categoryEndpoint;

        GsonRequest<Category> request = new GsonRequest<>(url, Category.class,
                new Response.Listener<Category>() {
                    @Override
                    public void onResponse(Category response) {
                        loading.setVisibility(View.INVISIBLE);
                        recyclerView.setVisibility(View.VISIBLE);
                        categoryList = response.getSubcategories();
                        recyclerView.setAdapter(new CategoryViewAdapter(categoryList));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.VISIBLE);
                        Toast.makeText(getApplicationContext(), R.string.check_internet, Toast.LENGTH_LONG).show();
                    }
                });

        RequestSingleton.getInstance(this).addToRequestQueue(request);
    }
}
