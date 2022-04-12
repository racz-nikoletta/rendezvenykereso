package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


public class Time extends AppCompatActivity {
    Button timeButton;
    CalendarView dateCalendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        timeButton = findViewById(R.id.findButton);

        dateCalendarView = findViewById(R.id.dateCalendarView);

       /* dateCalendarView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String spinnerValue = dateCalendarView.getSelectedItem().toString();
            }
        });*/


        dateCalendarView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();

            }

        });
    }
}


