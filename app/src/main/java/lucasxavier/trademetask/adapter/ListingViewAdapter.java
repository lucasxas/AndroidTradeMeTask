package lucasxavier.trademetask.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import lucasxavier.trademetask.R;
import lucasxavier.trademetask.model.Listing;

public class ListingViewAdapter extends RecyclerView.Adapter<ListingViewHolder> {

    private List<Listing> listingList;
    private int selectedItem;

    public ListingViewAdapter(List<Listing> listingList, int selectedItem) {
        this.listingList = listingList;
        this.selectedItem = selectedItem;
    }

    @Override
    public ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_listing_item, parent, false);
        return new ListingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, int position) {
        holder.bind(listingList.get(position));
    }

    @Override
    public int getItemCount() {
        return listingList.size();
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }
}
