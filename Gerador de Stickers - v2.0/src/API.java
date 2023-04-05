public enum API {

    IMDB_TOP_MOVIES("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json", new ExtratorDeConteudoDoIMDB()),
    NASA("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-30&end_date=2023-04-02", new ExtratorDeConteudoDaNasa()),
    LOCALHOST("http://localhost:8080/Linguagens", new ExtratorDeConteudoAPI()); //// Teste da minha API com MongoDB e Spring

    private String url;
    private ExtratorDeConteudo extrator;



    API(String url, ExtratorDeConteudo extrator ){
        this.url = url;
        this.extrator = extrator;
    }

    public String getUrl(){
        return url;
    }

    public ExtratorDeConteudo getExtrator() {
        return extrator;
    }
}
