import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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

        // fazer uma conexão HTTP e buscar top filmes
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // pegar só os dados que interessam (Título, imagem do filme, classificação)
        var parse = new JsonParser();
        List<Map<String, String>> ListaDeFilmes = parse.parse(body);
        
        // criar um diretório de saída para as figurinhas
        var diretorio = new File("figurinhas/");
            diretorio.mkdir();

        // exibir e manipular os dados
        var geradora = new GeradorDeStickers();
        for (int i = 0; i< 10; i++) {
            Map<String,String> filme = ListaDeFilmes.get(i);
            
            String urlImagem = filme.get("image");
            String titulo = filme.get("fullTitle");

            
            InputStream inputStream = new URL(urlImagem).openStream();
            
            String nomeArquivo = "figurinhas/" + titulo + ".png";
            // Não é possível criar nenhum arquivo no Windows com o caractere :
            // Então os filmes que contém ":" no nome foram trocados por "-" para poder ser criado o arquivo .png
            nomeArquivo = nomeArquivo.replace(":", "-");


            geradora.cria(inputStream, nomeArquivo);

            System.out.println("\u001b[1m Título:\u001b[m " + filme.get("fullTitle"));
            System.out.println("\u001b[1m Link-Imagem:\u001b[m " + filme.get("image"));
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int estrelas = (int) classificacao;
            for (int n = 1; n <= estrelas; n++){
                System.out.print("⭐");
            }
            
            // rodar o comando chcp 65001 no terminal do vscode para aparecer o emoji
            
            System.out.print("\n");      
            
        }
        
    }
}
