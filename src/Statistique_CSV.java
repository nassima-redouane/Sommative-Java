import java.util.List;

public class Statistique_CSV implements Interface_analyser {

    private String[] nomsColonnes;
    private double[] moyennes;
    private double[] mins;
    private double[] maxs;
    private int nbColonnes;

    // Reçoit les entetes en paramètre
    public Statistique_CSV(String[] entetes) {
        this.nomsColonnes = entetes;
        this.nbColonnes = entetes.length;
        
    }

    @Override
    public void analyser(List<String[]> donnees) {
        
        // Tableaux temporaires pour accumuler les valeurs
        double[] sommes = new double[nbColonnes];
        int[] compteurs  = new int[nbColonnes];

        // Initialisation des tableaux de résultats
        mins = new double[nbColonnes];
        maxs = new double[nbColonnes];
        moyennes = new double[nbColonnes];

        boolean premiere = true;
        
        // Parcourir chaque ligne du CSV
        for (String[] valeurs : donnees) { //valeurs represente une ligne

            // Parcourir chaque colonne de la ligne
            for (int i = 0; i < nbColonnes; i++) {
                if (i >= valeurs.length) continue; // ligne courte
                try {
                    // Convertir la cellule en nombre
                    double val = Double.parseDouble(valeurs[i].trim());

                    // À la première ligne, initialiser min et max avec la première valeur
                    if (premiere) { mins[i] = val; maxs[i] = val; }

                    // Accumuler la valeur pour calculer la moyenne plus tard
                    sommes[i] += val;
                    compteurs[i]++;
                    if (val < mins[i]) mins[i] = val;
                    if (val > maxs[i]) maxs[i] = val;
                } catch (NumberFormatException e) {
                    // valeur non numérique, ignorée
                }
            }
            // Après la première ligne, ne plus réinitialiser min et max
            premiere = false;
        }

        for (int i = 0; i < nbColonnes; i++) {
            if (compteurs[i] > 0)
                moyennes[i] = sommes[i] / compteurs[i];
        }
    }

    // getters
    public String[] getNomsColonnes() { return nomsColonnes; }
    public double[] getMoyennes()     { return moyennes; }
    public double[] getMins()         { return mins; }
    public double[] getMaxs()         { return maxs; }
    public int getNbColonnes()        { return nbColonnes; }
}
