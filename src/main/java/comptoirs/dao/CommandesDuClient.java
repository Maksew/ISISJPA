package comptoirs.dao;

public interface CommandesDuClient {
    Integer getNumeroCommande();
    java.math.BigDecimal getPort();
    java.math.BigDecimal getMontantArticles();
}
