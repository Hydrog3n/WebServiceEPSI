package fr.epsi.domain;

public class Concert {
	
	String artiste;
	String lieu;
	
	public Concert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concert(String artiste, String lieu) {
		super();
		this.artiste = artiste;
		this.lieu = lieu;
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

}
