package modele;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestCalculsFacture {
	

	private Fromage fromage = new Fromage("unfromage");
	private Article TestConte = new Article(fromage,"conte",18);
	private Article TestCamembert = new Article(fromage,"camembert",7);
	private Article TestEpoises = new Article(fromage,"Epoises",12);
	private Article TestPavé = new Article(fromage,"conté",5);
	
	private Panier panier = new Panier();
	
	@Before
	public void setUp() {
		panier.ajouterArticle(TestConte, 2);
		panier.ajouterArticle(TestCamembert, 4);
		panier.ajouterArticle(TestEpoises, 3);
		panier.ajouterArticle(TestPavé, 6);
	}
	
	@After
	public void tearDown() {
		this.panier = null;
	}
	
	@Test
	public void TestCalculsFactureVide() {
		Panier P = new Panier();
		assertEquals(0,P.getTotal(),0);
	}
	
	@Test
	public void TestCalculsFactureRemplie() {
		assertEquals(130,panier.getTotal(),0);
	}
	
	@Test
	public void TestCalculsFactureVidée() {
		panier.vider();
		assertEquals(0,panier.getTotal(),0);
	}
}