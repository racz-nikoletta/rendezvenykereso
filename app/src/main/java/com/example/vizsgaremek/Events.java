package com.example.vizsgaremek;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Events extends AppCompatActivity {
    Spinner eventSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        eventSpinner = findViewById(R.id.eventSpinner);

        String[] events = new String[]{"Koncert", "Fesztivál", "Bál", "Családi nap", "Nyílt nap", "Pályaválasztási napok", "Gyereknap", "Sportesemény", "Hídi vásár", "Színházi előadás", "Múzeumi kiállítás", "Éjszakai szórakozás", "Szilveszter", "Március 15", "Majális", "Október 23", "Augusztus 20", "Karácsonyi vásár"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, events);
        eventSpinner.setAdapter(adapter);
    }
}
