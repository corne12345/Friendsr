package com.example.corne.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Friend> friends = new ArrayList<>();

        // Create list of friends by adding them one by one
        int test1 = getResources().getIdentifier("arya", "drawable", this.getPackageName());
        Friend friend1 = new Friend("Arya", "A", test1);
        friends.add(friend1);

        int test2 = getResources().getIdentifier("cersei", "drawable", this.getPackageName());
        Friend friend2 = new Friend("Cersei", "B", test2);
        friends.add(friend2);

        int test3 = getResources().getIdentifier("daenerys", "drawable", this.getPackageName());
        Friend friend3 = new Friend("Daenerys", "C", test3);
        friends.add(friend3);

        int test4 = getResources().getIdentifier("jaime", "drawable", this.getPackageName());
        Friend friend4 = new Friend("Jaime", "D", test4);
        friends.add(friend4);

        int test5 = getResources().getIdentifier("jon", "drawable", this.getPackageName());
        Friend friend5 = new Friend("Jon", "E", test5);
        friends.add(friend5);

        int test6 = getResources().getIdentifier("jorah", "drawable", this.getPackageName());
        Friend friend6 = new Friend("Jorah", "F", test6);
        friends.add(friend6);

        int test7 = getResources().getIdentifier("margaery", "drawable", this.getPackageName());
        Friend friend7 = new Friend("Margaery", "G", test7);
        friends.add(friend7);

        int test8 = getResources().getIdentifier("melisandre", "drawable", this.getPackageName());
        Friend friend8 = new Friend("Melisandre", "H", test8);
        friends.add(friend8);

        int test9 = getResources().getIdentifier("sansa", "drawable", this.getPackageName());
        Friend friend9 = new Friend("Sansa", "I", test9);
        friends.add(friend9);

        int test10 = getResources().getIdentifier("tyrion", "drawable", this.getPackageName());
        Friend friend10 = new Friend("Tyrion", "J", test10);
        friends.add(friend10);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView startScreen = findViewById(R.id.gridView);
        startScreen.setAdapter(adapter);

        // Create listener to go to profile
        startScreen.setOnItemClickListener(new GridItemClickListener());


    }


    private class GridItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);
            String clickedName = clickedFriend.getName();
            Log.i("Grid", clickedName);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }

}
// Clean code
// Encapsulate
// Add more comments
// Optimize design for portrait view
// Create landscape view
// Bonus excercises