package lucasxavier.trademetask.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import lucasxavier.trademetask.R;
import lucasxavier.trademetask.model.Category;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private final TextView title, summary;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.category_title);
        summary = (TextView) itemView.findViewById(R.id.category_summary);
    }

    public void bind(Category category) {
        title.setText(category.getName());
        summary.setText(category.getSummary());
    }
}
