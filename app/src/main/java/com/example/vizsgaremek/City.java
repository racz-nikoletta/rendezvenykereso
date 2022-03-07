package com.example.vizsgaremek;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class City extends AppCompatActivity {
    Spinner citySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        citySpinner = findViewById(R.id.citySpinner);

        String[] cities = new String[]{"Budapest", "Pécs", "Szeged", "Miskolc", "Debrecen"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, cities);
        citySpinner.setAdapter(adapter);
    }
}
