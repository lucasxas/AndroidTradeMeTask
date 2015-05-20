package lucasxavier.trademetask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        View rootView = inflater.inflate(R.layout.fragment_listing_detail, container, false);

        // Show listing detail

        Toast.makeText(getActivity(), ""+ listingId, Toast.LENGTH_LONG).show();

        return rootView;
    }
}
