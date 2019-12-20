package com.example.myapplication.ui.share;

public class Produit {
    private String Reference;
    private String Categorie;
    private String Libelle;
    private String Marque;
    private String Prix;

    @Override
    public String toString() {
        return "Produit{" +
                "reference='" + Reference + '\'' +
                ", categorie='" + Categorie + '\'' +
                ", libelle='" + Libelle + '\'' +
                ", marque='" + Marque + '\'' +
                ", prix='" + Prix + '\'' +
                '}';
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        this.Categorie = categorie;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        this.Marque = marque;
    }

    public Produit(String reference, String categorie, String libelle, String marque, String prix) {
        this.Reference = reference;
        this.Categorie = categorie;
        this.Libelle = libelle;
        this.Marque = marque;
        this.Prix = prix;
    }

    public String getReference() {
        return Reference;
    }

    public void setReference(String reference) {
        this.Reference = reference;
    }

    public String getLibelle() {
        return Libelle;
    }

    public void setLibelle(String libelle) {
        this.Libelle = libelle;
    }

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String prix) {
        this.Prix = prix;
    }
}
