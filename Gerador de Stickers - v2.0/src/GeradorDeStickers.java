import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GeradorDeStickers {


    public void cria(InputStream inputStream, String nomeArquivo ) throws Exception {

    // leitura de imagem
        //InputStream inputStream  = 
        //            new FileInputStream(new File("emtrada/filme.jpg"));
       // InputStream inputStream = 
       //              new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_3.jpg")
        ///            .openStream();
        //comparação de métodos de InputStream para se observar!!
                
        BufferedImage ImagemOriginal = ImageIO.read(inputStream);

    // cria uma nova imagem em memória com transparência e com tamanho novo
       int largura = ImagemOriginal.getWidth();
       int altura  = ImagemOriginal.getHeight();
       int novaAltura = altura + 300;
       BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
    // copiar a imagem original pra nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(ImagemOriginal, 0, 0, null);

    // configurar a fonte
    var fonte = new Font("Comic Sans", Font.BOLD, 100);
    graphics.setFont(fonte);
    graphics.setColor(Color.ORANGE);
    

    // escrever uma frase na nova imagem
    // -------------------------------------------------------------------
    // tentar fazer um if else para mudar o texto da figurinha de acordo com o "rating"
    //if () {
    //   
    //} else {
    //    
    // }
    // -------------------------------------------------------------------
      String texto = "Legenda daora";
      // FontMetrics para centralizar o texto da figurinha
      FontMetrics fontMetrics = graphics.getFontMetrics(); 
      Rectangle2D retangulo = fontMetrics.getStringBounds(texto, graphics);
      int largutaTexto = (int) retangulo.getWidth();
      int posicaoTextoX = (largura - largutaTexto) / 2;
      int posicaoTextoY = novaAltura - 100;

      graphics.drawString(texto, posicaoTextoX, novaAltura -100 );  
      
      // Início do código para fazer um contorno no texto da figurinha
      FontRenderContext fontRenderContext = graphics.getFontRenderContext();
      TextLayout textLayout = new TextLayout(texto, fonte, fontRenderContext );

      Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoTextoX, posicaoTextoY);
        graphics.setTransform(transform);

        var outlineStroke = new BasicStroke(largura * 0.003f);
        graphics.setStroke(outlineStroke);

        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);
        // Fim do código para fazer um contorno no texto da figurinha

    // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}
    
