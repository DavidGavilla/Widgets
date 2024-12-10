package com.example.web_acces;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Web_search extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup orientationGroup;
    private RadioGroup gravityGroup;
    private LinearLayout mainLayout;

    public Web_search() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_web_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        orientationGroup = view.findViewById(R.id.orientation); // Match XML ID
        gravityGroup = view.findViewById(R.id.gravity);         // Match XML ID
        mainLayout = view.findViewById(R.id.mainLayout);

        // Set listeners
        orientationGroup.setOnCheckedChangeListener(this);
        gravityGroup.setOnCheckedChangeListener(this);

        // Initialize the button
        Button boton = view.findViewById(R.id.web);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the search text from the EditText
                EditText search_text = requireView().findViewById(R.id.search_content);
                String searched_text = search_text.getText().toString().trim();

                // Check if the search text is not empty
                if (!searched_text.isEmpty()) {
                    // Build the search URL
                    String searchUrl = "https://www.google.com/search?q=" + Uri.encode(searched_text);

                    // Create an intent to open the browser
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl));
                    startActivity(browserIntent);
                } else {
                    // Notify the user to enter something in the EditText
                    Toast.makeText(view.getContext(), "Please enter a search query", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Log.d("CheckedID", "Checked ID: " + checkedId);

        if (group == orientationGroup) {
            Log.d("OrientationGroup", "Group ID: " + group.getId());
            if (checkedId == R.id.horizontal) {
                Log.d("Action", "Horizontal Selected");
                mainLayout.setOrientation(LinearLayout.HORIZONTAL);
            } else if (checkedId == R.id.vertical) {
                Log.d("Action", "Vertical Selected");
                mainLayout.setOrientation(LinearLayout.VERTICAL);
            }
        } else if (group == gravityGroup) {
            Log.d("GravityGroup", "Group ID: " + group.getId());
            if (checkedId == R.id.left) {
                Log.d("Action", "Left Gravity");
                mainLayout.setGravity(Gravity.START);
            } else if (checkedId == R.id.center) {
                Log.d("Action", "Center Gravity");
                mainLayout.setGravity(Gravity.CENTER_HORIZONTAL);
            } else if (checkedId == R.id.right) {
                Log.d("Action", "Right Gravity");
                mainLayout.setGravity(Gravity.END);
            }
        }
    }
}
