package sample.com.sample;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Objects;

/**
 * This is the first view(fragment) in the view pager 
 * LiveTrackingFragment.java This fragment is for showing live tracking of vehicle and how to create
 * fence for a vehicle in the map All the walk through functionality is implemented here
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class LiveTrackingFragment extends Fragment {

    /**
     * Instance of gif image view
     */
    private ImageView mGifView;

    /**
     * Calling the fragments.
     *
     * @return Used to pass the values.
     */
    public static LiveTrackingFragment newInstance() {
        return new LiveTrackingFragment();
    }

    /**
     * This method is called after onCreate
     *
     * @param inflater           inflater
     * @param container          container
     * @param savedInstanceState saved instance state
     * @return return the view
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle
            savedInstanceState) {
        return inflater.inflate(R.layout.tut_live_layout, container, false);
    }

    /**
     * After view creation all initialisation is done here
     *
     * @param view               view
     * @param savedInstanceState saved instance state
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGifView = view.findViewById(R.id.gifView);
        Glide.with(Objects.requireNonNull(getActivity()))
                .load(R.drawable.ic_livetracking)
                .into(mGifView);
    }

    /**
     * This method is for stopping the gif loading
     */
    public void stopGif() {
        /*
         * Handler to stop the gif and set a vehicle health view.
         */
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mGifView.setImageResource(R.drawable.ic_livetracking);
            }
        }, 20000);
    }
}
