package modele;

public class GestionnaireStockage {
	
	public GestionnaireStockage() {
		
	}
	
	public int getStock(Panier panier, Article article) {
		for (Article a : panier.getArticles()) {
    		if (article.equals(a)) {
    	    		return article.getQuantitéEnStock() - panier.getQuantite(article);
    	    }
		}
		return article.getQuantitéEnStock();
    }
	
    	
}

