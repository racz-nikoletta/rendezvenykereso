package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class City extends AppCompatActivity {
    Spinner citySpinner;
    Button cityButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_city);

            cityButton = findViewById(R.id.nextButton);

        citySpinner = findViewById(R.id.citySpinner);

        cityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Occasion.class);
                startActivity(intent);
                finish();
            }
        });

        String[] cities = new String[]{"Budapest", "Pécs", "Szeged", "Miskolc", "Debrecen"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities);
        citySpinner.setAdapter(adapter);



        }
    }

