import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {  

        // fazer um conexao HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // pegar só os dados que interesam (titulo, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("Título: "+filme.get("title")+"\u001b[0m");
            System.out.println("Poster: "+filme.get("image"));
        

            String stars = "";
            int somaestrelas;
            
            for (somaestrelas = 0;somaestrelas < Double.valueOf(filme.get("imDbRating")).intValue();somaestrelas++) {
                stars += "\u2B50";

            }
            
            System.out.println("\u001b[45mClassiificação: " + filme.get("imDbRating") +" \u001b[m");
            System.out.println(stars); 

        }





    }
}

//parei aula 1 1:23
