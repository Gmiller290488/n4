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
public class ParksFragment extends Fragment {


    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);


        // Create a fake list of earthquake locations.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Finsbury Park", "Tennis Courts & Skate park", 0.0, "http://www.haringey.gov.uk/finsbury-park"));
        places.add(new place("Wray Crescent", "Cricket Pitch", 1.4, "http://www.better.org.uk/leisure-centre/london/islington/wray-crescent-cricket-pitch"));
        places.add(new place("Whittington Park", "Floral Cat", 2.1, "http://whittingtonpca.org.uk/"));
        places.add(new place("Dartmouth Park", "Great Views", 3.1, "http://www.dartmouthpark.org/"));
        places.add(new place("Waterlow Park", "Exhibitions & Tennis Courts", 3.4, "http://www.waterlowpark.org.uk/"));


        // Create a new {@link ArrayAdapter} of earthquakes
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_parks);

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
