package com.javawebtutor.AutoKuca;

import com.javawebtutor.AutoKuca.Servisi.AutoKucaService;
import com.javawebtutor.AutoKuca.Servisi.BankaService;
import com.javawebtutor.AutoKuca.Servisi.Implementacije.AutoKucaServiceImpl;
import com.javawebtutor.AutoKuca.Servisi.Implementacije.BankaServiceImpl;

public class KupovinaGotovinom {

	public static void main(String[] args) {
		Kupac klijent = new Kupac("1010101010101", "Petar", "Petrovic");
		
		AutoKucaService autokuca = new AutoKucaServiceImpl();
		
		autokuca.uplataGotovinom(klijent);
		
		Vozilo vozilo = autokuca.odabirModela();
		
		if(vozilo!=null)
		{
				autokuca.potpisivanjeUgovora(0, klijent, vozilo);
				System.out.println("Uspesna kupovina vozila");
		}
		else
		{
			System.out.println("Odabir vozila je nevalidan");
		}

	}

}
