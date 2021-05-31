package com.example.covid19.model;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.covid19.R;

import java.util.List;

public class PacientAdapter extends ArrayAdapter<Pacient> {
    private final Context context;
    private final List<Pacient> pacienti;
    private final LayoutInflater inflater;
    private final int resource;

    public PacientAdapter(@NonNull Context context,
                          int resource,
                          @NonNull List<Pacient> pacienti,
                          LayoutInflater inflater) {
        super(context, resource, pacienti);
        this.context = context;
        this.pacienti = pacienti;
        this.inflater = inflater;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);
        Pacient pacient = pacienti.get(position);

        if (pacient != null) {
            TextView nume = view.findViewById(R.id.alex_macrescu_pacient_nume);
            populateTextView(nume, "Nume: " + pacient.getNume());

            TextView telefon = view.findViewById(R.id.alex_macrescu_pacient_telefon);
            populateTextView(telefon, "Numar telefon: " + pacient.getTelefon());

            TextView cnp = view.findViewById(R.id.alex_macrescu_pacient_cnp);
            populateTextView(cnp, "CNP: " + pacient.getCnp());

            TextView rezultat = view.findViewById(R.id.alex_macrescu_pacient_rezultat);
            populateTextView(rezultat, "Rezultat: " + (pacient.getRezultat() ? "POZITIV" : "NEGATIV"));

            if (pacient.getRezultat()) {
                rezultat.setTextColor(Color.argb(100, 0, 255, 0));
            }
        }


        return view;
    }

    public void populateTextView(TextView tv, String value) {
        if (value != null && !value.trim().isEmpty()) {
            tv.setText(value);
        }
    }
}
