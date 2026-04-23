import java.io.*;
import java.util.*;

public class Lecteur_CSV {

    private String cheminFichier;

    public Lecteur_CSV(String cheminFichier) {
        this.cheminFichier = cheminFichier;
    }

    public String[] lireEntetes() throws IOException {
        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne = lecteur.readLine();
            if (ligne == null || ligne.trim().isEmpty())
                throw new IOException("Fichier CSV vide !");
            return ligne.split(",");
        }
    }

    public List<String[]> lireDonnees() throws IOException {
        List<String[]> donnees = new ArrayList<>();
        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            lecteur.readLine(); // sauter l'en-tête
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                if (!ligne.trim().isEmpty())
                    donnees.add(ligne.split(","));
            }
        }
        return donnees;
    }
}