import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar top 250 filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // pegar só os dados que interessam (Título, imagem do filme, classificação)
        var parse = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parse.parse(body);
        

        // exibir e manipular os dados

        for (int i = 0; i< 3; i++) {
            Map<String,String> filme = ListaDeFilmes.get(i);
            System.out.println("\u001b[1m Título:\u001b[m " + filme.get("fullTitle"));
            System.out.println("\u001b[1m Link-Imagem:\u001b[m " + filme.get("image"));
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int estrelas = (int) classificacao;
            for (int n = 1; n <= estrelas; n++){
                System.out.print("⭐");
            }
            
            
            System.out.print("\n");      
            
        }
        
    }
}
