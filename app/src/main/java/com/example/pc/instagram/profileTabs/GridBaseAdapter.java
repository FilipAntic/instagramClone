package com.example.pc.instagram.profileTabs;

import android.content.Context;
import android.media.Image;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.pc.instagram.R;

public class GridBaseAdapter extends BaseAdapter {

    private Context context;
    private Integer[] images;

    public GridBaseAdapter(Context context) {
        this.context = context;
        images = new Integer[]{
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
                R.drawable.testimg, R.drawable.testimg,
        };
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView = new ImageView(context);
        imgView.setImageResource(images[position]);
        return null;
    }
}
