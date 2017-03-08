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

public class ShopsActivity extends AppCompatActivity {

    public static final String LOG_TAG = ShopsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // Create a fake list of earthquake locations.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Shiny Pretty Shop", "Niche gifts", 0.550, "https://prettyshinyshop.com/"));
        places.add(new place("Stroud Green Fruit & Veg", "Organic food products", 0.570, "http://www.myorganichunter.com/destination_detail/organic-grocer/stroud_green_fruit_and_veg"));


        // Create a new {@link ArrayAdapter} of earthquakes
        final placesAdapter adapter = new placesAdapter(this, places, R.color.category_shops);

        // Find a reference to the {@link ListView} in the layout
        final ListView placesListView = (ListView) findViewById(R.id.list);
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
