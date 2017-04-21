package fr.epsi.domain;

public class Concert {
	
	int id;
	String artiste;
	String lieu;
	
	public Concert() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Concert(int id, String artiste, String lieu) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
