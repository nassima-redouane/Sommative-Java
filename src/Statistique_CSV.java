import java.util.List;

public class Statistique_CSV implements Interface_analyser {

    private String[] nomsColonnes;
    private double[] moyennes;
    private double[] mins;
    private double[] maxs;
    private int nbColonnes;

    // Reçoit les données brutes en paramètre
    public Statistique_CSV(String[] entetes, List<String[]> donnees) {
        this.nomsColonnes = entetes;
        this.nbColonnes = entetes.length;
        analyser(donnees);
    }

    @Override
    public void analyser(List<String[]> donnees) {
        double[] sommes = new double[nbColonnes];
        int[] compteurs  = new int[nbColonnes];
        mins = new double[nbColonnes];
        maxs = new double[nbColonnes];
        moyennes = new double[nbColonnes];

        boolean premiere = true;

        for (String[] valeurs : donnees) { //valeurs represente une ligne
            for (int i = 0; i < nbColonnes; i++) {
                if (i >= valeurs.length) continue; // ligne courte
                try {
                    double val = Double.parseDouble(valeurs[i].trim());
                    if (premiere) { mins[i] = val; maxs[i] = val; }
                    sommes[i] += val;
                    compteurs[i]++;
                    if (val < mins[i]) mins[i] = val;
                    if (val > maxs[i]) maxs[i] = val;
                } catch (NumberFormatException e) {
                    // valeur non numérique, ignorée
                }
            }
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