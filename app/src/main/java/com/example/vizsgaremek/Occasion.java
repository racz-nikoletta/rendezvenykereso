package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class Occasion extends AppCompatActivity {
    Spinner occasionSpinner;
    Button occasionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occasion);

        occasionButton = findViewById(R.id.nextButton);

       occasionSpinner = findViewById(R.id.occasionSpinner);

        occasionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Time.class);
                startActivity(intent);
                finish();
            }
        });

        String[] occasions = new String[]{"Koncert", "Fesztivál", "Bál", "Családi nap", "Nyílt nap", "Pályaválasztási napok", "Gyereknap", "Sportesemény", "Hídi vásár", "Színházi előadás", "Múzeumi kiállítás", "Éjszakai szórakozás", "Szilveszter", "Március 15", "Majális", "Október 23", "Augusztus 20", "Karácsonyi vásár"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, occasions);
        occasionSpinner.setAdapter(adapter);
    }
}
