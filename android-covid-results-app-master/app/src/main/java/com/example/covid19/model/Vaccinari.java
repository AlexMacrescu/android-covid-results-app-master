package com.example.covid19.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Vaccinari {

    public static final String REZULTATE = "rezultate";
    public static final String AN = "an";
    public static final String TOTAL_PACIENTI = "totalPacienti";
    public static final String TOTAL_CENTRE = "totalCentre";
    public static final String CENTRE = "centre";
    public static final String TIPURI_VACCINE = "tipuriVaccine";
    public static final String  PFIZER = "pfizer";
    public static final String  ASTRA_ZENECA = "astra_Zeneca";
    public static final String MODERNA = "moderna";

    //private int an;
    private int nrPacienti;
    private int nrCentre;
    private List<CentruVaccinare> centre;

    public Vaccinari(int an,
                     int nrPacienti,
                     int nrCentre,
                     List<CentruVaccinare> centre) {
       // this.an = an;
        this.nrPacienti = nrPacienti;
        this.nrCentre = nrCentre;
        this.centre = centre;
    }

   /* public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }
*/
    public int getNrPacienti() {
        return nrPacienti;
    }

    public void setNrPacienti(int nrPacienti) {
        this.nrPacienti = nrPacienti;
    }

    public int getNrCentre() {
        return nrCentre;
    }

    public void setNrCentre(int nrCentre) {
        this.nrCentre = nrCentre;
    }

    public List<CentruVaccinare> getCentre() {
        return centre;
    }

    public void setCentre(List<CentruVaccinare> centre) {
        this.centre = centre;
    }

    @NonNull
    @Override
    public String toString() {
        String text = "";
        //text += "An:" + an + "\n";
        text += "Nr pacienti: " + nrPacienti + "\n";
        text += "Nr centre: " + nrCentre + "\n";
        for (int i = 0; i < centre.size(); i++) {
            text += "Centru " + i + ": " + centre.get(i).getOras()
                    + " " + centre.get(i).getJudet()
                    + " " + centre.get(i).getOras()
                    + " " + centre.get(i).getAdresa();

            for (int j = 0; j < centre.get(j).getPacienti().size(); i++) {
                text += "\tPacient " + j + ": "
                        + centre.get(j).getPacienti().get(i).getNume()
                        + " " + centre.get(j).getPacienti().get(i).getRezultat()
                        + " " + centre.get(j).getPacienti().get(i).getTelefon()
                        + " " + centre.get(j).getPacienti().get(i).getCnp()
                        + "\n";
            }
        }
        return text;
    }
}
