import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoImDB implements ExtratorDeConteudo{
    
    public List<Conteudo> extraiConteudos(String jason){

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(jason);
    
        List<Conteudo> conteudos = new ArrayList<>();



        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replace("(@+)(.*).jpg$", "$1.jpg");
            var conteudo = new Conteudo(titulo, urlImagem);
            
            //String stars = "";
            //int somaestrelas;
            
           // for (somaestrelas = 0;somaestrelas < Double.valueOf(conteudo.get("imDbRating")).intValue();somaestrelas++) {
           //  stars += "\u2B50";

           //}
            
           // System.out.println("\u001b[45mClassiificação: " + conteudo.get("imDbRating") +" \u001b[m");
            //System.out.println(stars); 

            
            conteudos.add(conteudo);
        }
        return conteudos;
    
    }
        
    


}
