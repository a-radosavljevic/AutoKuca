package com.javawebtutor.AutoKucaKlijent;

import com.javawebtutor.*;
import com.javawebtutor.AutoKuca.Kupac;
import com.javawebtutor.AutoKuca.Vozilo;

import java.util.Hashtable;
import java.util.Scanner;

import javax.naming.*;

public class AutoKucaKlijent {
	public static void main(String[] args) throws Exception
	{	try {
		System.out.println(AutoKucaService.class.getName());
		System.out.println("Server je pokrenut");
		
		invokeStatelessBean();
		}
		catch(Exception e)
		{System.out.println(e.toString()+e.getMessage());}
	}
	private static void invokeStatelessBean() throws NamingException
	{
		final AutoKucaService statelessAutoKucaService= (AutoKucaService)lookupRemoteStatelessServicee();

		String jmbg, ime, prezime;
		Scanner s = new Scanner(System.in);
		jmbg=s.nextLine();
		ime=s.nextLine();
		prezime=s.nextLine();
		
		statelessAutoKucaService.noviKlijent(jmbg,ime,prezime);
		System.out.println("1)Uplata gotovinom 2)Uplata na ziro racun 3)Uplata kreditom");
		int br = s.nextInt();
		if(br==1)
		{
			statelessAutoKucaService.uplataGotovinom();
			statelessAutoKucaService.potpisivanjeUgovora(0, statelessAutoKucaService.noviKlijent(jmbg,ime,prezime), statelessAutoKucaService.odabirModela());
			System.out.println("Uspesna kupovina");
		}
		if(br==2)
		{
			final BankaService statelessBankaService= (BankaService)lookupRemoteStatelessServicee();
			statelessAutoKucaService.uplataNaZiroRacun(BankaService.UplataNaZiroRacun("10101020", statelessAutoKucaService.noviKlijent(jmbg,ime,prezime)));
			statelessAutoKucaService.potpisivanjeUgovora(0, statelessAutoKucaService.noviKlijent(jmbg,ime,prezime), statelessAutoKucaService.odabirModela());
			System.out.println("Uspesna kupovina");
		}
		if(br==3)
		{
			final BankaService statelessBankaService= (BankaService)lookupRemoteStatelessServicee();
			statelessBankaService.otvoriKredit(0, statelessAutoKucaService.noviKlijent(jmbg,ime,prezime), statelessAutoKucaService.odabirModela());
			statelessAutoKucaService.potpisivanjeUgovora(0, statelessAutoKucaService.noviKlijent(jmbg,ime,prezime), statelessAutoKucaService.odabirModela());
			System.out.println("Uspesna kupovina");
		}
		else
		{
			System.out.println("Pogresna opcija");
		}
		
				
		
	}
	private static AutoKucaService lookupRemoteStatelessServicee() throws NamingException
	{
		System.out.println("pokrenut lookup");
		final Hashtable<String,String> jndiProperties=new Hashtable<>();
		
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        System.out.println(context.toString());
        return (AutoKucaService) context.lookup("ejb:/AutoKuca-0.0.1-SNAPSHOT/AutoKucaServiceImpl"
                + AutoKucaService.class.getName());
		
	}
	private static BankaService lookupRemoteStatelessServicee() throws NamingException
	{
		System.out.println("pokrenut lookup");
		final Hashtable<String,String> jndiProperties=new Hashtable<>();
		
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        System.out.println(context.toString());
        return (BankaService) context.lookup("ejb:/AutoKuca-0.0.1-SNAPSHOT/BankaServiceImpl"
                + BankaService.class.getName());
		
	}
}
