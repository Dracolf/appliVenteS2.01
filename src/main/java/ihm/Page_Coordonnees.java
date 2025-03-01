package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import modele.Panier;

import javax.swing.border.EtchedBorder;

public class Page_Coordonnees extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private ButtonGroup bg = new ButtonGroup();
	private ButtonGroup bg2 = new ButtonGroup();


	public Page_Coordonnees(Panier panier, DefaultTableModel tableModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 5));
		
		JPanel panel_nord = new JPanel();
		contentPane.add(panel_nord, BorderLayout.NORTH);
		panel_nord.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("          Vos coordonnées   ");
		lblNewLabel.setForeground(new Color(250, 146, 69));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_nord.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\icones\\pngwing.png"));
		panel_nord.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_mid = new JPanel();
		contentPane.add(panel_mid, BorderLayout.CENTER);
		panel_mid.setLayout(new BorderLayout(0, 5));
		
		JPanel colonnes = new JPanel();
		panel_mid.add(colonnes, BorderLayout.CENTER);
		colonnes.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel colonne_gauche = new JPanel();
		colonnes.add(colonne_gauche);
		colonne_gauche.setLayout(new GridLayout(8, 1, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Nom :");
		colonne_gauche.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prénom :");
		colonne_gauche.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Adresse 1 :");
		colonne_gauche.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Adresse 2 :");
		colonne_gauche.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Code postal :");
		colonne_gauche.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ville :");
		colonne_gauche.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Téléphone :");
		colonne_gauche.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Mail :");
		colonne_gauche.add(lblNewLabel_9);
		
		JPanel colonne_droite = new JPanel();
		colonnes.add(colonne_droite);
		colonne_droite.setLayout(new GridLayout(0, 1, 0, 0));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		colonne_droite.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		colonne_droite.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		colonne_droite.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		colonne_droite.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		colonne_droite.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		colonne_droite.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		colonne_droite.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		colonne_droite.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_mid_sud = new JPanel();
		panel_mid.add(panel_mid_sud, BorderLayout.SOUTH);
		panel_mid_sud.setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(250, 146, 69), 3), "Moyen de paiement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(250, 146, 69)));
		panel_mid_sud.add(panel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Carte de crédit");
		rdbtnNewRadioButton.setSelected(true);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Paypal");
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Paiement par chèque");
		panel_1.add(rdbtnNewRadioButton_2);
		
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		bg.add(rdbtnNewRadioButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(250, 146, 69), 3), "Abonnement \u00E0 notre Newsletter", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(250, 146, 69)));
		panel_mid_sud.add(panel_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Oui");
		rdbtnNewRadioButton_3.setSelected(true);
		panel_2.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Non");
		panel_2.add(rdbtnNewRadioButton_4);
		
		bg2.add(rdbtnNewRadioButton_3);
		bg2.add(rdbtnNewRadioButton_4);
		
		JPanel panel_sud = new JPanel();
		contentPane.add(panel_sud, BorderLayout.SOUTH);
		panel_sud.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_sud.add(panel, BorderLayout.EAST);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = {
	                    textField.getText(),
	                    textField_1.getText(),
	                    textField_2.getText(),
	                    textField_3.getText(),
	                    textField_4.getText(),
	                    textField_5.getText(),
	                    textField_6.getText(),
	                    textField_7.getText()
	            };
				new Page_Facture(data, panier, tableModel).setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		panel.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
	}

}