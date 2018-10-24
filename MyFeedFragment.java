package sample.com.sample

import android.os.Bundle;
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
 * MyFeedFrgament.java
 * This fragment is the third view in the view pager screen
 * In this fragment the user can know about how to use the my feed page 
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class MyFeedFragment extends Fragment {

    ImageView mGifView;

    /**
     * Calling the fragments.
     *
     * @return Used to pass the values.
     */
    public static MyFeedFragment newInstance() {
        return new MyFeedFragment();
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
        return inflater.inflate(R.layout.tut_myfeed, container, false);
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
                .load(R.drawable.ic_myfeed)
                .into(mGifView);
    }
}
