package PasAPas;

import org.json.JSONArray;
import org.json.JSONObject;

public class Printer {

    public void printDetailsPlanets(JSONArray planetresults) {
        // Parcours des résultats des planètes
        for (int i = 0; i < planetresults.length(); i++) {
            // Extraction des détails d'une planète
            JSONObject planet = planetresults.getJSONObject(i);
            System.out.println("Planet : " + planet.getJSONObject("properties").getString("name"));
            System.out.println("Rotation Period : " + planet.getJSONObject("properties").getString("rotation_period"));
            System.out.println("Orbital Period : " + planet.getJSONObject("properties").getString("orbital_period"));
            System.out.println("Diameter : " + planet.getJSONObject("properties").getString("diameter"));
            System.out.println("Gravity : " + planet.getJSONObject("properties").getString("gravity"));
            System.out.println("Terrain : " + planet.getJSONObject("properties").getString("terrain"));
            System.out.println("Surface water : " + planet.getJSONObject("properties").getString("surface_water"));
            System.out.println("Population : " + planet.getJSONObject("properties").getString("population"));

            // Impression des résidents de la planète
            JSONArray residents = planet.getJSONArray("residents");
            System.out.println("\nResidents :");
            printArrayValues(residents, "name");

//            // Impression des films associés à la planète
//            JSONArray films = planet.getJSONArray("films");
//            System.out.println("\nFilms :");
//            printArrayValues(films, "title");

            System.out.println("\n");
        }
    }
    
    
    
    public void printDetailsFilms(JSONArray filmresults) {
        // Parcours des résultats des planètes
        for (int i = 0; i < filmresults.length(); i++) {
            // Extraction des détails d'une planète
            JSONObject film = filmresults.getJSONObject(i);
            System.out.println("Title: " + film.getJSONObject("properties").getString("title"));
            System.out.println("Episode n°: " + film.getJSONObject("properties").getInt("episode_id"));
            System.out.println("Opening: " + film.getJSONObject("properties").getString("opening_crawl"));
            System.out.println("Réalisateur: " + film.getJSONObject("properties").getString("director"));
            System.out.println("Producteurs: " + film.getJSONObject("properties").getString("producer"));
            System.out.println("Date de sortie: " + film.getJSONObject("properties").getString("release_date"));

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