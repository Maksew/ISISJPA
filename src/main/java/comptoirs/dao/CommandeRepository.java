package comptoirs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import comptoirs.entity.Commande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    /**
     * Calcule le montant total des articles commandés dans une commande
     * @param numeroCommande le numéro de la commande à traiter
     * @return le montant des articles commandés, en tenant compte de la remise
     */
    @Query("""
        SELECT SUM(l.quantite * p.prixUnitaire * (1 - c.remise))
        FROM Commande c
        JOIN c.lignes l
        JOIN l.produit p
        WHERE c.numero = :numeroCommande
        """)
    BigDecimal montantArticles(@Param("numeroCommande") Integer numeroCommande);

}
