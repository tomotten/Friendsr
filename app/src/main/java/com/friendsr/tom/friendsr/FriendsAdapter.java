package com.friendsr.tom.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import ArrayAdapter;

import java.util.ArrayList;


public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {
        super(context, resource, objects);
        this.friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        Friend currFriend = friends.get(position);

        ImageView img = convertView.findViewById(R.id.imgView);
        TextView name = convertView.findViewById(R.id.nameField);
        img.setImageDrawable(getContext().getDrawable(currFriend.getDrawableId()));
        name.setText(currFriend.getFriendName());

        return convertView;
    }

}
