package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.table.DefaultTableModel;

import modele.Panier;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Page_Facture extends JFrame {
	
	private String[] data;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;

	public Page_Facture(String[] data, Panier panier, DefaultTableModel tableModel) {
		this.data = data;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Votre Facture");
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(".\\src\\main\\resources\\images\\icones\\img_frommage_page_facture.jpg"));
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 128, 0), new Color(0, 128, 0), new Color(0, 128, 0), new Color(0, 128, 0)));
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Merci de votre visite");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_6 = new JPanel();
		FlowLayout fl_panel_6 = (FlowLayout) panel_6.getLayout();
		fl_panel_6.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_6);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Fromagerie BlancJus pour vous servir et vous resservir en fromages");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_6.add(lblNewLabel_3_1_1);
		
		JPanel panel_7 = new JPanel();
		FlowLayout fl_panel_7 = (FlowLayout) panel_7.getLayout();
		fl_panel_7.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_7);
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        
		JLabel lblNewLabel_4_1_1 = new JLabel("Commande du "+formattedDateTime+" heure d'été d'Europe centrale");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel_7.add(lblNewLabel_4_1_1);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_9 = new JPanel();
		panel_8.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_10 = new JPanel();
		FlowLayout fl_panel_10 = (FlowLayout) panel_10.getLayout();
		fl_panel_10.setAlignment(FlowLayout.LEFT);
		panel_9.add(panel_10);
		
		JLabel lblNewLabel_5_1 = new JLabel(""+this.data[1]+" "+this.data[0]);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		panel_10.add(lblNewLabel_5_1);
		
		JPanel panel_11 = new JPanel();
		FlowLayout fl_panel_11 = (FlowLayout) panel_11.getLayout();
		fl_panel_11.setAlignment(FlowLayout.LEFT);
		panel_9.add(panel_11);
		
		JLabel lblNewLabel_6_1 = new JLabel("Adresse :");
		panel_11.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel(""+this.data[2]+" "+this.data[3]+" "+this.data[4]+" "+this.data[5]);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel_11.add(lblNewLabel_7_1);
		
		JPanel panel_12 = new JPanel();
		FlowLayout fl_panel_12 = (FlowLayout) panel_12.getLayout();
		fl_panel_12.setAlignment(FlowLayout.LEFT);
		panel_9.add(panel_12);
		
		JLabel lblNewLabel_8_1 = new JLabel("Téléphone :");
		panel_12.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel(""+this.data[6]);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel_12.add(lblNewLabel_9_1);
		
		JPanel panel_13 = new JPanel();
		FlowLayout fl_panel_13 = (FlowLayout) panel_13.getLayout();
		fl_panel_13.setAlignment(FlowLayout.LEFT);
		panel_9.add(panel_13);
		
		JLabel lblNewLabel_10_1 = new JLabel("Mèl :");
		panel_13.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_11_1 = new JLabel(""+this.data[7]);
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		panel_13.add(lblNewLabel_11_1);
		
		JPanel panel_14 = new JPanel();
		panel_8.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		table_1 = new JTable(tableModel);
		panel_14.add(table_1);
		
		JPanel panel_15 = new JPanel();
		panel_4.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_16 = new JPanel();
		FlowLayout fl_panel_16 = (FlowLayout) panel_16.getLayout();
		fl_panel_16.setAlignment(FlowLayout.LEFT);
		panel_15.add(panel_16);
		
		JLabel lblNewLabel_4_2_1_1 = new JLabel("TOTAL TTC COMMANDE :");
		panel_16.add(lblNewLabel_4_2_1_1);
		
		JLabel lblNewLabel_7_2_1_1 = new JLabel(String.format("%.2f €", panier.getTotal()));
		panel_16.add(lblNewLabel_7_2_1_1);
		
		JPanel panel_17 = new JPanel();
		FlowLayout fl_panel_17 = (FlowLayout) panel_17.getLayout();
		fl_panel_17.setAlignment(FlowLayout.LEFT);
		panel_15.add(panel_17);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("FRAIS DE TRANSPORT :");
		panel_17.add(lblNewLabel_5_2_1_1);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel(String.format("%.2f €", panier.getFraisExpedition()));
		panel_17.add(lblNewLabel_8_1_1_1);
		
		JPanel panel_18 = new JPanel();
		FlowLayout fl_panel_18 = (FlowLayout) panel_18.getLayout();
		fl_panel_18.setAlignment(FlowLayout.LEFT);
		panel_15.add(panel_18);
		
		JLabel lblNewLabel_6_2_1_1 = new JLabel("PRIX TOTAL TTC :");
		lblNewLabel_6_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_18.add(lblNewLabel_6_2_1_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel(String.format("%.2f €", panier.getFraisExpedition() + panier.getTotal()));
		lblNewLabel_9_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_18.add(lblNewLabel_9_1_1_1);
		
		JPanel panel_20 = new JPanel();
		panel_1.add(panel_20, BorderLayout.SOUTH);
		panel_20.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton Bouton_Imprimer = new JButton("Imprimer");
		Bouton_Imprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPrintable(new Printable() {
                    @Override
                    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
                        if (page > 0) {
                            return NO_SUCH_PAGE;
                        }

                        Graphics2D g2d = (Graphics2D) g;
                        g2d.translate(pf.getImageableX(), pf.getImageableY());
                        g.drawString("Bravo à vous si vous avez découvert cet easter egg ! ", 100, 100);

                        return PAGE_EXISTS;
                    }
                });

                boolean doPrint = job.printDialog();
                if (doPrint) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
		panel_20.add(Bouton_Imprimer);
		
		JButton Bouton_Quitter = new JButton("Quitter");
		panel_20.add(Bouton_Quitter);
		
		Bouton_Quitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
	}
}
