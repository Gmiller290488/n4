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
            places.add(new place("Max's Sandwich Shop", "The most amazing sandwiches (in the world!)", 1.0, "http://www.maxssandwichshop.com/"));
            places.add(new place("Petek", "Amazing Turkish cuisine that won't break the bank", 0.5, "https://www.timeout.com/london/restaurants/petek"));
            places.add(new place("Che Cosa", "The best pizza in the area by FAR!", 2.5, "http://checosa.co.uk/"));
            places.add(new place("Bird", "Organic Fried Chicken, wings, burgers, doughnuts", 2.2, "http://birdrestaurants.com/"));
            places.add(new place("Xi'an Impression", "Forget your Chinese takeAway, this is THE real deal!", 1.5, "http://xianimpression.co.uk/"));
            places.add(new place("WB Yeats", "Unless you have been to The Hand And Flowers, this will be the best pub food you've tried", 0.7, "https://www.facebook.com/wbyeatsn4/"));

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


