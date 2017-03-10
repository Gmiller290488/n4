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
public class ShopsFragment extends Fragment {


    public ShopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        // Create a fake list of earthquake locations.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Shiny Pretty Shop", "Niche gifts", 0.6, "https://prettyshinyshop.com/"));
        places.add(new place("Stroud Green Fruit & Veg", "Organic food products", 0.6, "http://www.myorganichunter.com/destination_detail/organic-grocer/stroud_green_fruit_and_veg"));


        // Create a new {@link ArrayAdapter} of earthquakes
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_shops);

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
