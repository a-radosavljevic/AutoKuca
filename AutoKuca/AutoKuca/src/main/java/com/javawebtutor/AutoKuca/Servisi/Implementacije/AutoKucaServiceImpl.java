package com.javawebtutor.AutoKuca.Servisi.Implementacije;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.javawebtutor.AutoKuca.Kupac;
import com.javawebtutor.AutoKuca.ProdataVozila;
import com.javawebtutor.AutoKuca.Uplata;
import com.javawebtutor.AutoKuca.Vozilo;
import com.javawebtutor.AutoKuca.Servisi.AutoKucaService;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(AutoKucaService.class)
public class AutoKucaServiceImpl implements AutoKucaService {
	
	private static EntityManager emVozilo;
	private static EntityManager emKupac;
	private static EntityManager emProdataVozila;
	
	private boolean jePlaceno;
	private boolean preuzetoVozilo;
	
	public AutoKucaServiceImpl(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AutoKucaPU");
		emKupac = emf.createEntityManager();
		
		emf = Persistence.createEntityManagerFactory("AutoKucaPU");
		emVozilo = emf.createEntityManager();
		
		emf = Persistence.createEntityManagerFactory("AutoKucaPU");
		emProdataVozila = emf.createEntityManager();
		
		this.jePlaceno = false;
		this.preuzetoVozilo = false;
	}

	public boolean uplataGotovinom(Kupac k) {
		if(k.getJmbg().equals("Nepoznato") || k.getIme().equals("Nepoznato") || k.getPrezime().equals("Nepoznato"))
			return false;
		this.jePlaceno=true;
		return true;
	}

	public Vozilo odabirModela() {
		Vozilo v = null;
		if(this.jePlaceno == true)
		{
			Scanner s = new Scanner(System.in);
			int idVozila;
			System.out.println("Unesite id vozila:");
			idVozila = s.nextInt();
			v = this.emVozilo.find(Vozilo.class, idVozila);
		}
		return v;
	}

	public boolean uplataNaZiroRacun(Uplata u) {
		if(u.isValidnaUplata()==true)
		{
			this.jePlaceno=true;
			return true;
		}
		return false;
	}

	public boolean preuzimanjeVozila(int id, Kupac k, Vozilo v) {
		this.emVozilo.getTransaction().begin();
		this.emVozilo.remove(v);
		this.emVozilo.getTransaction().commit();
		
		ProdataVozila p = new ProdataVozila(id, k.getJmbg(), v.getId());
		this.emProdataVozila.getTransaction().begin();
		this.emProdataVozila.persist(p);
		this.emProdataVozila.getTransaction().commit();
		
		this.preuzetoVozilo=true;
		return true;
	}

	public boolean potpisivanjeUgovora(int id, Kupac k, Vozilo v) {
		if(this.jePlaceno==true)
		{
			this.emKupac.getTransaction().begin();
			this.emKupac.persist(k);
			this.emKupac.getTransaction().commit();
			
			this.preuzimanjeVozila(id, k, v);
			return true;
		}
		return false;
	}

	@Override
	public Kupac noviKlijent(String jmbg, String ime, String prezime) {
		Kupac k = new Kupac(jmbg,ime,prezime);
		this.emKupac.getTransaction().begin();
		this.emKupac.remove(k);
		this.emKupac.getTransaction().commit();
		
		return k;
	}

}
