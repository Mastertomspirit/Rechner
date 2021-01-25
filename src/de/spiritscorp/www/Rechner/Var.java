package de.spiritscorp.www.Rechner;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

public class Var {

	private Path verlauf, config;
	private Color hintergrundRechner, hintergrundVerlauf, vordergrundVerlauf, hintergrundInfo, hintergrundOptionen;
	private boolean imVordergrund;
	private HashMap<String,String> farben = new HashMap<>();
	
	
	public Var() {
		config = Paths.get(System.getProperty("user.home"), "Documents", "Rechner.cfg");

//		Instanziert alle Variablen aus der config file, oder dem nachfolgenden default
		if(!readConfig()) {
			farben.put("Blau", "0x138af2");
			farben.put("Schwarz", "0x03182f");
			farben.put("Grün", "0x19a43c");
			farben.put("Lila", "0x4f2ac5");
			farben.put("Türkis", "0x59bebf");
			
			verlauf = Paths.get(System.getProperty("user.home"), "Documents", "RechnerVerlauf.tmp");
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
		boolean verlaufGelesen = false;
		boolean farbenGelesen = false;
		boolean hintergruendeGelesen = false;
		if(Files.exists(config) && Files.isReadable(config)) {
			try(BufferedReader br = Files.newBufferedReader(config)){
//				Zählvariable für mindestens 3 Farben
				int k = 0;
//				Speichert die gewünschten Hintergründe, bis alle Farben eingelesen wurden
				String hintergrundRechnerString = null; 
				String hintergrundVerlaufString = null;
				String vordergrundVerlaufString = null;
				String hintergrundInfoString = null;
				String hintergrundOptionenString = null;
//				Lesen start
				String zeile = br.readLine();
				while(zeile != null) {
					if(zeile.contains("Speicherpfad für Verlauf")){
						verlauf = Paths.get(zeile.substring(zeile.indexOf("Verlauf")+7).trim());
						if(!Files.exists(verlauf) || !Files.isReadable(verlauf)|| !Files.isWritable(verlauf)) {
							verlauf = Paths.get(System.getProperty("user.home"), "Documents", "RechnerVerlauf.tmp");
						}
						verlaufGelesen = true;
					}
					if(zeile.contains("Farbauswahl")) {
						String value = zeile.substring(zeile.lastIndexOf("Value:") + 6, zeile.lastIndexOf("Value:") + 15).trim();
						String key = zeile.substring(zeile.lastIndexOf("Key:") + 4).trim();
//						Testet, ob die Farbe Interpretierbar ist und ein Schlüssel vorhanden
						try {
							Color.decode(value);
							if(!key.isEmpty()) {
								k++;
								farben.put(key, value);
								if(k > 2) {
									farbenGelesen = true;
								}
							}else {
								System.err.println("Farbname fehlt!");
							}
						}catch(NumberFormatException e) {
							System.err.println(value + "  ist kein gültiger Hex-Farbcode!");
						}
					}
					if(zeile.contains("Hintergrund Rechner")) {
						hintergrundRechnerString = zeile.substring(zeile.lastIndexOf("Rechner") + 7).trim();
					}
					if(zeile.contains("Hintergrund Verlauf")) {
						hintergrundVerlaufString = zeile.substring(zeile.lastIndexOf("Verlauf") +7).trim();
					}
					if(zeile.contains("Vordergrund Verlauf")) {
						vordergrundVerlaufString = zeile.substring(zeile.lastIndexOf("Verlauf") + 7).trim();
					}
					if(zeile.contains("Hintergrund Info")) {
						hintergrundInfoString = zeile.substring(zeile.lastIndexOf("Info") + 4).trim();
					}
					if(zeile.contains("Hintergrund Optionen")) {
						hintergrundOptionenString = zeile.substring(zeile.lastIndexOf("Optionen") + 8).trim();
					}					
					if(zeile.contains("Im Vordergrund")) {
						imVordergrund = Boolean.parseBoolean(zeile.substring(zeile.lastIndexOf("Vordergrund") + 11).trim());
					}
					zeile = br.readLine();
				}
				if(farben.get(hintergrundRechnerString) != null &&
					farben.get(hintergrundVerlaufString) != null &&
					farben.get(vordergrundVerlaufString) != null &&
					farben.get(hintergrundInfoString) != null &&
					farben.get(hintergrundOptionenString) != null) {
					hintergrundRechner = Color.decode(farben.get(hintergrundRechnerString));
					hintergrundVerlauf = Color.decode(farben.get(hintergrundVerlaufString));
					vordergrundVerlauf = Color.decode(farben.get(vordergrundVerlaufString));
					hintergrundInfo = Color.decode(farben.get(hintergrundInfoString));
					hintergrundOptionen = Color.decode(farben.get(hintergrundOptionenString));
					hintergruendeGelesen = true;
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return verlaufGelesen && farbenGelesen && hintergruendeGelesen;
	}
	
//	Schreibt die config 
	void writeConfig() {
		String s = System.lineSeparator();
		try(BufferedWriter bw = Files.newBufferedWriter(config,StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)){
			bw.write("----------   Configuration Taschenrechner   ----------" + s + s + s);
			bw.write("Speicherpfad für Verlauf          " +verlauf.toAbsolutePath().toString() + s + s);
			for(Map.Entry<String, String> entry : farben.entrySet()) {
				bw.write("Farbauswahl         Value: " + entry.getValue() +"    Key: " +entry.getKey() +  s);
			}
			bw.write(s);
			bw.write("Hintergrund Rechner           " + getDefaultColorKey(hintergrundRechner) + s);
			bw.write("Hintergrund Verlauf           " + getDefaultColorKey(hintergrundVerlauf) + s);
			bw.write("Vordergrund Verlauf           " + getDefaultColorKey(vordergrundVerlauf) + s);
			bw.write("Hintergrund Info              " + getDefaultColorKey(hintergrundInfo) + s);
			bw.write("Hintergrund Optionen          " + getDefaultColorKey(hintergrundOptionen) + s +s);
			bw.write("Im Vordergrund          " + String.valueOf(imVordergrund));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

//		Gibt eine Liste mit allen Farbnamen zurück
	public String[] getColorKeys() {
		String[] s = new String[farben.size()];
		int i = 0;
		for(Map.Entry<String, String> entry : farben.entrySet()) {
			s[i] = entry.getKey();
			i++;
		}
		return s;
	}
	
//		Gibt den Wert zu einer bestimmten Farbe zurück
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
//		Gibt den aktuellen Schlüssel vom Hintergrund zurück
	public String getDefaultColorKey(Color hintergrund) {
		for(Map.Entry<String, String> entry : farben.entrySet()) {
			if(hintergrund.equals(Color.decode(entry.getValue()))) {
				return entry.getKey();
			}
		}
		return null;
	}
	public Path getVerlauf() {
		return verlauf;
	}
	public void setVerlauf(Path verlauf) {
		this.verlauf = verlauf;
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
