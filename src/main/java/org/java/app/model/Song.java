package org.java.app.model;

public class Song {

	private int id;
	private String titolo;
	
	//COSTRUTTORE
	public Song (String titolo, int id) {
		setId(id);
		setTitolo(titolo);
	}

	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	//TITOLO
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	
	@Override
	public String toString() {
		return getTitolo();
	}
}
