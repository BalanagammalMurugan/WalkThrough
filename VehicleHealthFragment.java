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

/** 
 * VehicleHealthFragment.java
 * This frgament is the second fragment in the waltk through screen which explains about the vehicle health view   
 */
public class VehicleHealthFragment extends Fragment {

    ImageView mGifView;

    /**
     * Create Instance fro the fragment * @return fragment
     */
    public static VehicleHealthFragment newInstance() {
        return new VehicleHealthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle
                                     savedInstanceState) {
        return inflater.inflate(R.layout.tut_vehicle_health, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mGifView = view.findViewById(R.id.gifView);
        Glide.with(getActivity())
                .load(R.drawable.ic_vehiclehealthwalk)
                .into(mGifView);
    }
}
