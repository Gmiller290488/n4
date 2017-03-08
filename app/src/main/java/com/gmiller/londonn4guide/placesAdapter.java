package com.gmiller.londonn4guide;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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
        distance.setText(distanceFrom + "km");

        View container = listView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        container.setBackgroundColor(color);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable distanceCircle = (GradientDrawable) distance.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int distanceColor = (int) getDistColor(currentPlace.getDistance());

        // Set the color on the magnitude circle
        distanceCircle.setColor(distanceColor);

        return listView;
    }

    private double getDistColor(double dist) {
        int distanceColorResourceId;
        int floordist = (int) Math.floor(dist);
        switch (floordist) {
            case 1:
                distanceColorResourceId = R.color.distance0_5;
                break;
            case 2:
                distanceColorResourceId = R.color.distance1_75;
                break;
            case 3:
                distanceColorResourceId = R.color.distance1;
                break;
            case 4:
                distanceColorResourceId = R.color.distance1_5;
                break;
            case 5:
                distanceColorResourceId = R.color.distance2;
                break;
            case 6:
                distanceColorResourceId = R.color.distance2_5;
                break;
            case 7:
                distanceColorResourceId = R.color.distance3;
                break;
            case 8:
                distanceColorResourceId = R.color.distance3_5;
                break;
            case 9:
                distanceColorResourceId = R.color.distance4;
                break;
            default:
                distanceColorResourceId = R.color.distance4plus;
                break;
        }
        return ContextCompat.getColor(getContext(), distanceColorResourceId);
    }
}
