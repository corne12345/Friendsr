package com.example.corne.friendsr;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    private ArrayList<Friend> friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.friends = objects;

    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // select the image and text view from the layout
        ImageView layoutImage = convertView.findViewById(R.id.imageView);
        TextView layoutName = convertView.findViewById(R.id.textView);

        // Load name and picture from the arraylist
        int picture = friends.get(position).getDrawableID();
        String name = friends.get(position).getName();

        // Fill layout view with the mentioned images and names
        layoutImage.setImageResource(picture);
        layoutName.setText(name);

        return convertView;
    }
}


