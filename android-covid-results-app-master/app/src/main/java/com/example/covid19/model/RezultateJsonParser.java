package com.example.covid19.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RezultateJsonParser {

    public static Vaccinari fromJSON(String json) {
        try {

            JSONObject covid = new JSONObject(json);
            JSONObject rezultateJSON = covid.getJSONObject(Vaccinari.REZULTATE);

            int an = rezultateJSON.getInt(Vaccinari.AN);
            int nrPacienti = rezultateJSON.getInt(Vaccinari.TOTAL_PACIENTI);
            int nrCentre = rezultateJSON.getInt(Vaccinari.TOTAL_CENTRE);

            List<CentruVaccinare> centre = returneazaCentre(rezultateJSON.getJSONArray(Vaccinari.CENTRE));


            return new Vaccinari(an, nrPacienti, nrCentre, centre);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<CentruVaccinare> returneazaCentre(JSONArray jsonArray) throws JSONException {
        List<CentruVaccinare> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject centru = jsonArray.getJSONObject(i);

            String judet = centru.getString(CentruVaccinare.JUDET);
            String oras = centru.getString(CentruVaccinare.ORAS);
            String adresa = centru.getString(CentruVaccinare.ADRESA);

            List<Pacient> pacienti = returneazaPacienti(centru.getJSONArray(CentruVaccinare.PACIENTI));

            list.add(new CentruVaccinare(judet, oras, adresa, pacienti));
        }
        return list;
    }

    private static ArrayList<Pacient> returneazaPacienti(JSONArray jsonArray) throws JSONException {
        List<Pacient> list = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject pacient = jsonArray.getJSONObject(i);

            String nume = pacient.getString(Pacient.NUME);
            boolean rezultat = pacient.getString(Pacient.REZULTAT).equals("pozitiv");
            String telefon = pacient.getString(Pacient.TELEFON);
            String cnp = pacient.getString(Pacient.CNP);

            list.add(new Pacient(nume, rezultat, telefon, cnp));

        }

        return new ArrayList<>(list);
    }


    public static List<CentruVaccinare> centreFromJSON(String json) {
        try {
            JSONObject covid = new JSONObject(json);
            JSONObject rezultateJSON = covid.getJSONObject(Vaccinari.REZULTATE);
            JSONArray centre = rezultateJSON.getJSONArray(Vaccinari.CENTRE);

            return returneazaCentre(centre);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

