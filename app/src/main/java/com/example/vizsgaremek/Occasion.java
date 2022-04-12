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

public class Occasion extends AppCompatActivity {
    ListView occasionListView;
    Spinner occasionSpinner;
    Button occasionButton;
    ArrayAdapter<OccasionBody> adapter;
    String[] occasions = {"Összes mutatása", "Koncert", "Fesztivál", "Nyílt nap", "Pályaválasztási napok", "Vásár", "Színházi előadás", "Múzeumi kiállítás", "Program a szabadban", "Mozi", "Cirkusz"};

    private void initializeViews(){
        occasionSpinner = findViewById(R.id.occasionSpinner);
        occasionSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, occasions));

        occasionListView = findViewById(R.id.occasionListView);
        occasionListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getOccasionBodies()));

        occasionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < occasions.length){
                    getSelectedOccasionData(position);
                }else{
                    Toast.makeText(Occasion.this, "A kiválasztott fajtában nincsenek rendezvények.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private ArrayList<OccasionBody> getOccasionBodies(){
        ArrayList<OccasionBody> data = new ArrayList<>();
        data.clear();

        data.add(new OccasionBody("Karácsonyi vásár", 5));
        data.add(new OccasionBody("SZIN", 2));
        data.add(new OccasionBody("Pályaválasztási nap", 4));
        data.add(new OccasionBody("Gardróbvásár", 5));
        data.add(new OccasionBody("Diótörő", 6));
        data.add(new OccasionBody("Régésztörténetek", 7));
        data.add(new OccasionBody("Nemzetközi töltött káposzta fesztivál", 2));
        data.add(new OccasionBody("RÓMEÓ ÉS JÚLIA - MUSICAL", 6));
        data.add(new OccasionBody("Egytemi Nyiltnapok", 3));
        data.add(new OccasionBody("Metronóm Jazz koncert", 1));
        data.add(new OccasionBody("Zsolnay Húsvét", 7));
        data.add(new OccasionBody("A Föld világnapja programok az Állatkertben", 7));
        data.add(new OccasionBody("MineCinema", 8));
        data.add(new OccasionBody("IV. Miskolci Retro Fesztivál", 2));
        data.add(new OccasionBody("Szimfonikus koncert", 1));
        data.add(new OccasionBody("CineFest Miskolci Nemzetközi Filmfesztivál 2022",2 ));
        data.add(new OccasionBody("Anyák napi musical", 6));
        data.add(new OccasionBody("Campus fesztivál", 2));
        data.add(new OccasionBody("Régiségvásár", 5));
        data.add(new OccasionBody("Magyar Nemzeti Cirkusz Debrecenben", 9));

        return data;
    }

    private void getSelectedOccasionData(int categoriID)
    {
        ArrayList<OccasionBody> occasionBodies = new ArrayList<>();
        if (categoriID == 0)
        {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getOccasionBodies());
        }else{
            for (OccasionBody occasionBody : getOccasionBodies()){
                if (occasionBody.getCategoriID() == categoriID){
                    occasionBodies.add(occasionBody);
                }
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, occasionBodies);
        }
        occasionListView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occasion);

        initializeViews();

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


    }
}

class OccasionBody{

    private String name;
    private int categoriID;

    public String getName() {
        return name;
    }

    public int getCategoriID() {
        return categoriID;
    }


    public OccasionBody(String name, int categoriID) {
        this.name = name;
        this.categoriID = categoriID;
    }

    @Override
    public String toString(){
        return name;
    }

}
