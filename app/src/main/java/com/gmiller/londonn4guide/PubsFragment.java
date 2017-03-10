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
public class PubsFragment extends Fragment {


    public PubsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);

        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("The Faltering Fullback", "Lots Of Sports",0.5 , "http://falteringfullback.com/"));
        places.add(new place("White Lion", "Pub Grub & Craft Beers", 0.7 , "http://www.whitelionn4.com/"));
        places.add(new place("WB Yeats", "Great Food & Brew Dog Beers", 0.7, "https://www.facebook.com/wbyeatsn4/"));
        places.add(new place("The Old Dairy", "Craft Beer & Sports on TV",1.1 , "http://www.theolddairyn4.co.uk/"));
        places.add(new place("The Shaftesbury", "Ales and European Lagers", 1.7,"https://www.facebook.com/ShaftesburyT/"));
        places.add(new place("The Swimmer", "Ales and European lagers", 2.1,"https://www.facebook.com/theswimmeratthegraftonarms/"));
        places.add(new place("The Railway Tavern", "Daily Drink & Food Deals", 2.2, "http://www.the-railwaytavern.co.uk/"));

        places.add(new place("The Aldwyn Castle", "Britsh GastroPub Food", 2.3, "https://www.thealwynecastleislington.co.uk/"));






        // Create a new {@link ArrayAdapter} of earthquakes
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_pubs);

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
