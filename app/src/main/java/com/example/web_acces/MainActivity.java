package com.example.web_acces;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the fragment container is available
        if (findViewById(R.id.fragmentContainer) != null) {
            // If this is the first time the activity is created, add the fragment
            if (savedInstanceState == null) {
                Web_search webSearchFragment = new Web_search();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, webSearchFragment);
                fragmentTransaction.commit();
            }
        }

        Button overlapping = findViewById(R.id.overlap_buttons);
        Button web_search = findViewById(R.id.google_search);
        Button forms = findViewById(R.id.form);

        overlapping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Overlapping_buttons overlappingButtonsFragment = new Overlapping_buttons();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, overlappingButtonsFragment);
                fragmentTransaction.addToBackStack(null); // Add to back stack for navigation
                fragmentTransaction.commit();

            }
        });

        web_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Web_search webSearchFragment = new Web_search(); // Create an instance of the Web_search fragment
                FragmentManager fragmentManager = getSupportFragmentManager(); // Get the fragment manager
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction(); // Start a fragment transaction
                fragmentTransaction.replace(R.id.fragmentContainer, webSearchFragment); // Replace the container with the fragment instance
                fragmentTransaction.addToBackStack(null); // Add the transaction to the back stack for navigation
                fragmentTransaction.commit(); // Commit the transaction
            }

        });

        forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forms formsFragment = new Forms();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, formsFragment);
                fragmentTransaction.addToBackStack(null); // Add to back stack for navigation
                fragmentTransaction.commit();
            }
        });
    }
}
