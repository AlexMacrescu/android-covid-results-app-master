package com.example.covid19.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.covid19.R;

import java.util.List;

public class CentruAdapter extends ArrayAdapter<CentruVaccinare> {

    private final Context context;
    private final List<CentruVaccinare> centre;
    private final LayoutInflater inflater;
    private final int resource;

    public CentruAdapter(@NonNull Context context,
                         int resource,
                         @NonNull List<CentruVaccinare> centre,
                         LayoutInflater inflater) {
        super(context, resource, centre);
        this.context = context;
        this.centre = centre;
        this.inflater = inflater;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);
        CentruVaccinare centru = centre.get(position);

        if (centru != null) {
            TextView judet = view.findViewById(R.id.alex_macrescu_centru_judet);
            populateTextView(judet, "Judet: " + centru.getJudet());

            TextView oras = view.findViewById(R.id.alex_macrescu_centru_oras);
            populateTextView(oras, "Oras: " + centru.getOras());

            TextView adresa = view.findViewById(R.id.alex_macrescu_centru_adresa);
            populateTextView(adresa, "Adresa: " + centru.getAdresa());
        }
        return view;
    }


    public void populateTextView(TextView tv, String value) {
        if (value != null && !value.trim().isEmpty()) {
            tv.setText(value);
        }
    }

}
