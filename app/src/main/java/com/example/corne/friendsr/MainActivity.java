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

        // Create list for storing friends
        ArrayList<Friend> friends = new ArrayList<>();

        // Create list of friends by adding them one by one
        int test1 = getResources().getIdentifier("arya", "drawable", this.getPackageName());
        Friend friend1 = new Friend("Arya", "Arya is the younger daughter and third child of Lord Eddard Stark and his wife Lady Catelyn Stark. She is tomboyish, headstrong, feisty, independent, disdains traditional female pursuits, and is often mistaken for a boy. She wields a smallsword named Needle, a gift from her half-brother, Jon Snow, and is trained in the Braavosi style of sword fighting by Syrio Forel.", test1);
        friends.add(friend1);

        int test2 = getResources().getIdentifier("cersei", "drawable", this.getPackageName());
        Friend friend2 = new Friend("Cersei", "Cersei is a member of House Lannister, one of the wealthiest and most powerful families in the kingdom of Westeros. She subsequently appeared in A Clash of Kings (1998) and A Storm of Swords (2000). She becomes a prominent point of view character in the novels beginning in A Feast for Crows (2005) and A Dance with Dragons", test2);
        friends.add(friend2);

        int test3 = getResources().getIdentifier("daenerys", "drawable", this.getPackageName());
        Friend friend3 = new Friend("Daenerys", "Daenerys is one of the last two surviving members (along with her older brother, Viserys) of House Targaryen, who, until fourteen years before the events of the first novel, had ruled Westeros from the Iron Throne for nearly three hundred years. She subsequently appeared in A Clash of Kings (1998) and A Storm of Swords (2000).", test3);
        friends.add(friend3);

        int test4 = getResources().getIdentifier("jaime", "drawable", this.getPackageName());
        Friend friend4 = new Friend("Jaime", "Jaime is a knight of the Kingsguard and a member of House Lannister, one of the wealthiest and most powerful families in the fictional kingdom of Westeros. Although he first appears to be unscrupulous and amoral, he later proves to be far more complex, honorable and sympathetic.", test4);
        friends.add(friend4);

        int test5 = getResources().getIdentifier("jon", "drawable", this.getPackageName());
        Friend friend5 = new Friend("Jon", "on is introduced in 1996's A Game of Thrones as the illegitimate son of Ned Stark, the honorable lord of Winterfell, an ancient fortress in the North of the fictional continent of Westeros. Knowing his prospects are limited by his status, Jon joins the Night's Watch, who guard the far northern borders from the wildlings who live beyond The Wall.", test5);
        friends.add(friend5);

        int test6 = getResources().getIdentifier("jorah", "drawable", this.getPackageName());
        Friend friend6 = new Friend("Jorah", "ntroduced in 1996's A Game of Thrones, Jorah is a mercenary knight in exile and the disgraced former lord of Bear Island, and only son of Jeor Mormont, the honourable lord commander of the Nights Watch of the kingdom of Westeros. He subsequently appeared in Martin's A Clash of Kings (1998), A Storm of Swords (2000) and A Dance with Dragons (2011).", test6);
        friends.add(friend6);

        int test7 = getResources().getIdentifier("margaery", "drawable", this.getPackageName());
        Friend friend7 = new Friend("Margaery", "Margaery is the only daughter of Alerie Hightower and Mace Tyrell, the Lord of Highgarden in the Reach. Her older brothers are the heir Willas, Garlan and Loras the Knight of Flowers, who is a member of the Kingsguard. One of the wealthiest and most powerful families in Westeros, House Tyrell is actually guided by the willful Lady Olenna, Mace's mother, who has arranged Margaery's marriages and mentors her in politics and court intrigue.", test7);
        friends.add(friend7);

        int test8 = getResources().getIdentifier("melisandre", "drawable", this.getPackageName());
        Friend friend8 = new Friend("Melisandre", "Melisandre has come to Westeros to propagate her faith in the Red God. She subsequently appeared in Martin's A Storm of Swords (2000) and A Dance with Dragons (2011). Melisandre is not a point-of-view character in the first four novels, her actions are witnessed and interpreted through the eyes of other characters such as Davos Seaworth and Jon Snow.", test8);
        friends.add(friend8);

        int test9 = getResources().getIdentifier("sansa", "drawable", this.getPackageName());
        Friend friend9 = new Friend("Sansa", "Sansa is the eldest daughter and second child of Lord Eddard Stark and his wife Lady Catelyn Stark. She subsequently appeared in the following three novels, A Clash of Kings (1998), A Storm of Swords (2000) and A Feast for Crows (2005). While absent from the fifth novel A Dance with Dragons as the books are separated geographically, Sansa is confirmed to return in the forthcoming next book in the series, The Winds of Winter.", test9);
        friends.add(friend9);

        int test10 = getResources().getIdentifier("tyrion", "drawable", this.getPackageName());
        Friend friend10 = new Friend("Tyrion", "Tyrion was one of a few prominent characters that were not included in A Feast for Crows (2005) but returned in the next novel A Dance with Dragons (2011). The character will also appear in the forthcoming volume The Winds of Winter.The popularity of the character led Martin and Bantam Books to publish The Wit & Wisdom of Tyrion Lannister, an illustrated collection of Tyrion quotes from the novels, in 2013.", test10);
        friends.add(friend10);

        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView startScreen = findViewById(R.id.gridView);
        startScreen.setAdapter(adapter);

        // Create listener to go to profile
        startScreen.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override

        // Create listener to go to profile activity and store necessary information
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