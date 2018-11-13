package com.example.corne.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView boxName = findViewById(R.id.textView2);
        ImageView boxPicture = findViewById(R.id.imageView2);
        TextView boxBio = findViewById(R.id.textView3);
        RatingBar boxRating = findViewById(R.id.ratingBar);

        String name = retrievedFriend.getName();
        int pictureID = retrievedFriend.getDrawableID();
        String bio = retrievedFriend.getBio();
        float rating;

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float aStoredFloat = prefs.getFloat(name, (float) 0.0);
        if (aStoredFloat != 0.0) {
            // we have something stored under "example_key"
            boxRating.setRating(aStoredFloat);
        }

        boxName.setText(name);
        boxPicture.setImageResource(pictureID);
        boxBio.setText(bio);

        // Create listener to update and save rating
        RatingBar profileRating = findViewById(R.id.ratingBar);
        profileRating.setOnRatingBarChangeListener(new ProfileActivity.GridItemRatingsListener());

    }
    private class GridItemRatingsListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            float ratingNew = ratingBar.getRating();

            // Create a string for log message
            String ratingString = Float.toString(ratingNew);
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();

            Intent intent = getIntent();
            Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");
            String name = retrievedFriend.getName();

            editor.putFloat(name, ratingNew);
            editor.apply();

            // Create log message to minotor
            Log.i(name, ratingString);

        }
    }
}
