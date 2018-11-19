package com.friendsr.tom.friendsr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Friend> friends = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String bioTest = "Roberts was executive director of Small Co., where he directed the activity of three regional branches. Roberts holds a master's degree in management from Any University. In his spare time he enjoys fly fishing and gourmet cooking with his wife, Elise.";
        Friend a = new Friend("Hannah", bioTest, getResources().getIdentifier("friend0", "drawable", getPackageName()));
        friends.add(a);
        Friend b = new Friend("Hans", bioTest, getResources().getIdentifier("friend1", "drawable", getPackageName()));
        friends.add(b);
        Friend c = new Friend("Tessa", bioTest, getResources().getIdentifier("friend2", "drawable", getPackageName()));
        friends.add(c);
        Friend d = new Friend("Bert", bioTest, getResources().getIdentifier("friend3", "drawable", getPackageName()));
        friends.add(d);
        Friend e = new Friend("Lisa", bioTest, getResources().getIdentifier("friend4", "drawable", getPackageName()));
        friends.add(e);
        Friend f = new Friend("Pieter", bioTest, getResources().getIdentifier("friend5", "drawable", getPackageName()));
        friends.add(f);
        Friend g = new Friend("Michael", bioTest, getResources().getIdentifier("friend6", "drawable", getPackageName()));
        friends.add(g);
        Friend h = new Friend("Carla", bioTest, getResources().getIdentifier("friend7", "drawable", getPackageName()));
        friends.add(h);
        Friend i = new Friend("Yussuf", bioTest, getResources().getIdentifier("friend8", "drawable", getPackageName()));
        friends.add(i);
        Friend j = new Friend("Mike", bioTest, getResources().getIdentifier("friend9", "drawable", getPackageName()));
        friends.add(j);
        Friend k = new Friend("Herman", bioTest, getResources().getIdentifier("friend10", "drawable", getPackageName()));
        friends.add(k);
        Friend l = new Friend("Kim", bioTest, getResources().getIdentifier("friend11", "drawable", getPackageName()));
        friends.add(l);
        Friend m = new Friend("Freek", bioTest, getResources().getIdentifier("friend12", "drawable", getPackageName()));
        friends.add(m);
        Friend n = new Friend("Tim", bioTest, getResources().getIdentifier("friend13", "drawable", getPackageName()));
        friends.add(n);
        Friend o = new Friend("Romy", bioTest, getResources().getIdentifier("friend14", "drawable", getPackageName()));
        friends.add(o);

        FriendsAdapter adapter = new FriendsAdapter(getApplicationContext(), R.layout.grid_item, friends);
        GridView gv = findViewById(R.id.listView);
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
