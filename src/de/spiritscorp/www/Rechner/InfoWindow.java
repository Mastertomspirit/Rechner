package de.spiritscorp.www.Rechner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoWindow extends JFrame {
	private static final long serialVersionUID = -3647878921733049858L;

	private JButton zuruck;
	
	private String infoText = "Taschenrechner developed by TomSpirit @ 2021";
	
	public InfoWindow(InputEvent input, Var var) {
		setSize(600,130);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(var.getHintergrundInfo());
		
		JLabel label = new JLabel(infoText);
		label.setBounds(125, 0, 300, 30);
		label.setBackground(null);
		
		zuruck = new JButton();
		zuruck.setText("Zurück");
		zuruck.setBounds(225, 50, 100, 30);
		zuruck.addActionListener(input);
		
		panel.add(label);
		panel.add(zuruck);
		
		add(panel);
		
		setVisible(true);
	}

	public JButton getZuruck() {
		return zuruck;
	}
	
}
