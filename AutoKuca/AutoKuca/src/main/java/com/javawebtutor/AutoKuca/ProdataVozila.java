package com.javawebtutor.AutoKuca;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prodatavozila")
public class ProdataVozila {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="kupac")
	private String kupac;
	
	@Column(name="vozilo")
	private int vozilo;
	
	public ProdataVozila()
	{
		this.setId(this.setVozilo(-1));
		this.setKupac("Nepoznato");
	}
	
	public ProdataVozila(int id, String kupac, int vozilo)
	{
		this.setId(id);
		this.setKupac(kupac);
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

	public int getVozilo() {
		return vozilo;
	}

	public int setVozilo(int vozilo) {
		this.vozilo = vozilo;
		return vozilo;
	}

}
