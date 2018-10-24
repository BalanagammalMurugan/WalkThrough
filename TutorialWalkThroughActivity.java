package sample.com.sample

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import sample.com.sample.activities.RegisterActivity;
import sample.com.sample.utils.SharedPreferenceManager;

/**
 * TutorialWalkThroughActivity.java
 * This activity is for showing the tutorial guide for the user who is installing the
 * application newly
 */
public class TutorialWalkThroughActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tvSkip;

    /**
     * Oncreate method which calls when the activity is created
     *
     * @param savedInstanceState savedState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_walkthrough);
        tvSkip = findViewById(R.id.tv_skip);
        tvSkip.setOnClickListener(this);
        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        SpringDotsIndicator tabLayout = findViewById(R.id.dots_indicator);
        SharedPreferenceManager.instance.storeBooleanInPreference("IsShown", true);
        tabLayout.setViewPager(pager);
        /*
         * on page scroll listener for view pager
         */
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
                if (position == 0) {
                    tvSkip.setText("SKIP");
                } else if (position == 1) {
                    tvSkip.setText("SKIP");
                } else {
                    tvSkip.setText("DONE");
                }
            }

            @Override
            public void onPageSelected(int position) {
                //No implementation
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //No implementation
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_skip) {
            if ("SKIP".equals(tvSkip.getText())) {
                Intent intent = new Intent(this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(this, RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }
    }

    /**
     * The page  adapter for view pager layout
     */
    private class MyPagerAdapter extends FragmentPagerAdapter {

        /**
         * Parameterised constructor for initialising the adapter
         *
         * @param fm instance of fragment manager
         */
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the Fragment associated with a specified position.
         */
        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return LiveTrackingFragment.newInstance();
                case 1:
                    return VehicleHealthFragment.newInstance();
                case 2:
                    return MyFeedFragment.newInstance();
                default:
                    return LiveTrackingFragment.newInstance();
            }
        }

        /**
         * Returns the number of view pagers.
         */ 
        @Override
        public int getCount() {
            return 3;
        }
    }
}

