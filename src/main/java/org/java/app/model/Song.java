package org.java.app.model;

public class Song {

	static private int id = 0;
	private String titolo;
	
	//COSTRUTTORE
	public Song (String titolo, int id) {
		setId(id);
		setTitolo(titolo);
	}

	//ID
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Song.id = id;
	}

	//TITOLO
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
