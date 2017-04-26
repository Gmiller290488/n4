package com.gmiller.londonn4guide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Create a fake list of earthquake locations.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Petek", "Amazing Turkish cuisine that won't break the bank", 0.5, "https://www.timeout.com/london/restaurants/petek", R.drawable.turkey4));
        places.add(new place("WB Yeats", "Unless you have been to The Hand And Flowers, this will be the best pub food you've tried", 0.7, "https://www.facebook.com/wbyeatsn4/", R.drawable.ireland4));
        places.add(new place("Pizza Pappagone", "Family friendly Italian with wood burning oven and great pizza", 0.7, "http://www.pizzeriapappagone.co.uk/", R.drawable.italy4));
        places.add(new place("Max's Sandwich Shop", "The most amazing sandwiches (in the world!)", 1.0, "http://www.maxssandwichshop.com/", R.drawable.uk4));
        places.add(new place("Xi'an Impression", "Forget your Chinese takeAway, this is THE real deal!", 1.5, "http://xianimpression.co.uk/", R.drawable.china4));
        places.add(new place("Bird", "Organic Fried Chicken, wings, burgers, doughnuts", 2.2, "http://birdrestaurants.com/", R.drawable.usa4));
        places.add(new place("Che Cosa", "The best pizza in the area by FAR!", 2.5, "http://checosa.co.uk/", R.drawable.italy4));





        // Create a new {@link ArrayAdapter} of earthquakes
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_restaurants);

        // Find a reference to the {@link ListView} in the layout
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
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

        return rootView;
    }
}
