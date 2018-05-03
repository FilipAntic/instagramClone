package com.example.pc.instagram.profileTabs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.pc.instagram.PostsArrayAdapter;
import com.example.pc.instagram.R;
import com.example.pc.instagram.models.Post;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostList extends Fragment {


    public PostList() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(new Post());
//        posts.add(new Post());
//        posts.add(new Post());
//        posts.add(new Post());
//        posts.add(new Post());
        Post[] posts = {
                new Post(), new Post(),
                new Post(), new Post(),
                new Post(), new Post()
        };
        ListAdapter postsAdapter = new PostsArrayAdapter(getActivity(), posts);
        ListView postsListView = view.findViewById(R.id.postsList);

        postsListView.setAdapter(postsAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
