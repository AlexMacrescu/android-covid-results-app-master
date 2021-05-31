package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19.asyncTask.AsyncTaskRunner;
import com.example.covid19.asyncTask.Callback;
import com.example.covid19.model.CentruVaccinare;
import com.example.covid19.model.RezultateJsonParser;
import com.example.covid19.network.HttpManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_CENTRU_ADAUGAT = "CENTRU_ADAUGAT";
    public static final String URL_REZULTATE = "https://jsonkeeper.com/b/NHL7";
    public static int REQUEST_CODE_CENTRU = 201;
    private final AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner();
    List<CentruVaccinare> centre;
    Button centreBtn;
    Button adaugaCentruBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        getResultsFromHttp();

    }

    private void initComponents() {
        centreBtn = findViewById(R.id.alex_macrescu_main_centre);
        adaugaCentruBtn = findViewById(R.id.alex_macrescu_main_adauga_centru);

        centreBtn.setOnClickListener(afiseazaCentre());
        adaugaCentruBtn.setOnClickListener(adaugaCentru());

        intent = getIntent();
        CentruVaccinare centru = (CentruVaccinare) intent.getSerializableExtra(KEY_CENTRU_ADAUGAT);
        if (centru != null) {
            centre.add(centru);
        }

    }

    private View.OnClickListener adaugaCentru() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CENTRU);
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_CENTRU
                && resultCode == RESULT_OK
                && data != null) {

            CentruVaccinare centru = (CentruVaccinare) data.getSerializableExtra(KEY_CENTRU_ADAUGAT);
            centre.add(centru);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private View.OnClickListener afiseazaCentre() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListActivity.class);
                intent.putExtra(ListActivity.KEY_CENTRE, (Serializable) centre);
                startActivity(intent);
            }
        };
    }

    private void getResultsFromHttp() {
        Callable<String> asyncOperation = new HttpManager(URL_REZULTATE);
        Callback<String> mainThreadOperation = receiveResultsFromHttp();

        asyncTaskRunner.executeAsync(asyncOperation, mainThreadOperation);
    }

    private Callback<String> receiveResultsFromHttp() {
        return new Callback<String>() {
            @Override
            public void runResultOnUiThread(String result) {
                centre = new ArrayList<>();
                centre = RezultateJsonParser.centreFromJSON(result);
            }
        };
    }
}