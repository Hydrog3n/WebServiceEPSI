package fr.epsi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Concert {

    private String artiste;
    private String lieu;
    private Date date;
    private int id;
    private int nbPlace;
    private double prix;
    private List<Reservation> listReservation = new ArrayList<Reservation>();

    public Concert(String a, String l, Date d, int pl, int prix) {
        this.setArtiste(a);
        this.setDate(d);
        this.setLieu(l);
        this.setNbPlace(pl);
        this.setPrix(prix);
    }

    public Concert() {

    };


    public Reservation updateReservation(Reservation newResa) {
        this.nbPlace += this.getReservationWithId(newResa.getId()).getNbPlace();
        this.nbPlace -= newResa.getNbPlace();
        return this.listReservation.set(this.getIndexReservationWithId(newResa.getId()), newResa);
    }

    public Reservation getReservationWithId(int idResa) {
        Reservation r = new Reservation();
        for (Reservation resa : this.listReservation) {
            if (idResa == resa.getId()) {
                r = resa;
                break;
            }
        }
        return r;
    }

    private int getIndexReservationWithId(int idResa) {
        int index = 0;
        for (Reservation r : this.listReservation) {
            if (idResa == r.getId()) {
                break;
            }
            index++;
        }
        return index;
    }

    public int deleteReservationWithId(int idResa) {
        this.listReservation.remove(this.getIndexReservationWithId(idResa));
        return 201;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List getReservations() {
        return this.listReservation;
    }

    public Reservation addReservation(Reservation r) {
        r.setId(this.listReservation.size());
        this.listReservation.add(r);
        this.nbPlace -= r.getNbPlace();
        return r;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public double getPrix() {
        return prix;
    }
}
