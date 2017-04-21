package fr.epsi.domain;

public class Reservation {
	
	int idConcert;
	int nbPlaces;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(int idConcert, int nbPlaces) {
		super();
		this.idConcert = idConcert;
		this.nbPlaces = nbPlaces;
	}

	public int getIdConcert() {
		return idConcert;
	}
	
	public void setIdConcert(int idConcert) {
		this.idConcert = idConcert;
	}
	
	public int getNbPlaces() {
		return nbPlaces;
	}
	
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	
	
}
