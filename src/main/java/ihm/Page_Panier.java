package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import modele.Article;
import modele.Panier;

public class Page_Panier extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JTextField sousTotalField;
    private JTextField expeditionField;
    private JTextField totalField;
    private Panier panier;
    private DefaultTableModel tableModel;
    public Page_Panier(Panier panier) {
        this.panier = panier;
        setTitle("Panier");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 600, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panelNorth = new JPanel();
        contentPane.add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new GridBagLayout());

        JLabel lblTitle = new JLabel("Votre Panier");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(new Color(255, 140, 0));
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.gridwidth = 2;
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 0;
        panelNorth.add(lblTitle, gbc_lblTitle);

        JButton btnRecalculate = new JButton("Recalculer le Panier");
        btnRecalculate.setBackground(Color.RED);
        btnRecalculate.setForeground(Color.WHITE);
        GridBagConstraints gbc_btnRecalculate = new GridBagConstraints();
        gbc_btnRecalculate.insets = new Insets(0, 0, 5, 0);
        gbc_btnRecalculate.gridx = 2;
        gbc_btnRecalculate.gridy = 0;
        panelNorth.add(btnRecalculate, gbc_btnRecalculate);

        JPanel panelCenter = new JPanel();
        contentPane.add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new BorderLayout(0, 0));

        JPanel panelTransporter = new JPanel();
        panelCenter.add(panelTransporter, BorderLayout.NORTH);
        GridBagLayout gbl_panelTransporter = new GridBagLayout();
        gbl_panelTransporter.columnWidths = new int[]{0, 100, 0};
        gbl_panelTransporter.rowHeights = new int[]{0, 0, 0};
        gbl_panelTransporter.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panelTransporter.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panelTransporter.setLayout(gbl_panelTransporter);

        JLabel lblTransporter = new JLabel("Transporteur:");
        lblTransporter.setFont(new Font("Arial", Font.PLAIN, 14));
        lblTransporter.setForeground(new Color(255, 140, 0));
        GridBagConstraints gbc_lblTransporter = new GridBagConstraints();
        gbc_lblTransporter.insets = new Insets(0, 0, 5, 5);
        gbc_lblTransporter.anchor = GridBagConstraints.WEST;
        gbc_lblTransporter.gridx = 0;
        gbc_lblTransporter.gridy = 0;
        panelTransporter.add(lblTransporter, gbc_lblTransporter);

        JComboBox<String> comboBoxTransporter = new JComboBox<>();
        comboBoxTransporter.setModel(new DefaultComboBoxModel(new String[]{"ChronoRelais", "ChronoFresh", "Colissimo"}));
        GridBagConstraints gbc_comboBoxTransporter = new GridBagConstraints();
        gbc_comboBoxTransporter.insets = new Insets(0, 0, 5, 0);
        gbc_comboBoxTransporter.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxTransporter.gridx = 1;
        gbc_comboBoxTransporter.gridy = 0;
        panelTransporter.add(comboBoxTransporter, gbc_comboBoxTransporter);
        
        
        JLabel lblFreeShipping = new JLabel("Frais de port offerts à partir de 120 €");
        lblFreeShipping.setFont(new Font("Arial", Font.PLAIN, 12));
        GridBagConstraints gbc_lblFreeShipping = new GridBagConstraints();
        gbc_lblFreeShipping.gridwidth = 2;
        gbc_lblFreeShipping.insets = new Insets(0, 0, 0, 5);
        gbc_lblFreeShipping.gridx = 0;
        gbc_lblFreeShipping.gridy = 1;
        panelTransporter.add(lblFreeShipping, gbc_lblFreeShipping);

        JScrollPane scrollPane = new JScrollPane();
        panelCenter.add(scrollPane, BorderLayout.CENTER);
        
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Produit", "Quantité", "Prix"}) {
            boolean[] columnEditables = new boolean[]{false, false, false};

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);

        JPanel panelSouth = new JPanel();
        contentPane.add(panelSouth, BorderLayout.SOUTH);
        GridBagLayout gbl_panelSouth = new GridBagLayout();
        gbl_panelSouth.columnWidths = new int[]{0, 100, 0, 100, 0};
        gbl_panelSouth.rowHeights = new int[]{0, 0, 0, 0};
        gbl_panelSouth.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
        gbl_panelSouth.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        panelSouth.setLayout(gbl_panelSouth);

        JLabel lblSousTotal = new JLabel("Sous-Total :");
        lblSousTotal.setForeground(new Color(255, 140, 0));
        GridBagConstraints gbc_lblSousTotal = new GridBagConstraints();
        gbc_lblSousTotal.insets = new Insets(0, 0, 5, 5);
        gbc_lblSousTotal.gridx = 1;
        gbc_lblSousTotal.gridy = 0;
        panelSouth.add(lblSousTotal, gbc_lblSousTotal);

        sousTotalField = new JTextField();
        sousTotalField.setEditable(false);
        GridBagConstraints gbc_sousTotalField = new GridBagConstraints();
        gbc_sousTotalField.insets = new Insets(0, 0, 5, 5);
        gbc_sousTotalField.fill = GridBagConstraints.HORIZONTAL;
        gbc_sousTotalField.gridx = 2;
        gbc_sousTotalField.gridy = 0;
        panelSouth.add(sousTotalField, gbc_sousTotalField);
        sousTotalField.setColumns(10);

        JLabel lblExpedition = new JLabel("Expédition :");
        lblExpedition.setForeground(new Color(255, 140, 0));
        GridBagConstraints gbc_lblExpedition = new GridBagConstraints();
        gbc_lblExpedition.insets = new Insets(0, 0, 5, 5);
        gbc_lblExpedition.gridx = 1;
        gbc_lblExpedition.gridy = 1;
        panelSouth.add(lblExpedition, gbc_lblExpedition);

        expeditionField = new JTextField();
        expeditionField.setEditable(false);
        GridBagConstraints gbc_expeditionField = new GridBagConstraints();
        gbc_expeditionField.insets = new Insets(0, 0, 5, 5);
        gbc_expeditionField.fill = GridBagConstraints.HORIZONTAL;
        gbc_expeditionField.gridx = 2;
        gbc_expeditionField.gridy = 1;
        panelSouth.add(expeditionField, gbc_expeditionField);
        expeditionField.setColumns(10);

        JLabel lblTotal = new JLabel("Total :");
        lblTotal.setForeground(new Color(255, 140, 0));
        GridBagConstraints gbc_lblTotal = new GridBagConstraints();
        gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
        gbc_lblTotal.gridx = 1;
        gbc_lblTotal.gridy = 2;
        panelSouth.add(lblTotal, gbc_lblTotal);

        totalField = new JTextField();
        totalField.setEditable(false);
        GridBagConstraints gbc_totalField = new GridBagConstraints();
        gbc_totalField.insets = new Insets(0, 0, 0, 5);
        gbc_totalField.fill = GridBagConstraints.HORIZONTAL;
        gbc_totalField.gridx = 2;
        gbc_totalField.gridy = 2;
        panelSouth.add(totalField, gbc_totalField);
        totalField.setColumns(10);

        JButton btnValider = new JButton("Valider le Panier");
        btnValider.setBackground(new Color(255, 165, 0));
        GridBagConstraints gbc_btnValider = new GridBagConstraints();
        gbc_btnValider.insets = new Insets(0, 0, 5, 0);  
        gbc_btnValider.gridx = 3;
        gbc_btnValider.gridy = 0;
        panelSouth.add(btnValider, gbc_btnValider);
        
        JButton btnVider = new JButton("Vider le Panier");
        btnVider.setBackground(Color.RED);
        btnVider.setForeground(Color.WHITE);
        GridBagConstraints gbc_btnVider = new GridBagConstraints();
        gbc_btnVider.insets = new Insets(5, 0, 5, 0);  
        gbc_btnVider.gridx = 3;
        gbc_btnVider.gridy = 1;
        panelSouth.add(btnVider, gbc_btnVider);
        
        JButton btnContinuer = new JButton("Continuer les achats");
        btnContinuer.setBackground(new Color(255, 165, 0));
        GridBagConstraints gbc_btnContinuer = new GridBagConstraints();
        gbc_btnContinuer.insets = new Insets(0, 0, 0, 0);  
        gbc_btnContinuer.gridx = 3;
        gbc_btnContinuer.gridy = 2;
        panelSouth.add(btnContinuer, gbc_btnContinuer);
        
        comboBoxTransporter.addActionListener(e -> {
            panier.setTransporteur((String) comboBoxTransporter.getSelectedItem());
            rafraichirPanier();
        });
        
        //Fermer fenetre Page Panier
        btnContinuer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        //afficher Coordonnees
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Page_Coordonnees coordonnees = new Page_Coordonnees(panier, tableModel);                 
            	coordonnees.setVisible(true);
            }
        });
        
        rafraichirPanier();

        btnVider.addActionListener(e -> viderPanier());

        btnRecalculate.addActionListener(e -> rafraichirPanier());
    }
    
    
    
    private void viderPanier() {
        panier.vider(); // Appeler une méthode vider() dans la classe Panier
        rafraichirPanier(); // Mettre à jour l'affichage du panier après avoir vidé
    }
    

    void rafraichirPanier() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Article article : panier.getArticles()) {
            model.addRow(new Object[]{article.toString(), panier.getQuantite(article), article.getPrixTTC()});
        }

        sousTotalField.setText(String.format("%.2f €", panier.getTotal()));
        double fraisExpedition = panier.getFraisExpedition();//float friasexpedition = getFraisExpedition
        expeditionField.setText(String.format("%.2f €", fraisExpedition));
        totalField.setText(String.format("%.2f €", panier.getTotal() + fraisExpedition));
    }


}
