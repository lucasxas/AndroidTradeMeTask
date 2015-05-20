package lucasxavier.trademetask;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import lucasxavier.trademetask.model.Category;
import lucasxavier.trademetask.model.Listing;
import lucasxavier.trademetask.model.SearchResult;
import lucasxavier.trademetask.network.GsonRequest;
import lucasxavier.trademetask.network.RequestSingleton;


/**
 * An activity representing a list of Listings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ListingDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ListingListFragment} and the item details
 * (if present) is a {@link ListingDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ListingListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ListingListActivity extends FragmentActivity
        implements ListingListFragment.Callbacks {

    public static final String CATEGORY_ARG = "category";

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    private View content;
    private View loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_list);

        Category category = (Category) getIntent().getSerializableExtra(CATEGORY_ARG);

        if (findViewById(R.id.listing_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
//
//            // In two-pane mode, list items should be given the
//            // 'activated' state when touched.
//            ((ListingListFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.listing_list))
//                    .setActivateOnItemClick(true);

            content = findViewById(R.id.fragments);
        } else {
            content = findViewById(R.id.listing_list_container);
        }

        loading = findViewById(R.id.loading);

        String categoryEndpoint = String.format(getString(R.string.search_endpoint), category.getNumber());
        String url = getString(R.string.base_url) + categoryEndpoint;

        GsonRequest<SearchResult> request = new GsonRequest<>(url, SearchResult.class,
                new Response.Listener<SearchResult>() {
                    @Override
                    public void onResponse(SearchResult response) {
                        loading.setVisibility(View.GONE);
                        content.setVisibility(View.VISIBLE);
                        List<Listing> listings = response.getListings();

                        ListingListFragment fragment = new ListingListFragment();
                        fragment.setListingList(listings);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.listing_list_container, fragment)
                                .commit();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(), R.string.check_internet, Toast.LENGTH_LONG).show();
                    }
                });

        loading.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);
        RequestSingleton.getInstance(this).addToRequestQueue(request);
    }

    /**
     * Callback method from {@link ListingListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(Integer id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putInt(ListingDetailFragment.ARG_LISTING_ID, id);
            ListingDetailFragment fragment = new ListingDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.listing_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ListingDetailActivity.class);
            detailIntent.putExtra(ListingDetailFragment.ARG_LISTING_ID, id);
            startActivity(detailIntent);
        }
    }
}
