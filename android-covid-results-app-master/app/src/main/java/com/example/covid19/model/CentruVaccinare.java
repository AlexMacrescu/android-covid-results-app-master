package com.example.covid19.model;

import java.io.Serializable;
import java.util.List;

public class CentruVaccinare implements Serializable {

    public static final String JUDET = "judet";
    public static final String ORAS = "oras";
    public static final String ADRESA = "adresa";
    public static final String PACIENTI = "pacienti";

    private String judet;
    private String oras;
    private String adresa;
    private List<Pacient> pacienti;

    public CentruVaccinare(String judet, String oras, String adresa, List<Pacient> pacienti) {
        this.judet = judet;
        this.oras = oras;
        this.adresa = adresa;
        this.pacienti = pacienti;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Pacient> getPacienti() {
        return pacienti;
    }

    public void setPacienti(List<Pacient> pacienti) {
        this.pacienti = pacienti;
    }
}
