package PasAPas;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainApi {

    public static void main(String[] args) {
        // Création de l'instance de l'API
        API apiCalls = new API();
        // Création de l'instance de l'imprimante
        Printer printer = new Printer();

        try {
            // Appel à l'API pour récupérer les données des planètes
            JSONObject jsonObject = apiCalls.getPlanets("Alderaan");
            // Extraction des résultats des planètes
            JSONArray planetresults = jsonObject.getJSONArray("result");
            
            System.out.println(planetresults);
            // Impression des détails des planètes
            printer.printDetailsPlanets(planetresults);
            
            // Création d'une instance de HtmlPrinter
            HtmlPrinter htmlPrinter = new HtmlPrinter();

            // Générer le code HTML
            String htmlContent = htmlPrinter.printHtmlDetailsPlanets(jsonObject);

            // Spécifier le chemin du fichier où vous souhaitez enregistrer le contenu HTML
            String filePath = "D:/GRILLOT_Maihea_Richard/2023-2024/Mr.SORE/JAVA Eclipse/StarWars-master/page.html";

            // Enregistrer le contenu HTML dans le fichier spécifié
            htmlPrinter.saveHtmlToFile(htmlContent, filePath);
            
            
            
            
            // Appel à l'API pour récupérer les données des planètes
            JSONObject jsonObject2 = apiCalls.getFilms("Hope");
            // Extraction des résultats des planètes
            JSONArray filmresults = jsonObject2.getJSONArray("result");
            
            System.out.println(filmresults);
            // Impression des détails des planètes
            printer.printDetailsFilms(filmresults);
            
            // Création d'une instance de HtmlPrinter
            HtmlPrinter htmlPrinter2 = new HtmlPrinter();

            // Générer le code HTML
            String htmlContent2 = htmlPrinter2.printHtmlDetailsFilms(jsonObject2);

            // Spécifier le chemin du fichier où vous souhaitez enregistrer le contenu HTML
            String filePath2 = "D:/GRILLOT_Maihea_Richard/2023-2024/Mr.SORE/JAVA Eclipse/StarWars-master/page2.html";

            // Enregistrer le contenu HTML dans le fichier spécifié
            htmlPrinter.saveHtmlToFile(htmlContent2, filePath2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
