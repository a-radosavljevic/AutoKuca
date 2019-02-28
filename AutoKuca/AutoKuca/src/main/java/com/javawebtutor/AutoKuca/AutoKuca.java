package com.javawebtutor.AutoKuca;

import java.util.ArrayList;

public class AutoKuca extends PoslovnaOrganizacija {

	private ArrayList<Vozilo> vozila;
	
	public AutoKuca()
	{
		super();
		setVozila(new ArrayList<Vozilo>());
	}
	
	public AutoKuca(String naziv, String adresa, String kontakt)
	{
		super(naziv,adresa,kontakt);
		setVozila(new ArrayList<Vozilo>());
	}

	public ArrayList<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(ArrayList<Vozilo> vozila) {
		this.vozila = vozila;
	}
}
