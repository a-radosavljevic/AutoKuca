package com.javawebtutor.AutoKuca.Servisi.Implementacije;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.javawebtutor.AutoKuca.Banka;
import com.javawebtutor.AutoKuca.Kredit;
import com.javawebtutor.AutoKuca.Kupac;
import com.javawebtutor.AutoKuca.Uplata;
import com.javawebtutor.AutoKuca.Vozilo;
import com.javawebtutor.AutoKuca.ZiroRacun;
import com.javawebtutor.AutoKuca.Servisi.BankaService;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(BankaService.class)
public class BankaServiceImpl implements BankaService {
	
	private static EntityManager em;
	//Banka banka;
	
	public BankaServiceImpl(){
		
		//banka = new Banka("Privredna banka", "Teslina 10", "0657894561");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KreditPU");
		em = emf.createEntityManager();
	}

	public boolean odobriKredit(Kupac k) {
		if(this.ProkupljanjePodatakaOdKupca(k)==true)
			if(k.getPrihodi()>10000 && k.isJeZaposlen()==true && k.isImaImovinu()==true)
				return true;
		return false;
	}

	public Kredit otvoriKredit(int id, Kupac k, Vozilo v) {
		Kredit kredit = null;
		if(this.odobriKredit(k)==true)
		{
			kredit = new Kredit(id, k.getJmbg(), "Banka", v.getId());
			em.getTransaction();
			em.persist(kredit);
			em.getTransaction().commit();
		}
		return kredit;
	}

	public Uplata UplataNaZiroRacun(String z, Kupac k) {
		return new Uplata(z, k);
	}

	public boolean ProkupljanjePodatakaOdKupca(Kupac k) {
		if(k!=null && k.getIme().equals("Nepoznatao") && k.getPrezime().equals("Nepoznato") && k.getJmbg().equals("Nepoznato"))
			return true;
		return false;
	}

}
