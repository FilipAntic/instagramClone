package com.example.pc.instagram.profileTabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.pc.instagram.R;


public class GridViewProfile extends Fragment {

    GridView gridView;

    public GridViewProfile() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        gridView = view.findViewById(R.id.profilegridview);
        gridView.setAdapter(new GridBaseAdapter(getActivity()));
        return inflater.inflate(R.layout.fragment_grid_view, container, false);
    }
}
