import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json){
        
        // Extrair só os dados que interessam (título, poster e classificação)
        // Mapeando uma lista em outra lista
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeAtributos = parser.parse(json);
        
        return ListaDeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
            .toList();
        

        /* Código velho !!!!!!!!!!!!!

        List<Conteudo> conteudos = new ArrayList<>();
        
        // popular a lista de conteúdos
         for (Map<String, String> atributos : ListaDeAtributos) {
             String titulo = atributos.get("title");
             String urlImagem = atributos.get("url");

             var conteudo = new Conteudo(titulo, urlImagem);

             conteudos.add(conteudo);
             } 

         return conteudos;
         /* */
    }
}
