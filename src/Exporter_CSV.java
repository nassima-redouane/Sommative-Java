import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exporter_CSV {

    private Statistique_CSV statistiques;

    public Exporter_CSV(Statistique_CSV statistiques) {
        this.statistiques = statistiques;
    }

    public void exporter(String cheminSortie) throws IOException {
        if (cheminSortie == null || cheminSortie.trim().isEmpty()) {
            throw new IllegalArgumentException("Erreur : le chemin de sortie est invalide !");
        }
        if (statistiques.getNbColonnes() == 0) {
            throw new IllegalStateException("Erreur : aucune donnée à exporter.");
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(cheminSortie))) {
            pw.println("Colonne,Moyenne,Minimum,Maximum");
            for (int i = 0; i < statistiques.getNbColonnes(); i++) {
                pw.printf("%s,%.2f,%.2f,%.2f%n",
                        statistiques.getNomsColonnes()[i],
                        statistiques.getMoyennes()[i],
                        statistiques.getMins()[i],
                        statistiques.getMaxs()[i]
                );
            }
            System.out.println("Résultats exportés avec succès dans : " + cheminSortie);
        }
    }
}
