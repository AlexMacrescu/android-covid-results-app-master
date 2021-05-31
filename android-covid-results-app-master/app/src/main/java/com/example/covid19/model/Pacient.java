package com.example.covid19.model;

import java.io.Serializable;

public class Pacient implements Serializable {

    public static final String NUME = "nume";
    public static final String REZULTAT = "rezultat";
    public static final String TELEFON = "telefon";
    public static final String CNP = "CNP";

    private String nume;
    private boolean rezultat;
    private String telefon;
    private String cnp;

    public Pacient(String nume, boolean rezultat, String telefon, String cnp) {
        this.nume = nume;
        this.rezultat = rezultat;
        this.telefon = telefon;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public boolean getRezultat() {
        return rezultat;
    }

    public boolean isRezultat() {
        return rezultat;
    }

    public void setRezultat(boolean rezultat) {
        this.rezultat = rezultat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }
}
