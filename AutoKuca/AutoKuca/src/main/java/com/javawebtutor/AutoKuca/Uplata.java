package com.javawebtutor.AutoKuca;

public class Uplata {
	
	private String ziroRacun;
	private Kupac kupac;
	private boolean validnaUplata;
	
	private Uplata()
	{
		this.setZiroRacun(null);
		this.setKupac(null);
		this.setValidnaUplata(false);
	}
	
	public Uplata(String z, Kupac k)
	{
		this.setZiroRacun(z);
		this.setKupac(k);
		this.setValidnaUplata(true);
	}

	public String getZiroRacun() {
		return ziroRacun;
	}

	public void setZiroRacun(String z) {
		this.ziroRacun = z;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

	public boolean isValidnaUplata() {
		return validnaUplata;
	}

	public void setValidnaUplata(boolean validnaUplata) {
		this.validnaUplata = validnaUplata;
	}

}
