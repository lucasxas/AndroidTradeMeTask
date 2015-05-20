package lucasxavier.trademetask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Locale;

import lucasxavier.trademetask.model.ListingDetail;
import lucasxavier.trademetask.network.GsonRequest;
import lucasxavier.trademetask.network.RequestSingleton;

/**
 * A fragment representing a single Listing detail screen.
 * This fragment is either contained in a {@link ListingListActivity}
 * in two-pane mode (on tablets) or a {@link ListingDetailActivity}
 * on handsets.
 */
public class ListingDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_LISTING_ID = "listing_id";

    private Integer listingId;

    private View content;
    private View loading;

    private TextView title, startPrice, buyNowPrice, startDate, endDate;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListingDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_LISTING_ID)) {
            listingId = getArguments().getInt(ARG_LISTING_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_detail, container, false);

        loading = view.findViewById(R.id.loading);

        content = view.findViewById(R.id.content);

        title = (TextView) view.findViewById(R.id.title);
        startPrice = (TextView) view.findViewById(R.id.start_price);
        buyNowPrice = (TextView) view.findViewById(R.id.buy_noew_price);
        startDate = (TextView) view.findViewById(R.id.start_date);
        endDate = (TextView) view.findViewById(R.id.end_date);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String listingEndpoint = String.format(getString(R.string.listing_detail_endpoint), listingId);
        String url = getString(R.string.base_url) + listingEndpoint;

        GsonRequest<ListingDetail> request = new GsonRequest<>(url, ListingDetail.class,
                new Response.Listener<ListingDetail>() {
                    @Override
                    public void onResponse(ListingDetail response) {
                        loading.setVisibility(View.GONE);
                        content.setVisibility(View.VISIBLE);
                        updateView(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity(), R.string.check_internet, Toast.LENGTH_LONG).show();
                    }
                });

        RequestSingleton.getInstance(getActivity()).addToRequestQueue(request);

        loading.setVisibility(View.VISIBLE);
        content.setVisibility(View.GONE);
    }

    private void updateView(ListingDetail listingDetail) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        BigDecimal startPrice = listingDetail.getStartPrice();
        BigDecimal buyNowPrice = listingDetail.getBuyNowPrice();

        title.setText(listingDetail.getTitle());
        this.startPrice.setText(String.format("$%.2f", startPrice == null ? 0 : startPrice.floatValue()));
        this.buyNowPrice.setText(String.format("$%.2f", buyNowPrice == null ? 0 : buyNowPrice.floatValue()));
        startDate.setText(dateFormat.format(listingDetail.getStartDate()));
        endDate.setText(dateFormat.format(listingDetail.getEndDate()));
    }
}
