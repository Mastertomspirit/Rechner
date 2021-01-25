package de.spiritscorp.www.Rechner;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Berechnung {
	
	private ArrayList<Character> operatorListe;
	private ArrayList<BigDecimal> eingabeListe, zwischenErgebnis;
	private Var var;

	public Berechnung(Var var) {
		operatorListe = new ArrayList<>();
		eingabeListe = new ArrayList<>();
		zwischenErgebnis = new ArrayList<>();
		this.var = var;
	}
	
/** 	
 * 		Speichert die eingegebene Zahl in einer Liste ab, prüft ob es die letzte Zahl war, ansonsten wird der Operator auch gespeichert und
*		es wird geprüft ob es schon ein Zwischenergebnis gibt mit dem weitergerechnet werden kann 
*		Ist es die letzte Zahl, wird auch wieder anhand der Länge der Eingabeliste entschieden, ob es mit dem Zwischenergebnis weiter geht
*/
	

	void setEingabe(BigDecimal bigDecimal, Character operator) {
		eingabeListe.add(bigDecimal);
		if(operator != '=') {
			operatorListe.add(operator);
			if(eingabeListe.size() ==2) {
				switch(operatorListe.get(operatorListe.size()-2)) {
					case '+': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).add(eingabeListe.get(eingabeListe.size()-1)));
									break;
					case '-': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).subtract(eingabeListe.get(eingabeListe.size()-1)));
									break;
					case '*': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).multiply(eingabeListe.get(eingabeListe.size()-1)));
									break;
					case '/': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).divide(eingabeListe.get(eingabeListe.size()-1)));
									break;
				}
			}
			if(eingabeListe.size() > 2) {
				switch(operatorListe.get(operatorListe.size()-2)) {
				case '+': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).add(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '-': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).subtract(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '*': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).multiply(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '/': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).divide(eingabeListe.get(eingabeListe.size()-1)));
								break;
				}
			}
		}else {
			if(eingabeListe.size() == 1) {
				zwischenErgebnis.add(bigDecimal);
			}else if(eingabeListe.size() ==2) {
				switch (operatorListe.get(operatorListe.size()-1)){
				case '+': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).add(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '-': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).subtract(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '*': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).multiply(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '/': 	zwischenErgebnis.add(eingabeListe.get(eingabeListe.size()-2).divide(eingabeListe.get(eingabeListe.size()-1)));
								break;
				}		
			}else if(eingabeListe.size() > 2) {
				switch(operatorListe.get(operatorListe.size()-1)) {
				case '+': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).add(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '-': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).subtract(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '*': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).multiply(eingabeListe.get(eingabeListe.size()-1)));
								break;
				case '/': 	zwischenErgebnis.add(zwischenErgebnis.get(zwischenErgebnis.size()-1).divide(eingabeListe.get(eingabeListe.size()-1)));
								break;
				}
			}
		}
	}
	
	public String prozent(BigDecimal bigDecimal) {
		return bigDecimal.divide(new BigDecimal("100")).toString();
	}

	public String wurzel(BigDecimal bigDecimal) {
		return bigDecimal.sqrt(MathContext.DECIMAL64).toString();
	}

	public String potenzieren(int potenz, BigDecimal bigDecimal) {
		return bigDecimal.pow(potenz).toString();
	}
	
//	Gibt das aktuelle Zwischenergebnis zurück
	String getZwischenErgebnis() {
		if(zwischenErgebnis.size() == 0) {
			return new String("");
		}else {
			return zwischenErgebnis.toString();
		}
	}
	
//	Liefert das Ergebnis zurück und speichert es als Verlauf ab
	String getErgebnis() {
		if(zwischenErgebnis.size() == 0) {
			eingabeListe.clear();
			return new String("");
		}else {
			new Verlauf(var).verlaufSpeichern(eingabeListe, operatorListe, zwischenErgebnis.get(zwischenErgebnis.size()-1));
			String str = zwischenErgebnis.get(zwischenErgebnis.size() -1).toString();
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
}
