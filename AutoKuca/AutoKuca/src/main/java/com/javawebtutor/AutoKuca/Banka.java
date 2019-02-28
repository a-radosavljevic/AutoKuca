package com.javawebtutor.AutoKuca;


public class Banka extends PoslovnaOrganizacija {
	private Kreditno kreditno;
	
	public Banka()
	{
		super();
		setKreditno(new Kreditno());
	}
	
	public Banka(String naziv, String adresa, String kontakt)
	{
		super(naziv,adresa,kontakt);
		setKreditno(new Kreditno());
	}

	public Kreditno getKreditno() {
		return kreditno;
	}

	public void setKreditno(Kreditno kreditno) {
		this.kreditno = kreditno;
	}

}
