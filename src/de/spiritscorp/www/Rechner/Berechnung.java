package de.spiritscorp.www.Rechner;

import java.util.ArrayList;

public class Berechnung {
	
	private ArrayList<Double> eingabeListe;
	private ArrayList<Character> operatorListe;
	private ArrayList<Double> zwischenErgebnis;
	private Var var;

	public Berechnung(Var var) {
		eingabeListe = new ArrayList<>();
		operatorListe = new ArrayList<>();
		zwischenErgebnis = new ArrayList<>();
		this.var = var;
	}
	
/** 	
 * 		Speichert die eingegebene Zahl in einer Liste ab, prüft ob es die letzte Zahl war, ansonsten wird der Operator auch gespeichert und
*		es wird geprüft ob es schon ein Zwischenergebnis gibt mit dem weitergerechnet werden kann 
*		Ist es die letzte Zahl, wird auch wieder anhand der Länge der Eingabeliste entschieden, ob es mit dem Zwischenergebnis weiter geht
*/
	void setEingabe(Double eingabe, Character operator) {
		eingabeListe.add(eingabe);
		if(operator != '=') {
			operatorListe.add(operator);
			if(eingabeListe.size() ==2) {
				switch (operatorListe.get(operatorListe.size()-2)){
					case '+':	addieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '-':	subtrahieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '*':	multiplizieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '/':	dividieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
				}
			}
			if(eingabeListe.size() > 2) {
				switch (operatorListe.get(operatorListe.size()-2)){
					case '+':	addieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '-':	subtrahieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '*':	multiplizieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '/':	dividieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
				}
			}
		}else {
			if(eingabeListe.size() == 1) {
				zwischenErgebnis.add(eingabe);
			}else if(eingabeListe.size() ==2) {
				switch (operatorListe.get(operatorListe.size()-1)){
					case '+':	addieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '-':	subtrahieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '*':	multiplizieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '/':	dividieren(eingabeListe.get(eingabeListe.size()-2), eingabeListe.get(eingabeListe.size() -1));
									break;
				}
			}else if(eingabeListe.size() > 2) {
				switch (operatorListe.get(operatorListe.size()-1)){
					case '+':	addieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '-':	subtrahieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '*':	multiplizieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
					case '/':	dividieren(zwischenErgebnis.get(zwischenErgebnis.size()-1), eingabeListe.get(eingabeListe.size() -1));
									break;
				}
			}
		}
	}
	
	void addieren(Double zahl1, Double zahl2) {
		zwischenErgebnis.add(zahl1 + zahl2);
	}
	
	void subtrahieren(Double zahl1, Double zahl2) {
		zwischenErgebnis.add(zahl1 - zahl2);
	}	
	
	void multiplizieren(Double zahl1, Double zahl2) {
		zwischenErgebnis.add(zahl1 * zahl2);
	}	
	
	void dividieren(Double zahl1, Double zahl2) {
		zwischenErgebnis.add(zahl1 / zahl2);
	}

	public double potenzieren(int potenz, double basis) {
		double ergebnis = basis;		
		for(int i =1;i<potenz;i++) {
					ergebnis *= basis;
		}
		return ergebnis;
	}

	public double prozent(double zahl) {
		return zahl / 100;
	}
	
//	Gibt das aktuelle Zwischenergebnis zurück
	String getZwischenErgebnis() {
		if(zwischenErgebnis.size() == 0) {
			return new String("");
		}else {
			return zwischenErgebnis.toString().replace('.', ',');
		}
	}
	
//	Liefert das Ergebnis zurück und speichert es als Verlauf ab
	String getErgebnis() {
		if(zwischenErgebnis.size() == 0) {
			eingabeListe.clear();
			return new String("");
		}else {
			new Verlauf(var).verlaufSpeichern(eingabeListe, operatorListe, zwischenErgebnis.get(zwischenErgebnis.size()-1));
			String str = zwischenErgebnis.get(zwischenErgebnis.size() -1).toString().replace('.', ',');
			zurucksetzen();
			return str;
		}		
	}
	
//	Setzt alle Listen zurück
	void zurucksetzen() {
		zwischenErgebnis.clear();
		eingabeListe.clear();
		operatorListe.clear();
		
	}

	public double wurzel(double basis) {
		return Math.sqrt(basis);
	}

}
