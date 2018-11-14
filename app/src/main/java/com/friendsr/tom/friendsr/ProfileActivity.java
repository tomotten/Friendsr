package com.friendsr.tom.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    Friend retrievedFriend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView nameView = findViewById(R.id.nameField);
        nameView.setText(retrievedFriend.getFriendName());

        ImageView imgView = findViewById(R.id.profilePicture);
        imgView.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));

        TextView bio = findViewById(R.id.bioField);
        bio.setText(retrievedFriend.getBio());

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float aStoredrating = prefs.getFloat(retrievedFriend.getFriendName(), 0);
        RatingBar rate = findViewById(R.id.rateBar);

        if(aStoredrating != 0) {
            rate.setRating(aStoredrating);
        }
        rate.setOnRatingBarChangeListener(new RatingListener());
    }

    private class RatingListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            ratingBar.setRating(rating);
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getFriendName(),rating);
            editor.apply();
        }
    }
}


