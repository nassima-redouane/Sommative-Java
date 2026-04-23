import java.util.List;

public class Afficher {

    private Statistique_CSV statistiques;

    public Afficher(Statistique_CSV statistiques) {
        this.statistiques = statistiques;
    }

    public void afficherResultats() {
        if (statistiques.getNbColonnes() == 0) {
            System.out.println("Aucun résultat à afficher.");
            return;
        }

        System.out.println("=== Résultats ===");
        for (int i = 0; i < statistiques.getNbColonnes(); i++) {
            System.out.println("Colonne  : " + statistiques.getNomsColonnes()[i]);
            System.out.printf("  Moyenne : %.2f%n", statistiques.getMoyennes()[i]);
            System.out.printf("  Min     : %.2f%n", statistiques.getMins()[i]);
            System.out.printf("  Max     : %.2f%n", statistiques.getMaxs()[i]);
            System.out.println("---");
        }
    }
}