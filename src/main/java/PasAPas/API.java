package PasAPas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.json.JSONObject;

public class API {

    // URL de base de l'API pour les planètes
    private static final String PLANETS_API_URL = "https://swapi.tech/api/planets/";
    
 // URL de base de l'API pour les films
    private static final String FILMS_API_URL = "https://swapi.tech/api/films/";

    public JSONObject getPlanets(String searchquery) {
        try {
            // Construction de l'URL de l'API avec la recherche si spécifiée
            String urlString = PLANETS_API_URL;
            if (searchquery != null && !searchquery.isEmpty()) {
                urlString += "?name=" + searchquery;
            }
            
            System.out.println("searchquery : "+ searchquery);
            
            // Création de l'objet URI pour l'URL de l'API
            URI uri = new URI(urlString);
            
            System.out.println("URL : " + urlString);
            System.out.println("URI : " + uri);
            
            // Ouverture d'une connexion HTTP
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Lecture de la réponse de l'API
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder responseBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                responseBuilder.append(scanner.nextLine());
            }
            scanner.close();

            // Conversion de la réponse en JSONObject
            return new JSONObject(responseBuilder.toString());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public JSONObject getFilms(String searchquery) {
        try {
            // Construction de l'URL de l'API avec la recherche si spécifiée
            String urlString2 = FILMS_API_URL;
            if (searchquery != null && !searchquery.isEmpty()) {
            	urlString2 += "?title=" + searchquery;
            }
            
            System.out.println("searchquery : "+ searchquery);
            
            // Création de l'objet URI pour l'URL de l'API
            URI uri2 = new URI(urlString2);
            
            System.out.println("URL : " + urlString2);
            System.out.println("URI : " + uri2);
            
            // Ouverture d'une connexion HTTP
            HttpURLConnection conn = (HttpURLConnection) uri2.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Lecture de la réponse de l'API
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder responseBuilder = new StringBuilder();
            while (scanner.hasNext()) {
                responseBuilder.append(scanner.nextLine());
            }
            scanner.close();

            // Conversion de la réponse en JSONObject
            return new JSONObject(responseBuilder.toString());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
