import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MyMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Lire le chemin du fichier CSV
            System.out.print("Entrez le chemin du fichier CSV : ");
            String chemin = scanner.nextLine().trim();

            if (chemin.isEmpty()) {
                System.out.println("Erreur : le chemin ne peut pas être vide !");
                return;
            }

            // Lire le fichier CSV
            Lecteur_CSV reader = new Lecteur_CSV(chemin);
            String[] entetes;
            List<String[]> donnees;

            try {
                entetes = reader.lireEntetes();
                donnees = reader.lireDonnees();
            } catch (FileNotFoundException e) {
                System.out.println("Erreur : le fichier '" + chemin + "' est introuvable !");
                return;
            } catch (IOException e) {
                System.out.println("Erreur lors de la lecture : " + e.getMessage());
                return;
            }

            // Analyser les données
            Statistique_CSV statistiques = new Statistique_CSV(entetes);

            statistiques.analyser(donnees);

            // Afficher les résultats
            Afficher afficher = new Afficher(statistiques);
            afficher.afficherResultats();

            // Demander si l'utilisateur veut exporter
            System.out.print("\nVoulez-vous exporter les résultats ? (oui/non) : ");
            String reponse = scanner.nextLine().trim();

            if (reponse.equalsIgnoreCase("oui")) {
                System.out.print("Entrez le chemin du fichier de sortie : ");
                String cheminSortie = scanner.nextLine().trim();

                Exporter_CSV exporteur = new Exporter_CSV(statistiques);
                try {
                    exporteur.exporter(cheminSortie);
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Erreur : " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("Erreur lors de l'export : " + e.getMessage());
                }
            }

        } finally {
            scanner.close();
        }
    }
}
