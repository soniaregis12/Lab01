package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	String parola;
	LinkedList<String> parole;
	
	public Parole() {

		parola = new String();
		parole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(this.parole, new ComparatoreParoleOrdineAlfabetico());
		return this.parole;
	}
	
	public void reset() {
		this.parole.clear();
	}

}
