package com.javawebtutor.AutoKuca.Servisi;

import com.javawebtutor.AutoKuca.Kredit;
import com.javawebtutor.AutoKuca.Kupac;
import com.javawebtutor.AutoKuca.Vozilo;
import com.javawebtutor.AutoKuca.ZiroRacun;
import com.javawebtutor.AutoKuca.Uplata;

public interface BankaService {
	boolean odobriKredit(Kupac k);
	Kredit otvoriKredit(int id, Kupac k, Vozilo v);
	
	Uplata UplataNaZiroRacun(String z, Kupac k);
	boolean ProkupljanjePodatakaOdKupca(Kupac k);

}
