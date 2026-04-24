# Analyseur de fichiers CSV — Java

## Auteure
- Nassima Redouane

## Description
Programme Java qui lit un fichier CSV contenant des colonnes numériques
et calcule automatiquement des statistiques pour chaque colonne :
moyenne, minimum et maximum. Les résultats peuvent être affichés dans
la console et exportés dans un nouveau fichier CSV.

## Fonctionnalités
- Lire et parser un fichier CSV
- Calculer la moyenne, le minimum et le maximum par colonne
- Afficher les résultats formatés dans la console
- Exporter les résultats dans un fichier CSV
- Gérer les erreurs : fichier introuvable, fichier vide, valeurs non numériques

## Structure du projet
- `Interface_analyser.java` — interface définissant le contrat d'analyse
- `Lecteur_CSV.java`        — lecture et parsing du fichier CSV
- `Statistique_CSV.java`    — calcul des statistiques par colonne
- `Afficher.java`           — affichage des résultats dans la console
- `Exporter_CSV.java`       — export des résultats dans un fichier CSV
- `MyMain.java`             — point d'entrée du programme

## Prérequis
- Java JDK 8 ou plus récent
- Un fichier CSV avec des colonnes numériques en première ligne

## Utilisation
1. Compiler et lancer le programme
2. Entrer le chemin du fichier CSV quand demandé
3. Les résultats s'affichent dans la console
4. Choisir `oui` pour exporter les résultats, `non` pour quitter

## Exemple de fichier CSV accepté
```csv
Temperature,Pression,Humidite
23.5,101.3,65.0
18.2,99.8,70.1
30.1,102.5,60.3
```

## Principes appliqués
- **SRP** — chaque classe a une seule responsabilité
- **OCP** — ajout de nouveaux analyseurs possible sans modifier le code existant
- **ISP** — interfaces séparées selon les responsabilités
- **LSP** — `Statistique_CSV` respecte le contrat de `Interface_analyser`
