package de.spiritscorp.www.Rechner;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionWindow extends JFrame {
	private static final long serialVersionUID = -6156392795210452530L;
	
	private JComboBox<String> boxFarbeRechner, boxFarbeVerlauf, boxFarbeVGVerlauf;
	private JButton speichern, zurück;
	
	public OptionWindow(InputEvent input, Var var) {
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(var.getHintergrundOptionen());
	
		JLabel uberschrift = new JLabel("Optionen");
		uberschrift.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		uberschrift.setBounds(250, 20, 100, 50);
		
//		Label für die Hintergrundfarbe für den Rechner
		JLabel labelFarbeRechner = new JLabel("Hintergrundfarbe Rechner");
		labelFarbeRechner.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		labelFarbeRechner.setBounds(20, 100, 300, 30);
		
//		Auswahl der Hintergrundfarbe für den Rechner
		boxFarbeRechner = new JComboBox<String>(var.getColorKey());
		boxFarbeRechner.setBounds(350, 100, 150, 30);
		boxFarbeRechner.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		boxFarbeRechner.setSelectedIndex(var.getDefaultColorIndex(var.getHintergrundRechner()));
		
//		Label für die Hintergrundfarbe für den Verlauf
		JLabel labelFarbeVerlauf= new JLabel("Hintergrundfarbe Verlauf");
		labelFarbeVerlauf.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		labelFarbeVerlauf.setBounds(20, 150, 300, 30);
		
//		Auswahl der Hintergrundfarbe für den Verlauf
		boxFarbeVerlauf = new JComboBox<String>(var.getColorKey());
		boxFarbeVerlauf.setBounds(350, 150, 150, 30);
		boxFarbeVerlauf.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		boxFarbeVerlauf.setSelectedIndex(var.getDefaultColorIndex(var.getHintergrundVerlauf()));

//		Label für die Vordergrundfarbe für den Verlauf
		JLabel labelFarbeVGVerlauf= new JLabel("Vordergrundfarbe Verlauf");
		labelFarbeVGVerlauf.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		labelFarbeVGVerlauf.setBounds(20, 200, 300, 30);
		
//		Auswahl der Vordergrundfarbe für den Verlauf
		boxFarbeVGVerlauf = new JComboBox<String>(var.getColorKey());
		boxFarbeVGVerlauf.setBounds(350, 200, 150, 30);
		boxFarbeVGVerlauf.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		boxFarbeVGVerlauf.setSelectedIndex(var.getDefaultColorIndex(var.getVordergrundVerlauf()));
		
//		Speichert die Auswahl
		speichern = new JButton("speichern");
		speichern.setBounds(100, 500, 150, 50);
		speichern.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		speichern.addActionListener(input);

		panel.add(labelFarbeVGVerlauf);
		panel.add(boxFarbeVGVerlauf);
		panel.add(labelFarbeVerlauf);
		panel.add(boxFarbeVerlauf);
		panel.add(speichern);
		panel.add(labelFarbeRechner);
		panel.add(boxFarbeRechner);
		panel.add(uberschrift);
		
		add(panel);
		
		setVisible(true);
	}

	public JComboBox<String> getBoxFarbeRechner() {
		return boxFarbeRechner;
	}

	public JComboBox<String> getBoxFarbeVerlauf() {
		return boxFarbeVerlauf;
	}

	public JComboBox<String> getBoxFarbeVGVerlauf() {
		return boxFarbeVGVerlauf;
	}

	public JButton getSpeichern() {
		return speichern;
	}

	public JButton getZurück() {
		return zurück;
	}
	
}
