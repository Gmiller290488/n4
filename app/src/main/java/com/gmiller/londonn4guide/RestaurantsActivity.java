package com.gmiller.londonn4guide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dell on 08/03/2017.
 */


    public class RestaurantsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.list);

            // Create a fake list of earthquake locations.
            final ArrayList<place> places = new ArrayList<place>();
            places.add(new place("Max's Sandwich Shop", "The Most Amazing Sandwiches (in the world!)", 1.0, "http://www.maxssandwichshop.com/"));
            places.add(new place("Petek", "Amazing Turkish Cuisine that Won't Break The Bank", 0.5, "https://www.timeout.com/london/restaurants/petek"));
            places.add(new place("Che Cosa", "The Best Pizza In The Area (Even Delivered!)", 2.5, "http://checosa.co.uk/"));
            places.add(new place("Bird", "Organic Fried Chicken, Served As Wings, Burgers, Even In Between Waffles", 2.2, "http://birdrestaurants.com/"));
            places.add(new place("Xi'an Impression", "Forget Your Chinese TakeAway, This Is THE Real Deal!", 1.5, "http://xianimpression.co.uk/"));
            places.add(new place("WB Yeats", "Unless You have been to The Hand And Flowers, This Will Be The Best Pub Food You've Tried", 0.65, "https://www.facebook.com/wbyeatsn4/"));

            // Create a new {@link ArrayAdapter} of earthquakes
            final placesAdapter adapter = new placesAdapter(this, places, R.color.category_restaurants);

            // Find a reference to the {@link ListView} in the layout
            ListView placesListView = (ListView) findViewById(R.id.list);
            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            placesListView.setAdapter(adapter);

            placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {
                    place currentPlace = adapter.getItem(position);
                    Uri placeUri = Uri.parse(currentPlace.getUrl());
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, placeUri);
                    startActivity(websiteIntent);


                }
            });
        }
    }


