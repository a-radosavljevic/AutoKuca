package com.javawebtutor.AutoKuca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kredit")
public class Kredit {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="kupac")
	private String kupac;
	
	@Column(name="banka")
	private String banka;
	
	@Column(name="vozilo")
	private int vozilo;
	
	public Kredit()
	{
		this.setId(this.setVozilo(-1));
		this.setKupac("Nepoznato");
		this.setBanka("Nepoznato");
	}
	
	public Kredit(int id, String kupac, String banka, int vozilo)
	{
		this.setId(id);
		this.setKupac(kupac);
		this.setBanka(banka);
		this.setVozilo(vozilo);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		this.kupac = kupac;
	}

	public String getBanka() {
		return banka;
	}

	public void setBanka(String banka) {
		this.banka = banka;
	}

	public int getVozilo() {
		return vozilo;
	}

	public int setVozilo(int vozilo) {
		this.vozilo = vozilo;
		return vozilo;
	}

}
