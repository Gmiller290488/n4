package com.gmiller.londonn4guide;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
        distance.setText(distanceFrom + "k");

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

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        return listView;
    }

    private double getDistColor(double dist) {
        int distanceColorResourceId;
        int floordist = (int) (dist) * 10;
        switch (floordist) {
            case 0:
                distanceColorResourceId = R.color.distance0_5;
                break;
            case 5:
                distanceColorResourceId = R.color.distance0_5;
                break;
            case 10:
                distanceColorResourceId = R.color.distance1;
                break;
            case 15:
                distanceColorResourceId = R.color.distance1_5;
                break;
            case 20:
                distanceColorResourceId = R.color.distance1_75;
                break;
            case 25:
                distanceColorResourceId = R.color.distance2;
                break;
            case 30:
                distanceColorResourceId = R.color.distance2_5;
                break;
            case 35:
                distanceColorResourceId = R.color.distance3;
                break;
            case 40:
                distanceColorResourceId = R.color.distance3_5;
                break;
            case 45:
                distanceColorResourceId = R.color.distance4;
                break;
            default:
                distanceColorResourceId = R.color.distance4plus;
                break;
        }
        return ContextCompat.getColor(getContext(), distanceColorResourceId);
    }
}
