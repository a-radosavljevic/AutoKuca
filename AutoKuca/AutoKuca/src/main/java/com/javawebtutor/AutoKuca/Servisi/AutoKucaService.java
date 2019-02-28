package com.javawebtutor.AutoKuca.Servisi;

import com.javawebtutor.AutoKuca.Kupac;
import com.javawebtutor.AutoKuca.ProdataVozila;
import com.javawebtutor.AutoKuca.Uplata;
import com.javawebtutor.AutoKuca.Vozilo;

public interface AutoKucaService {
	
	boolean uplataGotovinom(Kupac k);
	Vozilo odabirModela();
	boolean uplataNaZiroRacun(Uplata u);
	boolean preuzimanjeVozila(int id, Kupac k, Vozilo v);
	boolean potpisivanjeUgovora(int id, Kupac k, Vozilo v);
	Kupac noviKlijent(String jmbg, String ime, String prezime);

}
