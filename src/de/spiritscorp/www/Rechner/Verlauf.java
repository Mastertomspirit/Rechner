package de.spiritscorp.www.Rechner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Verlauf {
	
//	Speicherort von der Verlaufsdatei
	private Path path;
	
	public Verlauf(Var var) {
		path = var.getVerlauf();
	}

//	 Speichert eine komplette Rechnung in der Datei ab und prüft vorher die Liste auf maximal 15 Einträge
	void verlaufSpeichern(ArrayList<BigDecimal> rechnung, ArrayList<Character> operator, BigDecimal ergebnis) {
//		TODO	Maximal 15? Einträge

		try(BufferedWriter br = Files.newBufferedWriter(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND)){
			br.write(rechnung.get(0).toString());
			for(int i=1; i<rechnung.size(); i++) {
				br.write(" " + operator.get(i-1) + " " + rechnung.get(i).toString());
			}
			br.write(" = " + ergebnis.toString() + System.lineSeparator());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
//	Liest den Verlauf ein und gibt ihn weiter
	String verlaufAbrufen() {
		StringBuffer sb = new StringBuffer();
		try(BufferedReader br = Files.newBufferedReader(path)){
			String lines = "	       Verlauf"+ System.lineSeparator()+ "          ----------------------";
			while(lines != null) {
				sb.append(lines + System.lineSeparator());
				lines = br.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new String(sb);
	}
}
