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

public class PubsActivity extends AppCompatActivity {

    public static final String LOG_TAG = PubsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        // Create a fake list of earthquake locations.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("The Swimmer At The Grafton Arms", "Ales and European lagers", 2.1,"https://www.facebook.com/theswimmeratthegraftonarms/"));
        places.add(new place("The Shaftesbury", "Ales and European Lagers", 1.7,"https://www.facebook.com/ShaftesburyT/"));
        places.add(new place("White Lion", "Pub Grub & Craft Beers", 0.7 , "http://www.whitelionn4.com/"));
        places.add(new place("The Old Dairy", "Craft Beer & Sports on TV",1.1 , "http://www.theolddairyn4.co.uk/"));
        places.add(new place("The Aldwyn Castle", "Britsh GastroPub Food", 2.3, "https://www.thealwynecastleislington.co.uk/"));
        places.add(new place("WB Yeats", "Great Food & Brew Dog Beers", 0.65, "https://www.facebook.com/wbyeatsn4/"));
        places.add(new place("The Faltering Fullback", "Lots Of Sports",0.5 , "http://falteringfullback.com/"));
        places.add(new place("The Railway Tavern", "Daily Drink & Food Deals", 2.2, "http://www.the-railwaytavern.co.uk/"));



        // Create a new {@link ArrayAdapter} of earthquakes
        final placesAdapter adapter = new placesAdapter(this, places, R.color.category_pubs);

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


