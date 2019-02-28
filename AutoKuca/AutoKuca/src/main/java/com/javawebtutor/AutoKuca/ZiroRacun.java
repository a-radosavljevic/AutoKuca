package com.javawebtutor.AutoKuca;

import java.util.Date;

public class ZiroRacun {
	private String brojRacuna;
	private AutoKuca autoKuca;
	private Banka banka;
	
	public ZiroRacun(AutoKuca a, Banka b)
	{
		this.setBrojRacuna("" + Math.random()*100);
		this.setAutoKuca(a);
		this.setBanka(b);
	}

	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public AutoKuca getAutoKuca() {
		return autoKuca;
	}

	public void setAutoKuca(AutoKuca autoKuca) {
		this.autoKuca = autoKuca;
	}

	public Banka getBanka() {
		return banka;
	}

	public void setBanka(Banka banka) {
		this.banka = banka;
	}
	
}
