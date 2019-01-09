package com.example.demo.entities;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.fachwerte.Geldbetrag;

public class Bestellposition {

	private int anzahlProdukte;
	private Geldbetrag preis;
	private Geldbetrag summeZuZahlen;
	private List<Product> produkteWarenkorb;
	private List<Integer> anzahlProProdukt;
	
	private List<Item> itemList;
	

	public Bestellposition() {
		this.anzahlProdukte = 0;
		this.preis = new Geldbetrag(0);
		this.summeZuZahlen = new Geldbetrag(0);
		this.produkteWarenkorb = new ArrayList<Product>();//Produkte
		this.anzahlProProdukt = new ArrayList<Integer>();//Anzahl
		
	}


	public void addiereNeuesProdukt(int anzahl, Product product) {

		
		System.out.println("[addiereNeuesProdukt] \t anzahl " + anzahl  + " produkt" + product.getName());
		
		if (produkteWarenkorb.contains(product)) {//Wenn Produkt schon in WK
			int index = produkteWarenkorb.indexOf(product);
			int tempAnzahl = anzahlProProdukt.get(index);
			anzahlProProdukt.set(index, tempAnzahl + anzahl); //Setzte die Anzhl einen hch 
			System.out.println("[anzahlProProdukt] \t" + anzahlProProdukt.get(index) );
		} else { // Prd ist nicht in WK
			produkteWarenkorb.add(product);
			anzahlProProdukt.add(anzahl);
		}
		for(int i = 0; i< anzahl; ++i) {
		summeZuZahlen.add(product.getPrice());
		}
		
		System.out.println(getAnzahlProdukte());

	}

	public String getSummeString() {

		for (Integer zwischenSumme : anzahlProProdukt) {
			summeZuZahlen.add(Geldbetrag.intconv(zwischenSumme));
		}
		System.out.println(summeZuZahlen);
		return summeZuZahlen.toBetragsstring();
	}

	public int getAnzahlProdukte() {
		
		return anzahlProProdukt.size();

	}
	
	public List<Product> getWK(){
		return produkteWarenkorb;
	}

}
