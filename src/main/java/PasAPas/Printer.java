package PasAPas;

import org.json.JSONArray;
import org.json.JSONObject;

public class Printer {

    public void printDetailsPlanets(JSONArray planetresults) {
        // Parcours des résultats des planètes
        for (int i = 0; i < planetresults.length(); i++) {
            // Extraction des détails d'une planète
            JSONObject planet = planetresults.getJSONObject(i);
            System.out.println("Planet : " + planet.getString("name"));
            System.out.println("Rotation Period : " + planet.getString("rotation_period"));
            System.out.println("Orbital Period : " + planet.getString("orbital_period"));
            System.out.println("Diameter : " + planet.getString("diameter"));
            System.out.println("Gravity : " + planet.getString("gravity"));
            System.out.println("Terrain : " + planet.getString("terrain"));
            System.out.println("Surface water : " + planet.getString("surface_water"));
            System.out.println("Population : " + planet.getString("population"));

            // Impression des résidents de la planète
            JSONArray residents = planet.getJSONArray("residents");
            System.out.println("\nResidents :");
            printArrayValues(residents, "name");

            // Impression des films associés à la planète
            JSONArray films = planet.getJSONArray("films");
            System.out.println("\nFilms :");
            printArrayValues(films, "title");

            System.out.println("\n");
        }
    }
    
    
    
    public void printDetailsFilms(JSONArray filmresults) {
        // Parcours des résultats des planètes
        for (int i = 0; i < filmresults.length(); i++) {
            // Extraction des détails d'une planète
            JSONObject film = filmresults.getJSONObject(i);
            System.out.println("Title: " + film.getString("title"));
            System.out.println("Episode n°: " + film.getInt("episode_id"));
            System.out.println("Opening: " + film.getString("opening_crawl"));
            System.out.println("Réalisateur: " + film.getString("director"));
            System.out.println("Producteurs: " + film.getString("producer"));
            System.out.println("Date de sortie: " + film.getString("release_date"));
            
            JSONArray characters = film.getJSONArray("characters");
            System.out.println("\nCharacters :");
            printArrayValues(characters, "name");

            // Impression des films associés à la planète
            JSONArray planets = film.getJSONArray("planets");
            System.out.println("\nPlanets :");
            printArrayValues(planets, "name");
            

        }
    }
    
    
    

    private void printArrayValues(JSONArray jsonArray, String key) {
        if (jsonArray != null) {
            // Parcours des valeurs du tableau
            for (int j = 0; j < jsonArray.length(); j++) {
                String value = jsonArray.getString(j);
                System.out.println(value);
            }
            // Si le tableau est vide, afficher un message
            if (jsonArray.length() == 0) {
                System.out.println("No results");
            }
        }
    }
}