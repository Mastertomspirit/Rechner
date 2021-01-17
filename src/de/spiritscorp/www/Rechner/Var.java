package de.spiritscorp.www.Rechner;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Var {

	private Path verlauf, config;
	private Color hintergrundRechner, hintergrundVerlauf, vordergrundVerlauf, hintergrundInfo, hintergrundOptionen;
	private boolean imVordergrund;
	private HashMap<String,String> farben = new HashMap<>();
	
	
	public Var() {
		
//		Instanziert alle Variablen aus einer config file, oder dem nachfolgenden default
		if(!readConfig()) {
			farben.put("Blau", "0x138af2");
			farben.put("Schwarz", "0x03182f");
			farben.put("Grün", "0x19a43c");
			farben.put("Lila", "0x4f2ac5");
			farben.put("Türkis", "0x59bebf");
			
			verlauf = Paths.get(System.getProperty("user.home"), "Documents", "RechnerVerlauf.tmp");
			config = Paths.get(System.getProperty("user.home"), "Documents", "Rechner.cfg");
			hintergrundRechner = Color.decode(farben.get("Blau"));
			hintergrundVerlauf = Color.decode(farben.get("Schwarz"));
			vordergrundVerlauf = Color.decode(farben.get("Blau"));
			hintergrundInfo = Color.decode(farben.get("Grün"));
			hintergrundOptionen = Color.decode(farben.get("Grün"));
			imVordergrund = false;
		}
	}
	
//		Liest die config file und prüft auf Richtigkeit
	private boolean readConfig() {

//		try(BufferedReader br = Files.newBufferedReader(config)){
//			TODO config einlesen wenn vorhanden

//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		return false;
	}

//		Gibt eine Liste mit allen Farbnamen zurück
	public String[] getColorKey() {
		String[] s = new String[farben.size()];
		int i = 0;
		for(Map.Entry<String, String> entry : farben.entrySet()) {
			s[i] = entry.getKey();
			i++;
		}
		return s;
	}
	
//		Gibt den Wert zu einer Farbe zurück
	public String getColorValue(String key) {
		return farben.get(key);
	}
	
//		Gibt den Index der aktuellen Farbe an
	public int getDefaultColorIndex(Color hintergrund) {
		int i = 0;
		for(Map.Entry<String, String> entry : farben.entrySet()) {
			if(hintergrund.equals(Color.decode(entry.getValue()))) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	public Path getVerlauf() {
		return verlauf;
	}

	public void setVerlauf(Path verlauf) {
		this.verlauf = verlauf;
	}

	public Path getConfig() {
		return config;
	}

	public void setConfig(Path config) {
		this.config = config;
	}

	public Color getHintergrundRechner() {
		return hintergrundRechner;
	}

	public void setHintergrundRechner(String farbe) {
		hintergrundRechner = Color.decode(getColorValue(farbe));
	}

	public Color getHintergrundVerlauf() {
		return hintergrundVerlauf;
	}

	public void setHintergrundVerlauf(String farbe) {
		hintergrundVerlauf = Color.decode(getColorValue(farbe));
	}

	public Color getVordergrundVerlauf() {
		return vordergrundVerlauf;
	}

	public void setVordergrundVerlauf(String farbe) {
		vordergrundVerlauf = Color.decode(getColorValue(farbe));
	}

	public Color getHintergrundInfo() {
		return hintergrundInfo;
	}

	public void setHintergrundInfo(Color hintergrundInfo) {
		this.hintergrundInfo = hintergrundInfo;
	}

	public Color getHintergrundOptionen() {
		return hintergrundOptionen;
	}

	public void setHintergrundOptionen(Color hintergrundOptionen) {
		this.hintergrundOptionen = hintergrundOptionen;
	}

	public boolean isImVordergrund() {
		return imVordergrund;
	}

	public void setImVordergrund(boolean imVordergrund) {
		this.imVordergrund = imVordergrund;
	}

}
