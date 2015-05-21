package lucasxavier.trademetask.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import lucasxavier.trademetask.R;
import lucasxavier.trademetask.model.Listing;
import lucasxavier.trademetask.network.RequestSingleton;

public class ListingViewHolder extends RecyclerView.ViewHolder {

    private final NetworkImageView picture;
    private final TextView title;
    private final TextView price;

    public ListingViewHolder(View itemView) {
        super(itemView);

        picture = (NetworkImageView) itemView.findViewById(R.id.picture);
        title = (TextView) itemView.findViewById(R.id.title);
        price = (TextView) itemView.findViewById(R.id.price);
    }

    public void bind(Listing listing, boolean isSelected) {
        Context context = itemView.getContext();
        ImageLoader imageLoader = RequestSingleton.getInstance(context).getImageLoader();

        picture.setImageUrl(listing.getPictureHref(), imageLoader);
        title.setText(listing.getTitle());
        price.setText(String.format("%.2f", listing.getPriceDisplay().floatValue()));

        if (isSelected) {
            itemView.setBackgroundColor(context.getResources().getColor(android.R.color.darker_gray));
        } else {
            itemView.setBackgroundColor(context.getResources().getColor(android.R.color.white));
        }

    }
}
