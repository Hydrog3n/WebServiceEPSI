package fr.epsi.domain;

public class Reservation {

    private int nbPlace;
    private String nom;
    private int id;

    public Reservation(int nbPlace, String nom) {
        this.setNbPlace(nbPlace);
        this.setNom(nom);
    }

    public Reservation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
