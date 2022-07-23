import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {  

        // fazer um conexao HTTP 

        //String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoImDB();

        //String url =  "https://api.nasa.gov/planetary/apod?api_key=VTrL78LuQEFGd999Ycryme4hQt3cEu6P7aDj7wd0&start_date=2022-06-01&end_date=2022-06-15";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoImDB();
        


        var http = new ClienteHttp();
        String jason = http.buscaDados(url);
     
        List<Conteudo> conteudos = extrator.extraiConteudos(jason);
        
        var geradora = new GeradorDeFiguras();

        for (int i = 0; i < 2; i++) {

            Conteudo conteudo = conteudos.get(i);


            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            
            String nomeArquivo ="saida/" + conteudo.getTitulo().replace(":", "-") + ".png";
            
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo()); 
            
        }

    }
}

