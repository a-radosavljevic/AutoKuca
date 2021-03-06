package com.javawebtutor.AutoKuca;

import com.javawebtutor.AutoKuca.Servisi.AutoKucaService;
import com.javawebtutor.AutoKuca.Servisi.BankaService;
import com.javawebtutor.AutoKuca.Servisi.Implementacije.AutoKucaServiceImpl;
import com.javawebtutor.AutoKuca.Servisi.Implementacije.BankaServiceImpl;

public class KupovinaUplatomNaZiroRacun {

	public static void main(String[] args) {
		Kupac klijent = new Kupac("1010101010101", "Petar", "Petrovic");
		
		AutoKucaService autokuca = new AutoKucaServiceImpl();
		
		Vozilo vozilo = autokuca.odabirModela();
		
		if(vozilo!=null)
		{
			BankaService banka = new BankaServiceImpl();
			Uplata uplata = banka.UplataNaZiroRacun("4616198415", klijent);
			if(uplata != null)
			{
				autokuca.potpisivanjeUgovora(0, klijent, vozilo);
				System.out.println("Uspesna kupovina vozila");
			}
			else
			{
				System.out.println("Uplata je odbijen");
			}
		}
		else
		{
			System.out.println("Odabir vozila je nevalidan");
		}

	}

}
