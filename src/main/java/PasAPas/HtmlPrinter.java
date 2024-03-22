package PasAPas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class HtmlPrinter {
	
	private String codeHtml;
    
	public String printHtmlDetailsPlanets(JSONObject planetData) {
        if (planetData != null) {
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html><head><title>Planets Data</title></head><body>");
            htmlBuilder.append("<h1>Planets Data</h1>");

            // Vérifie si la clé "results" est présente dans le JSON
            if (planetData.has("results")) {
                JSONArray results = planetData.getJSONArray("results");

                // Parcourt chaque objet planète
                for (int i = 0; i < results.length(); i++) {
                    JSONObject planet = results.getJSONObject(i);
                    htmlBuilder.append("<h2>").append("Name: ").append(planet.getString("name")).append("</h2>");
                    htmlBuilder.append("<p>").append("Rotation Period: ").append(planet.getString("rotation_period")).append("</p>");
                    htmlBuilder.append("<p>").append("Orbital Period: ").append(planet.getString("orbital_period")).append("</p>");
                    htmlBuilder.append("<p>").append("Diameter: ").append(planet.getString("diameter")).append("</p>");
                    htmlBuilder.append("<p>").append("Gravity: ").append(planet.getString("gravity")).append("</p>");
                    htmlBuilder.append("<p>").append("Terrain: ").append(planet.getString("terrain")).append("</p>");
                    htmlBuilder.append("<p>").append("Surface Water: ").append(planet.getString("surface_water")).append("</p>");
                    htmlBuilder.append("<p>").append("Population: ").append(planet.getString("population")).append("</p>");
                    System.out.println(codeHtml);
                    
                    // Ajoute les résidents
                    JSONArray residents = planet.getJSONArray("residents");
                    if (residents.length() > 0) {
                        htmlBuilder.append("<p>").append("Residents: ").append("</p><ul>");
                        for (int j = 0; j < residents.length(); j++) {
                            htmlBuilder.append("<li>").append(residents.getString(j)).append("</li>");
                        }
                        htmlBuilder.append("</ul>");
                    }

                    // Ajoute les films
                    JSONArray films = planet.getJSONArray("films");
                    if (films.length() > 0) {
                        htmlBuilder.append("<p>").append("Films: ").append("</p><ul>");
                        for (int j = 0; j < films.length(); j++) {
                            htmlBuilder.append("<li>").append(films.getString(j)).append("</li>");
                        }
                        htmlBuilder.append("</ul>");
                    }
                    
                    
               }
            }
            htmlBuilder.append("</body></html>");

            // Stocke le contenu HTML dans une variable
            codeHtml = htmlBuilder.toString();
            System.out.println(codeHtml);
        }
        
        // Renvoie le contenu HTML généré
        return codeHtml;
    }
	
	
	
	
	
	public String printHtmlDetailsFilms(JSONObject filmData) {
        if (filmData != null) {
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<html><head><title>Films Data</title></head><body>");
            htmlBuilder.append("<h1>Films Data</h1>");

            // Vérifie si la clé "results" est présente dans le JSON
            if (filmData.has("results")) {
                JSONArray results = filmData.getJSONArray("results");

                // Parcourt chaque objet planète
                for (int i = 0; i < results.length(); i++) {
                    JSONObject film = results.getJSONObject(i);
                    htmlBuilder.append("<h2>").append("Title: ").append(film.getString("title")).append("</h2>");
                    htmlBuilder.append("<p>").append("Episode n°: ").append(film.getInt("episode_id")).append("</p>");
                    htmlBuilder.append("<p>").append("Opening: ").append(film.getString("opening_crawl")).append("</p>");
                    htmlBuilder.append("<p>").append("Réalisateur: ").append(film.getString("director")).append("</p>");
                    htmlBuilder.append("<p>").append("Producteurs: ").append(film.getString("producer")).append("</p>");
                    htmlBuilder.append("<p>").append("Date de sortie: ").append(film.getString("release_date")).append("</p>");
                    System.out.println(codeHtml);
               }
            }
            htmlBuilder.append("</body></html>");

            // Stocke le contenu HTML dans une variable
            codeHtml = htmlBuilder.toString();
            System.out.println(codeHtml);
        }
        
        // Renvoie le contenu HTML généré
        return codeHtml;
    }
	
	
	
    
    public void saveHtmlToFile(String htmlContent, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(htmlContent);
            System.out.println("HTML content has been saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
