import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {  
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

    //  Independente da url que for passada, o programa irá ler o conteúdo e irá extrair os conteúdos 
    //  que forem solicitados e transformará tudo em figurinha no diretório "saída"    

        // fazer uma conexão HTTP e buscar top filmes ou buscar as imagens da Nasa ou imgs da API 
       
        // troque por API.NASA e API.LOCALHOST para testar os outros 
        API api = API.LOCALHOST;

        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        
        // criar um diretório de saída para a saída
        var diretorio = new File("saída/");
            diretorio.mkdir();

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradorDeStickers();

        // alterar o valor da condição para pegar mais imagens de acordo com a API escolhida
        for (int i = 0; i< 7; i++) {
            Conteudo conteudo = conteudos.get(i);
                      
            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();   
            String nomeArquivo = "saída/" + conteudo.titulo() + ".png";

            // Não é possível criar nenhum arquivo no Windows com o caractere :
            // Então os filmes que contém ":" no nome foram trocados por "-" para poder ser criado o arquivo .png
            nomeArquivo = nomeArquivo.replace(":", "-");
            
            /* 
            System.out.println("\u001b[1m Título:\u001b[m " + filme.get("fullTitle"));
            System.out.println("\u001b[1m Link-Imagem:\u001b[m " + filme.get("image"));
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int estrelas = (int) classificacao;
            for (int n = 1; n <= estrelas; n++){
                System.out.print("⭐");
            }
            
             rodar o comando chcp 65001 no terminal do vscode para aparecer o emoji

            */
            
            geradora.cria(inputStream, nomeArquivo);
            System.out.println(conteudo.titulo());
            System.out.println();
   
            
        }
        
    }
}
