package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19.model.CentruVaccinare;
import com.example.covid19.model.CentruAdapter;
import com.example.covid19.model.Pacient;
import com.example.covid19.model.PacientAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    public static String KEY_CENTRE = "CENTRE";
    public static String KEY_PACIENTI = "PACIENTI";
    List<CentruVaccinare> centre = new ArrayList<>();
    List<Pacient> pacienti = new ArrayList<>();
    Intent intent;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initComponents();

        if ((centre = (ArrayList<CentruVaccinare>) intent.getSerializableExtra(KEY_CENTRE)) != null) {
            afiseazaCentre();
        } else {
            if ((pacienti = (ArrayList<Pacient>) intent.getSerializableExtra(KEY_PACIENTI)) != null) {
                afiseazaPacienti();
            }
        }

    }

    private void initComponents() {
        intent = getIntent();
        list = findViewById(R.id.alex_macrescu_list);
    }

    private void afiseazaCentre() {
        CentruAdapter adapter = new CentruAdapter(getApplicationContext(),
                R.layout.row_item_centru, centre, getLayoutInflater());
        list.setAdapter(adapter);

        list.setOnItemClickListener(deschideActivitatePacienti());
    }

    private void afiseazaPacienti() {
        PacientAdapter adapter = new PacientAdapter(getApplicationContext(),
                R.layout.row_item_pacient, pacienti, getLayoutInflater());
        list.setAdapter(adapter);
    }

    private AdapterView.OnItemClickListener deschideActivitatePacienti() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra(KEY_PACIENTI, (Serializable) centre.get(position).getPacienti());

                startActivity(intent);
            }
        };

    }
}