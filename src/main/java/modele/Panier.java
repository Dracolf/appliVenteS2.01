package modele;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class Panier {
    private Map<Article, Integer> articles;
    private String transporteur;

    public void vider() {
        articles.clear(); // Vider la liste d'articles
    }

    public Panier() {
        articles = new HashMap<>();
        transporteur = "Colissimo";
    }

    public void setTransporteur(String transporteur) {
        this.transporteur = transporteur;
    }

    public void ajouterArticle(Article article, int quantite) {
    	if (quantite < 1) {
    		return;
    	}
    	for (Article a : getArticles()) {
    		if (article.equals(a)) {
    			articles.put(article, articles.get(article) + quantite);
    			return;
    		}
    	}
        articles.put(article, quantite);
    }

    public List<Article> getArticles() {
        return new LinkedList<>(articles.keySet());
    }

    public int getQuantite(Article article) {
        return articles.get(article);
    }

    public float getTotal() {
        float total = 0;
        for (Map.Entry<Article, Integer> entry : articles.entrySet()) {
            total += entry.getKey().getPrixTTC() * entry.getValue();
        }
        return total;
    }

    public float getFraisExpedition() {
        float total = getTotal();
        switch (transporteur) {
            case "Colissimo":
            case "ChronoRelais":
                if (total < 60) return 14.90f;
                else if (total < 90) return 9.90f;
                else if (total < 120) return 4.90f;
                else return 0.0f;
            case "ChronoFresh":
                if (total < 50) return 23.80f;
                else if (total < 80) return 17.80f;
                else if (total < 120) return 9.90f;
                else return 0.0f;
            default:
                return 0.0f; 
        }
    }

    public List<Article> getContenu() {
        return getArticles();
    }
}
