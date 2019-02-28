package com.javawebtutor.AutoKuca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vozilo")
public class Vozilo {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="proizvodjac")
	private String proizvodjac;
	
	@Column(name="model")
	private String model;
	
	public Vozilo()
	{
		this.id = -1;
		this.proizvodjac="Nepoznato";
		this.model="Nepoznato";
	}
	public Vozilo(int id, String proiz, String model)
	{
		this.id = id;
		this.proizvodjac=proiz;
		this.model=model;
	}
	
	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
