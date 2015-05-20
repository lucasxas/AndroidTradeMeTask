package lucasxavier.trademetask;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.List;

import lucasxavier.trademetask.adapter.ListingViewAdapter;
import lucasxavier.trademetask.model.Listing;
import lucasxavier.trademetask.view.RecyclerItemClickListener;
import lucasxavier.trademetask.view.SpacesItemDecoration;

/**
 * A list fragment representing a list of Listings. This fragment
 * also supports tablet devices by allowing list items to be given an
 * 'activated' state upon selection. This helps indicate which item is
 * currently being viewed in a {@link ListingDetailFragment}.
 * <p/>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ListingListFragment extends Fragment {

    /**
     * The fragment's current callback object, which is notified of list item
     * clicks.
     */
    private Callbacks mCallbacks = sDummyCallbacks;

    private List<Listing> listingList;
    private RecyclerView recyclerView;
    private ListingViewAdapter adapter;

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callbacks {
        /**
         * Callback for when an item has been selected.
         */
        void onItemSelected(Integer id);
    }

    /**
     * A dummy implementation of the {@link Callbacks} interface that does
     * nothing. Used only when this fragment is not attached to an activity.
     */
    private static Callbacks sDummyCallbacks = new Callbacks() {
        @Override
        public void onItemSelected(Integer id) {
        }
    };


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListingListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_list, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        int itemsPerLine = 2;
        final GridLayoutManager manager = new GridLayoutManager(getActivity(), itemsPerLine);
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

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                if (listingList != null) {
                    Listing listing = listingList.get(pos);

                    mCallbacks.onItemSelected(listing.getId());
                    adapter.setSelectedItem(pos);
                }
            }
        }));

        if (listingList != null) {
            adapter = new ListingViewAdapter(listingList, 0);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Activities containing this fragment must implement its callbacks.
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException("Activity must implement fragment's callbacks.");
        }

        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        // Reset the active callbacks interface to the dummy implementation.
        mCallbacks = sDummyCallbacks;
    }

    public void setListingList(List<Listing> listingList) {
        this.listingList = listingList;
    }
}
