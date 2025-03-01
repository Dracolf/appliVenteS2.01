package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import modele.Article;
import modele.Fromage;
import modele.GestionnaireStockage;
import modele.Panier;

public class Page_Description extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Fromage fromage;
    private Panier panier;
    private SpinnerNumberModel spinnermodel;
    private List<Article> articles;
	private JComboBox<String> comboBox; 
    
    public Page_Description(Fromage fromage, Panier panier) {
        this.fromage = fromage;
        this.panier = panier;
        setTitle("Description du Fromage");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 697, 406);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JPanel panel_2 = new JPanel();
        panel_1.add(panel_2, BorderLayout.NORTH);

        JLabel lblNewLabel_3 = new JLabel(fromage.getDésignation());
        panel_2.add(lblNewLabel_3);

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        JPanel panel_8 = new JPanel();
        panel_3.add(panel_8, BorderLayout.CENTER);
        panel_8.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel();
        panel_8.add(lblNewLabel, BorderLayout.CENTER);
        lblNewLabel.setIcon(new ImageIcon(".\\src\\\\main\\\\resources\\\\images\\fromages\\hauteur200\\" + fromage.getNomImage() + ".jpg"));

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new TitledBorder(null, "Descriptions", TitledBorder.LEADING, TitledBorder.TOP, null, Color.ORANGE));
        panel.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        JTextArea textArea = new JTextArea(fromage.getDescription());
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel_4.add(scrollPane, BorderLayout.CENTER);

        JPanel panel_5 = new JPanel();
        contentPane.add(panel_5, BorderLayout.SOUTH);
        panel_5.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel panel_6 = new JPanel();
        panel_5.add(panel_6);

        comboBox = new JComboBox<>();
        
        panel_6.add(comboBox);
        articles = fromage.getArticles();
        for (Article a : articles) {
            comboBox.addItem(a.toString());
            System.out.println(a.toString() + a.getQuantitéEnStock());
        }
       
        spinnermodel = new SpinnerNumberModel(1, 1, 1 , 1);
        JSpinner spinner = new JSpinner(spinnermodel);
        panel_6.add(spinner);
        setMaxSpinner();
        miseAJourMaxSpinner();
        
        JPanel panel_7 = new JPanel();
        panel_5.add(panel_7);

        JButton btnAjouterPanier = new JButton("Ajouter au panier");
        panel_7.add(btnAjouterPanier);

        JButton btnAnnuler = new JButton("Annuler");
        panel_7.add(btnAnnuler);

        btnAjouterPanier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Article article = fromage.getArticles().get(comboBox.getSelectedIndex());
                int quantite = (Integer) spinner.getValue();
                panier.ajouterArticle(article, quantite);
                dispose();
            }
        });

        btnAnnuler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

	private void miseAJourMaxSpinner() {
		comboBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setMaxSpinner();
        	}
        });
	}
	
	private void setMaxSpinner() {
			spinnermodel.setValue(1);
    		Article a = articles.get(comboBox.getSelectedIndex());
    		int stock = new GestionnaireStockage().getStock(panier, a);
    		System.out.println("Stock restant : " + stock);
    		if (stock == 0) {
    			spinnermodel.setMaximum(0);
    			spinnermodel.setValue(0);
    		    spinnermodel.setMinimum(0);
    		} else {
    			spinnermodel.setMaximum(stock);
    		}
	}
}
