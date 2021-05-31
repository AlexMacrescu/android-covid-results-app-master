package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covid19.model.CentruVaccinare;
import com.example.covid19.model.Pacient;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    TextInputEditText judet;
    TextInputEditText oras;
    TextInputEditText adresa;

    TextInputEditText nume;
    TextInputEditText telefon;
    TextInputEditText cnp;
    Switch rezultat;

    Button adaugaPacient;
    Button adaugaCentru;

    CentruVaccinare centru;
    List<Pacient> pacienti;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initComponents();
    }

    private void initComponents() {

        judet = findViewById(R.id.alex_macrescu_tiet_judet);
        oras = findViewById(R.id.alex_macrescu_tiet_oras);
        adresa = findViewById(R.id.alex_macrescu_tiet_adresa);

        nume = findViewById(R.id.alex_macrescu_tiet_pacient_nume);
        telefon = findViewById(R.id.alex_macrescu_tiet_pacient_telefon);
        cnp = findViewById(R.id.alex_macrescu_tiet_pacient_cnp);
        rezultat = findViewById(R.id.alex_macrescu_pacient_rezultat);

        adaugaPacient = findViewById(R.id.alex_macrescu_btn_adauga_pacient);
        adaugaCentru = findViewById(R.id.alex_macrescu_btn_adauga);

        pacienti = new ArrayList<>();

        adaugaPacient.setOnClickListener(adaugaPacient());
        adaugaCentru.setOnClickListener(adaugaCentru());
    }

    private View.OnClickListener adaugaPacient() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numePacient = String.valueOf(nume.getText());
                String telefonPacient = String.valueOf(telefon.getText());
                String cnpPacient = String.valueOf(cnp.getText());
                boolean rezultatPacient = rezultat.isChecked();

                pacienti.add(new Pacient(numePacient, rezultatPacient, telefonPacient, cnpPacient));

                nume.setText("");
                telefon.setText("");
                cnp.setText("");
                rezultat.setChecked(false);

            }
        };
    }

    private View.OnClickListener adaugaCentru() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                if (judet.getText().toString().length() != 0
                        && oras.getText().toString().length() != 0
                        && adresa.getText().toString().length() != 0) {

                    String j = String.valueOf(judet.getText());
                    String o = String.valueOf(oras.getText());
                    String a = String.valueOf(adresa.getText());

                    centru = new CentruVaccinare(j, o, a, pacienti);

                    intent.putExtra(MainActivity.KEY_CENTRU_ADAUGAT, centru);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        };
    }


}
