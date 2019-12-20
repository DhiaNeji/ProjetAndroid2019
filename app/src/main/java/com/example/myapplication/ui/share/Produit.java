package com.example.myapplication.ui.share;

public class Produit {
    private String reference;
    private String libelle;
    private String prix;

    public Produit(String reference, String libelle, String prix) {
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
