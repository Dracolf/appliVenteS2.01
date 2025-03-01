package modele;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestMiseAJourStocks {
	
	private Fromage fromage = new Fromage("conté");
	private Article TestConte = new Article(fromage,"conte",18);
	private Article TestCamembert = new Article(fromage,"camembert",7);
	private Panier panier = new Panier();
	private int stockDeConte = TestConte.getQuantitéEnStock();
	private int stockDeCamembert = TestCamembert.getQuantitéEnStock();
	
	GestionnaireStockage gestionnaire = new GestionnaireStockage();
	
	@Before
	public void setUp() {
		panier.ajouterArticle(TestCamembert, 4);
	}
	
	@After
	public void tearDown() {
		this.panier = null;
	}
	
	@Test
	public void test_PanierVide() {
		Panier P = new Panier();
		assertEquals(stockDeCamembert,gestionnaire.getStock(P, TestCamembert));
	}
	
	@Test
	public void test_PanierSansArticleDemande() {
		assertEquals(stockDeConte,gestionnaire.getStock(panier, TestConte));
	}
	
	@Test
	public void test_PanierAvecArticleDemande() {
		assertEquals(stockDeCamembert - 4,gestionnaire.getStock(panier, TestCamembert));
	}
}
