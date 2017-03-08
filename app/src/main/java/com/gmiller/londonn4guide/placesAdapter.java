package com.gmiller.londonn4guide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 08/03/2017.
 */
public class placesAdapter extends ArrayAdapter<place> {

    private int mColorResourceID;


    public placesAdapter(Context context, ArrayList<place> pPlaces, int colorResourceID) {
        super(context, 0, pPlaces);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.display_activity, parent, false);

        }
        // Find the earthquake at the given position in the list of earthquakes
        place currentPlace = getItem(position);

        // Find the TextView with view ID name
        TextView name = (TextView) listView.findViewById(R.id.name);
        name.setText(currentPlace.getName());

        // Find the TextView with ID knownFor
        TextView knownfor = (TextView) listView.findViewById(R.id.knownfor);
        knownfor.setText(currentPlace.getKnownFor());

        // Find the text with with ID distance
        TextView distance = (TextView) listView.findViewById(R.id.distance);
        String distanceFrom = String.valueOf(currentPlace.getDistance());
        distance.setText(distanceFrom + "Km from Finsbury Park Station");

        View container = listView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        container.setBackgroundColor(color);

        return listView;
    }
}
