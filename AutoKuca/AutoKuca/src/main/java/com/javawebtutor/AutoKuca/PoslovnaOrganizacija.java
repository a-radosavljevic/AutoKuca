package com.javawebtutor.AutoKuca;

public class PoslovnaOrganizacija {
	private String naziv;
	private String adresa;
	private String kontakt;
	
	private Blagajna blagajna;
	private Administracija administracija;
	private Pravnicko pravnicko;
	
	public PoslovnaOrganizacija()
	{
		this.setNaziv("Nepoznato");
		this.setAdresa("Nepoznato");
		this.setKontakt("Nepoznato");
		
		blagajna = new Blagajna();
		administracija = new Administracija();
		pravnicko = new Pravnicko();
		
	}
	
	public PoslovnaOrganizacija(String naziv, String adresa, String kontakt)
	{
		this.setNaziv(naziv);
		this.setAdresa(adresa);
		this.setKontakt(kontakt);
		
		blagajna = new Blagajna();
		administracija = new Administracija();
		pravnicko = new Pravnicko();
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
