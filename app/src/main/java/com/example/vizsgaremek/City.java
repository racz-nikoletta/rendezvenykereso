package com.example.vizsgaremek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class City extends AppCompatActivity {
    ListView cityListView;
    Spinner citySpinner;
    Button cityButton;
    ArrayAdapter<CityBody> adapter;
    String[] citys = {"Összes mutatása", "Szeged", "Budapest", "Pécs", "Miskolc", "Debrecen"};

    private void initializeViews(){
        citySpinner = findViewById(R.id.citySpinner);
        citySpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citys));

        cityListView = findViewById(R.id.cityListView);
        cityListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCityBodies()));

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < citys.length){
                    getSelectedCityData(position);
                }else{
                    Toast.makeText(City.this, "A kiválasztott városban nincs esemény.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private ArrayList<CityBody> getCityBodies(){
        ArrayList<CityBody> data = new ArrayList<>();
        data.clear();

        data.add(new CityBody("Karácsonyi vásár", 1));
        data.add(new CityBody("SZIN", 1));
        data.add(new CityBody("Pályaválasztási nap", 1));
        data.add(new CityBody("Gardróbvásár", 1));
        data.add(new CityBody("Diótörő", 2));
        data.add(new CityBody("Régésztörténetek", 2));
        data.add(new CityBody("Nemzetközi töltött káposzta fesztivál", 2));
        data.add(new CityBody("RÓMEÓ ÉS JÚLIA - MUSICAL", 2));
        data.add(new CityBody("Egytemi Nyiltnapok", 3));
        data.add(new CityBody("Metronóm Jazz koncert", 3));
        data.add(new CityBody("Zsolnay Húsvét", 3));
        data.add(new CityBody("A Föld világnapja programok az Állatkertben", 3));
        data.add(new CityBody("MineCinema", 4));
        data.add(new CityBody("IV. Miskolci Retro Fesztivál", 4));
        data.add(new CityBody("Szimfonikus koncert", 4));
        data.add(new CityBody("CineFest Miskolci Nemzetközi Filmfesztivál 2022", 4));
        data.add(new CityBody("Anyák napi musical", 5));
        data.add(new CityBody("Campus fesztivál", 5));
        data.add(new CityBody("Régiségvásár", 5));
        data.add(new CityBody("Magyar Nemzeti Cirkusz Debrecenben", 5));

        return data;
    }

    private void getSelectedCityData(int categoriID)
    {
        ArrayList<CityBody> cityBodies = new ArrayList<>();
        if (categoriID == 0)
        {
         adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getCityBodies());
        }else{
            for (CityBody cityBody : getCityBodies()){
        if (cityBody.getCategoriID() == categoriID){
            cityBodies.add(cityBody);
                }
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cityBodies);
        }
        cityListView.setAdapter(adapter);
    }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_city);

            initializeViews();

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





        }
    }

    class CityBody{

        private String name;
        private int categoriID;

        public String getName() {
            return name;
        }

        public int getCategoriID() {
            return categoriID;
        }


        public CityBody(String name, int categoriID) {
            this.name = name;
            this.categoriID = categoriID;
        }

        @Override
        public String toString(){
            return name;
        }

    }

