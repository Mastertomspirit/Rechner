package de.spiritscorp.www.Rechner;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class InputEvent implements ActionListener {
	
	private Var var;
	private Gui gui;
	private Berechnung berechnung;
	private InfoWindow info;
	private OptionWindow optionen;
	private InputEvent input;
	// Für die einzeln eingegebenen Zahlen und die aktuelle Rechnung
	private StringBuffer rechnung, zahl;
	private boolean verlaufAn = false;



	public InputEvent() {
		var = new Var();
		input = this;
		EventQueue.invokeLater(new Runnable() {
			public void run() {			
				gui = new Gui(input, var);
				gui.setVisible(true);
			}
		});
		berechnung = new Berechnung(var);
		rechnung = new StringBuffer();
		zahl = new StringBuffer();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gui.getBtnZahl_0()) {
			zahl.append("0");
			rechnung.append("0");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_1()) {
			zahl.append("1");
			rechnung.append("1");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_2()) {
			zahl.append("2");
			rechnung.append("2");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_3()) {
			zahl.append("3");
			rechnung.append("3");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_4()) {
			zahl.append("4");
			rechnung.append("4");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_5()) {
			zahl.append("5");
			rechnung.append("5");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_6()) {
			zahl.append("6");
			rechnung.append("6");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_7()) {
			zahl.append("7");
			rechnung.append("7");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_8()) {
			zahl.append("8");
			rechnung.append("8");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnZahl_9()) {
			zahl.append("9");
			rechnung.append("9");
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}
		if(e.getSource() == gui.getBtnAddieren()) {
			ausrechnen('+');
			gui.getAusgabefeld().setText(printDeutsch(berechnung.getZwischenErgebnis()));
		}
		if(e.getSource() == gui.getBtnSubtrahieren()) {
			ausrechnen('-');
			gui.getAusgabefeld().setText(berechnung.getZwischenErgebnis());
		}
		if(e.getSource() == gui.getBtnMultiplizieren()) {
			ausrechnen('*');
			gui.getAusgabefeld().setText(berechnung.getZwischenErgebnis());
		}
		if(e.getSource() == gui.getBtnDividieren()) {
			ausrechnen('/');
			gui.getAusgabefeld().setText(berechnung.getZwischenErgebnis());
		}
		if(e.getSource() == gui.getBtnQuadrat()) {
			if(zahl.length() == 0 && !gui.getEingabefeld().getText().isEmpty()) {
				gui.getEingabefeld().setText(berechnung.potenzieren(2, new BigDecimal(gui.getEingabefeld().getText())));
			}else if(zahl.length() != 0) {
				gui.getEingabefeld().setText(berechnung.potenzieren(2, new BigDecimal(zahl.toString())));
			}
			zahl.delete(0, zahl.length());		
			rechnung.delete(0, rechnung.length());		
		}
		if(e.getSource() == gui.getBtnProzent()) {
			if(zahl.length() == 0 && !gui.getEingabefeld().getText().isEmpty()) {
				gui.getEingabefeld().setText(berechnung.prozent(new BigDecimal(gui.getEingabefeld().getText())));
			}else if(zahl.length() != 0) {
				gui.getEingabefeld().setText(berechnung.prozent(new BigDecimal(zahl.toString())));
			}
			zahl.delete(0, zahl.length());		
			rechnung.delete(0, rechnung.length());
		}
		if(e.getSource() == gui.getBtnWurzel()) {
			if(zahl.length() == 0 && !gui.getEingabefeld().getText().isEmpty()) {
				gui.getEingabefeld().setText(berechnung.wurzel(new BigDecimal(gui.getEingabefeld().getText())));
			}else if(zahl.length() != 0) {
				gui.getEingabefeld().setText(berechnung.wurzel(new BigDecimal(zahl.toString())));
			}
			zahl.delete(0, zahl.length());		
			rechnung.delete(0, rechnung.length());
		}
		if(e.getSource() == gui.getBtnKomma()) {
			if(zahl.length() == 0) {
				zahl.append("0");
				rechnung.append("0");
			}
			// Prüft ob schon ein komma getippt wurde
			if(zahl.lastIndexOf(".") == -1) {
				zahl.append(".");
				rechnung.append(".");
				gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
			}
		}
		if(e.getSource() == gui.getBtnErgebnis()) {
			ausrechnen('=');
			zahl.delete(0, zahl.length());
			rechnung.delete(0, rechnung.length());
			gui.getEingabefeld().setText(printDeutsch(berechnung.getErgebnis()));
			gui.getAusgabefeld().setText("");
		}
		if(e.getSource() == gui.getBtnZuruck()) {
			if(zahl.length() != 0) {
				zahl.deleteCharAt(zahl.length()-1);
				rechnung.deleteCharAt(rechnung.length() - 1);
				gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
			}
		}
		if(e.getSource() == gui.getBtnLoeschen()) {
			berechnung.zurucksetzen();
			zahl.delete(0, zahl.length());
			rechnung.delete(0, rechnung.length());
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
			gui.getAusgabefeld().setText("");
		}
		if(e.getSource() == gui.getBtnVerlauf()) {
			if(!verlaufAn) {
				gui.verlauf_start();
				verlaufAn = true;
			}else {
				gui.remove(gui.getVerlaufPane());
				gui.setSize(gui.getCustomWidth(), gui.getCustomHeight());
				verlaufAn = false;
			}
		}
		if(e.getSource() == gui.getBtnInfo()) {
			if(info == null) {
				info = new InfoWindow(input, var);
			}else {
				info.setVisible(true);
			}
		}
		if(info != null) {
			if(e.getSource() == info.getZuruck()) {
				info.setVisible(false);
			}
		}
		if(e.getSource() == gui.getBtnOptionen()) {
			if(optionen == null) {
				optionen = new OptionWindow(input, var);
			}else {
				optionen.setVisible(true);
			}
		}
		if(optionen != null) {
			if(e.getSource() == optionen.getSpeichern()) {
				String rechnerFarbe = (String) optionen.getBoxFarbeRechner().getSelectedItem();
				String verlaufFarbe = (String) optionen.getBoxFarbeVerlauf().getSelectedItem();
				String verlaufVGFarbe = (String) optionen.getBoxFarbeVGVerlauf().getSelectedItem();
				var.setHintergrundRechner(rechnerFarbe);
				var.setHintergrundVerlauf(verlaufFarbe);
				var.setVordergrundVerlauf(verlaufVGFarbe);
				var.setImVordergrund(optionen.getCkbxImVg().isSelected());
				gui.getHauptPane().setBackground(var.getHintergrundRechner());
				gui.setAlwaysOnTop(var.isImVordergrund());
				if(gui.getVerlaufPane() != null) {
					gui.getVerlaufPane().setBackground(var.getHintergrundVerlauf());
					gui.getTextF1().setBackground(var.getVordergrundVerlauf());
				}
				var.writeConfig();
			}
		}
	}

//		Prüft ob es überhaupt eine eingabe gab, ersetzt Komma durch Punkt, konvertiert den String in einen Double und speichert ihn
	private void ausrechnen(Character operator) {
		if(zahl.length() != 0 && !zahl.toString().equals("0.0")) {
			if(zahl.indexOf(".") == zahl.length() -1) {
				zahl.deleteCharAt(zahl.length() -1);
				rechnung.deleteCharAt(rechnung.length() -1);
			}
			berechnung.setEingabe(new BigDecimal(zahl.toString()), operator);
			zahl.delete(0, zahl.length());
			rechnung.append(operator);
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));
		}else if(zahl.toString().equals("0.0")) {
			zahl.delete(0, zahl.length());
			rechnung.delete(rechnung.length()-3, rechnung.length());
			gui.getEingabefeld().setText(printDeutsch(rechnung.toString()));

		}
	}
	private String printDeutsch(String string) {
		return string.replace('.', ',');		
	}
}

