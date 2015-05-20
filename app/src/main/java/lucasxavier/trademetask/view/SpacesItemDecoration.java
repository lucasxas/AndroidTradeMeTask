package lucasxavier.trademetask.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;
    private int itemsPerLine;

    public SpacesItemDecoration(int space, int itemsPerLine) {
        this.space = space;
        this.itemsPerLine = itemsPerLine;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first items to avoid double space between items
        if (parent.getChildPosition(view) < itemsPerLine)
            outRect.top = space;
    }

    public void setItemsPerLine(int itemsPerLine) {
        this.itemsPerLine = itemsPerLine;
    }
}