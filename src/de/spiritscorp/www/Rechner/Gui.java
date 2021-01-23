package de.spiritscorp.www.Rechner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Gui extends JFrame {

	private static final long serialVersionUID = 8898298365244967533L;
	private JPanel hauptPane, verlaufPane;
	private Var var;
	private JTextField ausgabefeld;
	private JTextField eingabefeld;
	private JTextArea textF1;
	private JButton btnZahl_0, btnZahl_1, btnZahl_2, btnZahl_3, btnZahl_4, btnZahl_5, btnZahl_6, btnZahl_7, btnZahl_8, btnZahl_9;
	private JButton btnAddieren, btnSubtrahieren, btnMultiplizieren, btnDividieren, btnWurzel, btnProzent, btnQuadrat, btnErgebnis ;
	private JButton btnKomma, btnZuruck, btnLoeschen, btnVerlauf, btnOptionen, btnInfo;
	private Font font = new Font("Comic Sans MS", Font.BOLD, 22);
	private int height = 470;
//	Fensterbreite ohne Verlauf
	private int width = 384;
//	Fensterbreite mit Verlauf
	private int width_verlauf = 640;

	/**
	 * Erstellt das Fenster und die Buttons
	 */
	public Gui(InputEvent input, Var var) {
	
		this.var = var;
		
		setTitle("Rechner");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		setResizable(false);
		hauptPane = new JPanel();
		hauptPane.setBounds(0, 0, width, height);
		hauptPane.setBackground(var.getHintergrundRechner());
		hauptPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		hauptPane.setLayout(null);
		getContentPane().add(hauptPane);		
		
//		Textfelder
		eingabefeld = new JTextField();
		eingabefeld.setBounds(10, 10, 350, 40);
		hauptPane.add(eingabefeld);
		
		ausgabefeld = new JTextField();
		ausgabefeld.setBounds(10, 51, 350, 40);
		hauptPane.add(ausgabefeld);

//		 Zahlen 0 - 9
		btnZahl_0 = new JButton("0");
		btnZahl_0.addActionListener(input);
		btnZahl_0.setForeground(Color.BLACK);
		btnZahl_0.setFont(font);
		btnZahl_0.setBounds(10, 368, 50, 50);
		hauptPane.add(btnZahl_0);
		
		btnZahl_1 = new JButton("1");
		btnZahl_1.addActionListener(input);
		btnZahl_1.setForeground(Color.BLACK);
		btnZahl_1.setFont(font);
		btnZahl_1.setBounds(10, 308, 50, 50);
		hauptPane.add(btnZahl_1);

		btnZahl_2 = new JButton("2");
		btnZahl_2.addActionListener(input);
		btnZahl_2.setForeground(Color.BLACK);
		btnZahl_2.setFont(font);
		btnZahl_2.setBounds(70, 308, 50, 50);
		hauptPane.add(btnZahl_2);

		btnZahl_3 = new JButton("3");
		btnZahl_3.addActionListener(input);
		btnZahl_3.setForeground(Color.BLACK);
		btnZahl_3.setFont(font);
		btnZahl_3.setBounds(130, 308, 50, 50);
		hauptPane.add(btnZahl_3);
		
		btnZahl_4 = new JButton("4");
		btnZahl_4.addActionListener(input);
		btnZahl_4.setForeground(Color.BLACK);
		btnZahl_4.setFont(font);
		btnZahl_4.setBounds(10, 248, 50, 50);
		hauptPane.add(btnZahl_4);
		
		btnZahl_5 = new JButton("5");
		btnZahl_5.addActionListener(input);
		btnZahl_5.setForeground(Color.BLACK);
		btnZahl_5.setFont(font);
		btnZahl_5.setBounds(70, 248, 50, 50);
		hauptPane.add(btnZahl_5);
		
		btnZahl_6 = new JButton("6");
		btnZahl_6.addActionListener(input);
		btnZahl_6.setForeground(Color.BLACK);
		btnZahl_6.setFont(font);
		btnZahl_6.setBounds(130, 248, 50, 50);
		hauptPane.add(btnZahl_6);
		
		btnZahl_7 = new JButton("7");
		btnZahl_7.addActionListener(input);
		btnZahl_7.setForeground(Color.BLACK);
		btnZahl_7.setFont(font);
		btnZahl_7.setBounds(10, 188, 50, 50);
		hauptPane.add(btnZahl_7);
		
		btnZahl_8 = new JButton("8");
		btnZahl_8.addActionListener(input);
		btnZahl_8.setForeground(Color.BLACK);
		btnZahl_8.setFont(font);
		btnZahl_8.setBounds(70, 188, 50, 50);
		hauptPane.add(btnZahl_8);
		
		btnZahl_9 = new JButton("9");
		btnZahl_9.addActionListener(input);
		btnZahl_9.setForeground(Color.BLACK);
		btnZahl_9.setFont(font);
		btnZahl_9.setBounds(130, 188, 50, 50);
		hauptPane.add(btnZahl_9);

// 	Plus +
		btnAddieren = new JButton("+");
		btnAddieren.addActionListener(input);
		btnAddieren.setForeground(Color.BLACK);
		btnAddieren.setFont(font);
		btnAddieren.setBounds(190, 308, 50, 50);
		hauptPane.add(btnAddieren);
		
// 	Minus -
		btnSubtrahieren = new JButton("-");
		btnSubtrahieren.addActionListener(input);
		btnSubtrahieren.setForeground(Color.BLACK);
		btnSubtrahieren.setFont(font);
		btnSubtrahieren.setBounds(190, 248, 50, 50);
		hauptPane.add(btnSubtrahieren);
		
// 	Mal *
		btnMultiplizieren = new JButton("*");
		btnMultiplizieren.addActionListener(input);
		btnMultiplizieren.setForeground(Color.BLACK);
		btnMultiplizieren.setFont(font);
		btnMultiplizieren.setBounds(190, 188, 50, 50);
		hauptPane.add(btnMultiplizieren);
		
// 	Geteilt /
		btnDividieren = new JButton("/");
		btnDividieren.addActionListener(input);
		btnDividieren.setForeground(Color.BLACK);
		btnDividieren.setFont(font);
		btnDividieren.setBounds(190, 128, 50, 50);
		hauptPane.add(btnDividieren);
		
// 	Komma ,
		btnKomma = new JButton(",");
		btnKomma.addActionListener(input);
		btnKomma.setForeground(Color.BLACK);
		btnKomma.setFont(font);
		btnKomma.setBounds(70, 368, 50, 50);
		hauptPane.add(btnKomma);
		
// 	Ergebnis =
		btnErgebnis = new JButton("=");
		btnErgebnis.addActionListener(input);
		btnErgebnis.setForeground(Color.BLACK);
		btnErgebnis.setFont(font);
		btnErgebnis.setBounds(130, 368, 110, 50);
		hauptPane.add(btnErgebnis);
		
// 	Zurück <--
		btnZuruck = new JButton("<--");
		btnZuruck.addActionListener(input);
		btnZuruck.setForeground(Color.BLACK);
		btnZuruck.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		btnZuruck.setBounds(250, 128, 110, 50);
		hauptPane.add(btnZuruck);
		
// 	Alles löschen C
		btnLoeschen = new JButton("C");
		btnLoeschen.addActionListener(input);
		btnLoeschen.setForeground(Color.BLACK);
		btnLoeschen.setFont(font);
		btnLoeschen.setBounds(250, 188, 50, 50);
		hauptPane.add(btnLoeschen);
	
// 	Wurzel √
		btnWurzel = new JButton("√");
		btnWurzel.addActionListener(input);
		btnWurzel.setForeground(Color.BLACK);
		btnWurzel.setFont(font);
		btnWurzel.setBounds(10, 128, 50, 50);
		hauptPane.add(btnWurzel);
		
// 	Quadrat x²
		btnQuadrat = new JButton("x²");
		btnQuadrat.addActionListener(input);
		btnQuadrat.setForeground(Color.BLACK);
		btnQuadrat.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnQuadrat.setBounds(70, 128, 50, 50);
		hauptPane.add(btnQuadrat);
		
// 	Prozent %
		btnProzent = new JButton("%");
		btnProzent.addActionListener(input);
		btnProzent.setForeground(Color.BLACK);
		btnProzent.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnProzent.setBounds(130, 128, 50, 50);
		hauptPane.add(btnProzent);
	
//		Verlaufsansicht der letzten Rechnungen
		btnVerlauf = new JButton("V");
		btnVerlauf.addActionListener(input);
		btnVerlauf.setForeground(Color.BLACK);
		btnVerlauf.setFont(font);
		btnVerlauf.setBounds(310, 368, 50, 50);
		hauptPane.add(btnVerlauf);

//		Optionen
		btnOptionen = new JButton();
		btnOptionen.setBounds(310, 188, 50, 50);
		btnOptionen.setIcon(new ImageIcon(Gui.class.getResource("/de/spiritscorp/www/Rechner/media/Optionen2.png")));
		btnOptionen.addActionListener(input);
		hauptPane.add(btnOptionen);
				
//		Info
		btnInfo = new JButton();
		btnInfo.setBounds(310, 248, 50, 50);
		btnInfo.setIcon(new ImageIcon(Gui.class.getResource("/de/spiritscorp/www/Rechner/media/Info.png")));
		btnInfo.addActionListener(input);
		hauptPane.add(btnInfo);
		
/**
 * 		Noch nicht belegte Buttons
 * 
 */		
		JButton btnNewButton_4_2 = new JButton("");
		btnNewButton_4_2.setForeground(Color.BLACK);
		btnNewButton_4_2.setFont(font);
		btnNewButton_4_2.setBounds(250, 248, 50, 50);
		hauptPane.add(btnNewButton_4_2);
		
		JButton btnNewButton_5_2 = new JButton("");
		btnNewButton_5_2.setForeground(Color.BLACK);
		btnNewButton_5_2.setFont(font);
		btnNewButton_5_2.setBounds(250, 308, 50, 50);
		hauptPane.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_1_1 = new JButton("");
		btnNewButton_5_1_1.setForeground(Color.BLACK);
		btnNewButton_5_1_1.setFont(font);
		btnNewButton_5_1_1.setBounds(310, 308, 50, 50);
		hauptPane.add(btnNewButton_5_1_1);

		JButton btnNewButton_4_1_1_1 = new JButton("");
		btnNewButton_4_1_1_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1_1.setFont(font);
		btnNewButton_4_1_1_1.setBounds(250, 368, 50, 50);
		hauptPane.add(btnNewButton_4_1_1_1);
	}
	
//		Öffnet den Verlauf 
	public void verlauf_start() {
		setSize(width_verlauf, height);
		if(verlaufPane == null) {
			verlaufPane = new JPanel();
			verlaufPane.setBounds(width, 0, width_verlauf-width,height);
			verlaufPane.setBackground(var.getHintergrundVerlauf());
			verlaufPane.setLayout(null);
			textF1 = new JTextArea();
			textF1.setEditable(false);
			textF1.setBounds(width + 15, 20, 200, height -80);
			textF1.setBackground(var.getVordergrundVerlauf());
			textF1.setFont(new Font("Comic Sans MS", Font.BOLD, 9));
			textF1.setLineWrap(true);
			textF1.setWrapStyleWord(true);
			verlaufPane.add(textF1);
		}
		textF1.setText(new Verlauf(var).verlaufAbrufen());
		getContentPane().add(verlaufPane);		
	}

/**
 * 
 * Alle getter 
 * 
 */	
	public JPanel getHauptPane() {
		return hauptPane;
	}
	public JTextField getAusgabefeld() {
		return ausgabefeld;
	}
	public JTextField getEingabefeld() {
		return eingabefeld;
	}
	public JButton getBtnZahl_0() {
		return btnZahl_0;
	}
	public JButton getBtnZahl_1() {
		return btnZahl_1;
	}
	public JButton getBtnZahl_2() {
		return btnZahl_2;
	}
	public JButton getBtnZahl_3() {
		return btnZahl_3;
	}
	public JButton getBtnZahl_4() {
		return btnZahl_4;
	}
	public JButton getBtnZahl_5() {
		return btnZahl_5;
	}
	public JButton getBtnZahl_6() {
		return btnZahl_6;
	}
	public JButton getBtnZahl_7() {
		return btnZahl_7;
	}
	public JButton getBtnZahl_8() {
		return btnZahl_8;
	}
	public JButton getBtnZahl_9() {
		return btnZahl_9;
	}
	public JButton getBtnAddieren() {
		return btnAddieren;
	}
	public JButton getBtnSubtrahieren() {
		return btnSubtrahieren;
	}
	public JButton getBtnMultiplizieren() {
		return btnMultiplizieren;
	}
	public JButton getBtnDividieren() {
		return btnDividieren;
	}
	public JButton getBtnWurzel() {
		return btnWurzel;
	}
	public JButton getBtnProzent() {
		return btnProzent;
	}
	public JButton getBtnQuadrat() {
		return btnQuadrat;
	}
	public JButton getBtnKomma() {
		return btnKomma;
	}
	public JButton getBtnZuruck() {
		return btnZuruck;
	}
	public JButton getBtnLoeschen() {
		return btnLoeschen;
	}
	public JButton getBtnErgebnis() {
		return btnErgebnis;
	}
	public JButton getBtnVerlauf() {
		return btnVerlauf;
	}
	public Font getBtnFont() {
		return font;
	}
	public JPanel getVerlaufPane() {
		return verlaufPane;
	}
	public JTextArea getTextF1() {
		return textF1;
	}
	public int getCustomWidth() {
		return width;
	}
	public int getCustomHeight() {
		return height;
	}
	public int getWidth_verlauf() {
		return width_verlauf;
	}
	public JButton getBtnOptionen() {
		return btnOptionen;
	}
	public JButton getBtnInfo() {
		return btnInfo;
	}
}

