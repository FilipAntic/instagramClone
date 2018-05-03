package com.example.pc.instagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pc.instagram.models.Post;
import com.example.pc.instagram.profileTabs.GridViewProfile;
import com.example.pc.instagram.profileTabs.PostList;

import java.util.ArrayList;

public class Proba extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proba);

        Post[] posts = {
                new Post(), new Post()
        };
        ListAdapter postsAdapter = new PostsArrayAdapter(this, posts);
        ListView postsListView = findViewById(R.id.proba);

        postsListView.setAdapter(postsAdapter);

        postsListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(Proba.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}
