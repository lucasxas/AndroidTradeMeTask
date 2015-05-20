package lucasxavier.trademetask.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lucasxavier.trademetask.R;
import lucasxavier.trademetask.model.Category;

public class CategoryViewAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private List<Category> categoryList;

    public CategoryViewAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_category_item, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int i) {
        holder.bind(categoryList.get(i));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
