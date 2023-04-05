import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json){
    var parser = new JsonParser();
    List<Map<String, String>> ListaDeAtributos = parser.parse(json);

    return ListaDeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("image")))
            .toList();    
    }
}
