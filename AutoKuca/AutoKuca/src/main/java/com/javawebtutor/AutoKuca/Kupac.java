package com.javawebtutor.AutoKuca;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kupac")
public class Kupac{
	
	@Id
	@Column(name="jmbg")
	private String jmbg;
	
	@Column(name="prezime")
	private String prezime;
	
	@Column(name="ime")
	private String ime;
	
	private int prihodi;
	
	private boolean jeZaposlen;
	
	private boolean imaImovinu;
	
	public Kupac()
	{
		this.setIme("Nepoznato");
		this.setPrezime("Nepoznato");
		this.setJmbg("Nepoznato");
		
		this.prihodi=100000;
		this.jeZaposlen=true;
		this.imaImovinu=true;
	}
	
	public Kupac(String jmbg, String ime, String prezime)
	{
		this.setJmbg(jmbg);
		this.setIme(ime);
		this.setPrezime(prezime);

		this.prihodi=100000;
		this.jeZaposlen=true;
		this.imaImovinu=true;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getPrihodi() {
		return prihodi;
	}

	public void setPrihodi(int prihodi) {
		this.prihodi = prihodi;
	}

	public boolean isJeZaposlen() {
		return jeZaposlen;
	}

	public void setJeZaposlen(boolean jeZaposlen) {
		this.jeZaposlen = jeZaposlen;
	}

	public boolean isImaImovinu() {
		return imaImovinu;
	}

	public void setImaImovinu(boolean imaImovinu) {
		this.imaImovinu = imaImovinu;
	}

}
