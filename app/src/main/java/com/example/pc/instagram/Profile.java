package com.example.pc.instagram;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.instagram.profileTabs.GridViewProfile;
import com.example.pc.instagram.profileTabs.PostList;

public class Profile extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.menu);
        tabLayout.getTabAt(1).setIcon(R.drawable.list);
        tabLayout.getTabAt(2).setIcon(R.drawable.tag);
        tabLayout.getTabAt(3).setIcon(R.drawable.save);
    }

    private void setupViewPager(ViewPager viewPager) {
        ProfilePagerAdapter adapter = new ProfilePagerAdapter(getFragmentManager());
        adapter.addFragment(new GridViewProfile(), "");
        adapter.addFragment(new PostList(), "");
        adapter.addFragment(new GridViewProfile(), "");
        adapter.addFragment(new GridViewProfile(), "");
        viewPager.setAdapter(adapter);
    }
}
