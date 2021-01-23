package de.spiritscorp.www.Rechner;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

public class Berechnung {
	
	private ArrayList<Character> operatorListe;
	private ArrayList<BigDecimal> eingListe, zwischListe;
	private Var var;

	public Berechnung(Var var) {
		operatorListe = new ArrayList<>();
		eingListe = new ArrayList<>();
		zwischListe = new ArrayList<>();
		this.var = var;
	}
	
/** 	
 * 		Speichert die eingegebene Zahl in einer Liste ab, prüft ob es die letzte Zahl war, ansonsten wird der Operator auch gespeichert und
*		es wird geprüft ob es schon ein Zwischenergebnis gibt mit dem weitergerechnet werden kann 
*		Ist es die letzte Zahl, wird auch wieder anhand der Länge der Eingabeliste entschieden, ob es mit dem Zwischenergebnis weiter geht
*/
	

	void setEingabe(BigDecimal bigDecimal, Character operator) {
		eingListe.add(bigDecimal);
		if(operator != '=') {
			operatorListe.add(operator);
			if(eingListe.size() ==2) {
				switch(operatorListe.get(operatorListe.size()-2)) {
					case '+': 	zwischListe.add(eingListe.get(eingListe.size()-2).add(eingListe.get(eingListe.size()-1)));
									break;
					case '-': 	zwischListe.add(eingListe.get(eingListe.size()-2).subtract(eingListe.get(eingListe.size()-1)));
									break;
					case '*': 	zwischListe.add(eingListe.get(eingListe.size()-2).multiply(eingListe.get(eingListe.size()-1)));
									break;
					case '/': 	zwischListe.add(eingListe.get(eingListe.size()-2).divide(eingListe.get(eingListe.size()-1)));
									break;
				}
			}
			if(eingListe.size() > 2) {
				switch(operatorListe.get(operatorListe.size()-2)) {
				case '+': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).add(eingListe.get(eingListe.size()-1)));
								break;
				case '-': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).subtract(eingListe.get(eingListe.size()-1)));
								break;
				case '*': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).multiply(eingListe.get(eingListe.size()-1)));
								break;
				case '/': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).divide(eingListe.get(eingListe.size()-1)));
								break;
				}
			}
		}else {
			if(eingListe.size() == 1) {
				zwischListe.add(bigDecimal);
			}else if(eingListe.size() ==2) {
				switch (operatorListe.get(operatorListe.size()-1)){
				case '+': 	zwischListe.add(eingListe.get(eingListe.size()-2).add(eingListe.get(eingListe.size()-1)));
								break;
				case '-': 	zwischListe.add(eingListe.get(eingListe.size()-2).subtract(eingListe.get(eingListe.size()-1)));
								break;
				case '*': 	zwischListe.add(eingListe.get(eingListe.size()-2).multiply(eingListe.get(eingListe.size()-1)));
								break;
				case '/': 	zwischListe.add(eingListe.get(eingListe.size()-2).divide(eingListe.get(eingListe.size()-1)));
								break;
				}		
			}else if(eingListe.size() > 2) {
				switch(operatorListe.get(operatorListe.size()-1)) {
				case '+': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).add(eingListe.get(eingListe.size()-1)));
								break;
				case '-': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).subtract(eingListe.get(eingListe.size()-1)));
								break;
				case '*': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).multiply(eingListe.get(eingListe.size()-1)));
								break;
				case '/': 	zwischListe.add(zwischListe.get(zwischListe.size()-1).divide(eingListe.get(eingListe.size()-1)));
								break;
				}
			}
		}
	}
	
	public String prozent(BigDecimal bigDecimal) {
		return bigDecimal.divide(new BigDecimal("100")).toString();
	}

	public String wurzel(BigDecimal bigDecimal) {
		return bigDecimal.sqrt(new MathContext(0)).toString();
	}

	public String potenzieren(int potenz, BigDecimal bigDecimal) {
		return bigDecimal.pow(potenz).toString();
	}
	
//	Gibt das aktuelle Zwischenergebnis zurück
	String getZwischenErgebnis() {
		if(zwischListe.size() == 0) {
			return new String("");
		}else {
			return zwischListe.toString();
		}
	}
	
//	Liefert das Ergebnis zurück und speichert es als Verlauf ab
	String getErgebnis() {
		if(zwischListe.size() == 0) {
			eingListe.clear();
			return new String("");
		}else {
			new Verlauf(var).verlaufSpeichern(eingListe, operatorListe, zwischListe.get(zwischListe.size()-1));
			String str = zwischListe.get(zwischListe.size() -1).toString();
			zurucksetzen();
			return str;
		}		
	}
	
//	Setzt alle Listen zurück
	void zurucksetzen() {
		zwischListe.clear();
		eingListe.clear();
		operatorListe.clear();
	}
}
