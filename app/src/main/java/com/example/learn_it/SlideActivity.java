package com.example.learn_it;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Locale;

public class SlideActivity extends FragmentActivity {
    private static final int NUM_ITEMS = 40;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_page);

        ImageFragmentPagerAdapter imageFragmentPagerAdapter = new ImageFragmentPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.pager);
        viewPager.setAdapter(imageFragmentPagerAdapter);
        viewPager.setPageTransformer(false, new DepthPageTransformer());

        int pageNo = 1;
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            pageNo = extras.getInt("PAGE_NO");
        }

        viewPager.setCurrentItem(pageNo - 1);
    }

    public void nextPage(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    }

    public void prevPage(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
    }

    public static class ImageFragmentPagerAdapter extends FragmentPagerAdapter {
        ImageFragmentPagerAdapter(FragmentManager fm) {
            super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return String.format(Locale.ENGLISH, "Page %02d", position + 1);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return SwipeFragment.newInstance(position);
        }
    }

    public static class SwipeFragment extends Fragment {
        static SwipeFragment newInstance(int position) {
            SwipeFragment swipeFragment = new SwipeFragment();
            Bundle bundle = new Bundle();

            bundle.putInt("position", position);
            swipeFragment.setArguments(bundle);

            return swipeFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View swipeView = inflater.inflate(R.layout.fragment_swipe, container, false);
            ImageView imageView = swipeView.findViewById(R.id.page_image);

            Bundle bundle = getArguments();
            int position = 0;

            if (bundle != null) {
                position = bundle.getInt("position");
            }

            String imageFileName = String.format(Locale.ENGLISH, "a%02d", position + 1);
            int imageResourceId = getResources().getIdentifier(imageFileName, "drawable", "com.example.learn_it");

            imageView.setImageResource(imageResourceId);

            return swipeView;
        }
    }
}