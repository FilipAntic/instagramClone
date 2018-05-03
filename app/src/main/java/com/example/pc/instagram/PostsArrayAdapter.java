package com.example.pc.instagram;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.instagram.models.Post;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class PostsArrayAdapter extends ArrayAdapter<Post> {
    private ImageView postMainImg;
    private TextView profileNamePost;
    private TextView locationNamePost;
    private Button savePost;
    private Button likePostBtn;
    private Button commentPostBtn;


    public PostsArrayAdapter(Context context, Post[] foods) {
        super(context, R.layout.post ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.post, parent, false);
        // get references.
        Post singleFoodItem = getItem(position);
        TextView itemText = (TextView) customView.findViewById(R.id.locationNamePost);
        ImageView buckysImage = (ImageView) customView.findViewById(R.id.profileImgInPost);

        // dynamically update the text from the array
        itemText.setText("AA");
        // using the same image every time
        buckysImage.setImageResource(R.drawable.testimg);
        // Now we can finally return our custom View or custom item
        return customView;
    }
//    public PostsArrayAdapter(@NonNull Context context, Post[] posts) {
//        super(context, R.layout.post, posts);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
//        View customView = myCustomInflater.inflate(R.layout.post, parent, false);
//        // get references.
//        Post singlePost = getItem(position);
//
//
////        final Post singlePost = getItem(position);
//        postMainImg = customView.findViewById(R.id.postMainImage);
//        profileNamePost = customView.findViewById(R.id.profileNamePost);
//        locationNamePost = customView.findViewById(R.id.locationNamePost);
//        savePost = customView.findViewById(R.id.savePost);
//        likePostBtn = customView.findViewById(R.id.likeBtnPost);
//        commentPostBtn = customView.findViewById(R.id.commentBtnPost);
//        profileNamePost.setText("Filip Antic");
//        locationNamePost.setText("Beograd");
//        postMainImg.setImageResource(R.drawable.testimg);
//        savePost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //add this singlePost in savedImages array of user
//            }
//        });
//
//        likePostBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //umesto null stavi trenutnog korisnika
////                singlePost.getLikes().add(null);
//            }
//        });
//
//        commentPostBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //otvara se novi fragment na kojem su izlistani svi komentari i na kojem moze da se
//                //ostavlja komentar
//
//            }
//        });
//        return customView;
//    }
}
