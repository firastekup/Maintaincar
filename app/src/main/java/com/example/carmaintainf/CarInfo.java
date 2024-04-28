package com.example.carmaintainf;

public class CarInfo {
    private String marque;
    private String modele;
    private String kilometrage;
    private String annee;

    public CarInfo() {
        // Constructeur vide requis pour Firebase
    }

    public CarInfo(String marque, String modele, String kilometrage, String annee) {
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.annee = annee;
    }

    // Getters et setters
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
}
