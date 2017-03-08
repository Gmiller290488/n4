package com.gmiller.londonn4guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the numbers category
        TextView restaurants = (TextView) findViewById(R.id.restaurants);

        // Set a click listener on that View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent RestaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);

                // Start the new activity
                startActivity(RestaurantsIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView pubs = (TextView) findViewById(R.id.pubs);

        // Set a click listener on that View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent PubsIntent = new Intent(MainActivity.this, PubsActivity.class);

                // Start the new activity
                startActivity(PubsIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView shops = (TextView) findViewById(R.id.shops);

        // Set a click listener on that View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ShopsIntent = new Intent(MainActivity.this, ShopsActivity.class);

                // Start the new activity
                startActivity(ShopsIntent);
            }
        });

        // Find the View that shows the numbers category
        TextView parks = (TextView) findViewById(R.id.parks);

        // Set a click listener on that View
        restaurants.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent ParksIntent = new Intent(MainActivity.this, ParksActivity.class);

                // Start the new activity
                startActivity(ParksIntent);
            }
        });
    }
}
