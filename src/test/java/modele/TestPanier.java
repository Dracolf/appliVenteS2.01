package modele;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TestPanier {
	
	private LinkedList<String> listeVide = new LinkedList<>();
	private Fromage fromage = new Fromage("conte");
	private Article article = new Article(fromage,"conte",18);
	private Panier panier = new Panier();
	private LinkedList<Article> listeContenantArticleTest = new LinkedList<>();
	
	@Before
	public void setUp() {
		panier.ajouterArticle(article, 1);
	}
	
	@After
	public void tearDown() {
		this.panier = null;
	}
	
	@Test
	public void testPanierVide() {
		Panier P = new Panier();
		assertEquals(listeVide,P.getArticles());
	}
	
	@Test
	public void testPanierAjoutArticle() {
		Panier P = new Panier();
		P.ajouterArticle(article, 1);
		listeContenantArticleTest.add(article);
		assertEquals(listeContenantArticleTest,P.getArticles());
	}
	
	@Test
	public void testPanierQuantité() {
		Panier P = new Panier();
		P.ajouterArticle(article, 3);
		assertEquals(3,P.getQuantite(article));
	}
	
	@Test
	public void testPanierTotal() {
		Panier P = new Panier();
		P.ajouterArticle(article, 3);
		assertEquals(54,P.getTotal(),0);
	}
	
	@Test
	public void testPanierVidée() {
		panier.vider(); 
		assertEquals(listeVide,panier.getArticles());
	}

}
