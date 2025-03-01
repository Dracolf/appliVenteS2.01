package ihm;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modele.Article;
import modele.Fromage;
import modele.GenerationFromages;
import modele.GestionnaireStockage;
import modele.Panier;
import modele.TypeLait;

public class Page_Accueil extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel;
    private JPanel header;
    private JPanel panel_titre;
    private JLabel Titre;
    private JLabel lblNewLabel_4;
    private JPanel panel_panier;
    private JLabel lblPanier;
    private JPanel panel_footer;
    private JButton btnQuitter;
    private JScrollPane scrollPane;

    private JLabel lblPrix;
    private JLabel lblTypeDeFromages;
    private JComboBox<String> comboBoxTypeDeFromage;
    private JList<String> listeFromages;
    private DefaultListModel<String> listModel;
    private List<Fromage> fromages;
    private Panier panier;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Page_Accueil frame = new Page_Accueil();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Page_Accueil() {
        panier = new Panier();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 667, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        panel = new JPanel();
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        header = new JPanel();
        panel.add(header, BorderLayout.NORTH);
        header.setLayout(new BorderLayout(0, 0));

        panel_titre = new JPanel();
        header.add(panel_titre, BorderLayout.CENTER);

        Titre = new JLabel("Nos Fromages ");
        Titre.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 15));
        panel_titre.add(Titre);

        lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\fromages\\hauteur40\\brique_de_brebis_fermiere.jpg"));
        lblNewLabel_4.setFont(new Font("Sylfaen", Font.ITALIC, 16));
        panel_titre.add(lblNewLabel_4);

        panel_panier = new JPanel();
        header.add(panel_panier, BorderLayout.EAST);
        panel_panier.setLayout(new BorderLayout(0, 0));

        lblPanier = new JLabel("");
        lblPanier.setIcon(new ImageIcon(".\\\\src\\main\\resources\\images\\fromages\\hauteur40\\icon_panier.png"));
        panel_panier.add(lblPanier, BorderLayout.CENTER);

        lblPanier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Page_Panier pagePanier = new Page_Panier(panier);
                pagePanier.rafraichirPanier();
                pagePanier.setVisible(true);
            }
        });

        lblPrix = new JLabel("0.0");
        panel_panier.add(lblPrix, BorderLayout.EAST);

        JPanel footer = new JPanel();
        panel.add(footer, BorderLayout.SOUTH);
        footer.setLayout(new BorderLayout(0, 0));

        panel_footer = new JPanel();
        footer.add(panel_footer, BorderLayout.CENTER);

        lblTypeDeFromages = new JLabel("");
        lblTypeDeFromages.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\fromages\\hauteur40\\emmentaler_suisse (1).jpg"));
        panel_footer.add(lblTypeDeFromages);

        String[] listTypeFromages = {"Tous les fromages", "Brebis", "Chèvre", "Vache"};

        JComboBox<String> comboBoxTypeDeFromage = new JComboBox<>(listTypeFromages);
        comboBoxTypeDeFromage.setSelectedItem((String) "Tous");
        panel_footer.add(comboBoxTypeDeFromage);

        btnQuitter = new JButton("    Quitter   ");
        btnQuitter.setHorizontalTextPosition(SwingConstants.CENTER);
        footer.add(btnQuitter, BorderLayout.EAST);

        btnQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        scrollPane = new JScrollPane();
        panel.add(scrollPane, BorderLayout.CENTER);

        fromages = new GenerationFromages().générationBaseFromages().getFromages();
        listModel = new DefaultListModel<>();
        for (Fromage fromage : fromages) {
            listModel.addElement(fromage.getDésignation());
        }
        listeFromages = new JList<>(listModel);
        scrollPane.setViewportView(listeFromages);
        setListFromages(comboBoxTypeDeFromage);
        listeFromages.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ouvrirDescription();
            }
        });

        panier = new Panier();
    }

    private void ouvrirDescription() {
        Fromage fromage = null;
        for (Fromage f : fromages) {
            if (f.getDésignation().equals(listeFromages.getSelectedValue())) {
                fromage = f;
            }
        }
        Page_Description description = new Page_Description(fromage, panier);
        description.setVisible(true);
        description.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                updateLblPrix();
            }
        });
    }

    private void setListFromages(JComboBox<String> comboBox) {
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    listModel.removeAllElements();
                    String selectedItem = (String) comboBox.getSelectedItem();

                    for (Fromage fromage : fromages) {
                        if ("Tous les fromages".equals(selectedItem)) {
                            listModel.addElement(fromage.getDésignation());
                        } else if ("Brebis".equals(selectedItem) && fromage.getTypeFromage() == TypeLait.BREBIS) {
                            listModel.addElement(fromage.getDésignation());
                        } else if ("Chèvre".equals(selectedItem) && fromage.getTypeFromage() == TypeLait.CHEVRE) {
                            listModel.addElement(fromage.getDésignation());
                        } else if ("Vache".equals(selectedItem) && fromage.getTypeFromage() == TypeLait.VACHE) {
                            listModel.addElement(fromage.getDésignation());
                        }
                    }
                }
            }
        });
    }

    public Panier getPanier() {
        return panier;
    }

    private void updateLblPrix() {
        lblPrix.setText(String.format("%.2f", panier.getTotal()));
    }
}
