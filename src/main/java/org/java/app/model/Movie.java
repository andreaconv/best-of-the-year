package org.java.app.model;

public class Movie {

	private int id;
	private String titolo;
	
	//COSTRUTTORE
	public Movie(String titolo, int id) {
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
