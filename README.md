## Projeto - Imersão Java Alura

Nesta 1º parte, do projeto que está em desenvolvimento, estamos conhecendo todo o ecossistema do JAVA e ao memso tempo aplicando os conhecimentos com API's e outras tecnologias.
A API utilizada nesta 1º parte do projeto fôra fornecida através do site do IMDB, que serve para mostrar e listar de diversas formas em geral, filmes e séries.
Já na 2º parte do projeto, criamos uma API linkada com o MongoDB para indexar algumas informaçãoes

## Partes do projeto

- <h4> 1º parte - Fazer com que o JAVA liste os Top filmes da url: https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json </h4>
- Progresso: 100% 


![image](https://user-images.githubusercontent.com/49702498/229950279-ff814102-6ae5-49a1-8611-bd7b2ad2382d.png)


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

- <h4> 2º parte - Criar stickers para o Whatsapp, utilizando-se das imagens dos Top filmes listados na url da 1º e da 2º parte. </h4>
- Progresso: 100%

![The Lord of the Rings- The Return of the King (2003)](https://user-images.githubusercontent.com/49702498/229015752-aff862b2-a1a8-404c-b581-b218f635a6fe.png)


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

- <h4> 3º parte - Organizar os códigos do projeto aplicando conhecimentos de Orientação a Objeto. </h4>
- Progresso: 100%
 
 **Abstração da 1º parte:**
 
 
 
 
![Abstração da 1º parte](https://user-images.githubusercontent.com/49702498/229947749-f80a91b0-51d5-45c4-a554-146504d6df82.png)


 **Abstração da 2º parte:**
 
 
 
 
![Abstração da 2º parte](https://user-images.githubusercontent.com/49702498/229948575-0b6c6192-3cab-4231-8e30-9bf119b0bdd0.png)
        

        

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

- <h4>  4º parte - Criando uma API em JAVA com os recursos do framework Spring e do MongoDB. </h4>
Nesta parte do projeto, o objetivo foi utilizar os conhecimentos de Java junto de outros frameworks e mostrar a possibilidade de coisas que podemos fazer quando utilizamos uma linguagem de programação junto de outras ferramentas. E ainda colocamos em prática o conceito básico de um CRUD.

Para tal função, utilizamos o MongoDB, que é um banco de dados do tipo NoSQL que guarda documentos em formato .JSON, e neste DB colocamos arquivos com informações sobre linguagens de programação, id, título, ranking e um link com a fonte da imagem da Linguagem de Programação. E para efetuar alguns testes utilizamos o Postman para fazer requisições HTTP e testar o CRUD.

- Progresso: 100%

**Código subindo com o Spring:**
![image](https://user-images.githubusercontent.com/49702498/229951720-a1746913-7893-472a-a4cb-fdf1d3fc0097.png)




**Usando o Postman para testar a API:**
![image](https://user-images.githubusercontent.com/49702498/229955287-2b42aceb-0a52-4030-b88e-1d3acaa7019e.png)




**API rodando em Localhost:**
![image](https://user-images.githubusercontent.com/49702498/229954459-2616af32-2aea-4359-9fb2-ce2c8fe1788f.png)



-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

- <h4> 5º parte - Juntando a API com o projeto "Gerador de Stickers" e tentar fazer Deploy na nuvem. </h4>
Quando colocamos o link da API rodando em Localhost no código do projeto "Gerador de Sticekrs", ele gerará stickers das linguagens de programção ques estão armazenadas
no MongoDB, apesar de conter outras informações como id e ranking, o código extrator pega apenas o campo do link da imagem para fazer a figurinha da linguagem de programação.
- Progersso: 90%

 <h4> :x: Problemas atuais :x: </h4>
Agora, em questão de dar Deploy em algum serviço de Cloud, é um tanto complicado devido a questões de precificação das plataformas, mesmo se for para um deploy de free trial. No entanto, mesmo utilizando a plataforma Fly.io para testes, uma imagem Docker fornecida por terceiros para testes, e feitas as devidas configurações, por algum motivo o domínio fornecido pelo Fly.io para acessar a API que rodava em Localhost não indexa o arquivo .JSON que contém as informações linguagens de programação.
Mesmo que o Fly.io tenha dado Deploy na imagem docker, ocorre algum erro de requisição HTTP ao acessar a API.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Container Docker**
![image](https://user-images.githubusercontent.com/49702498/229959160-745ce864-0456-495e-8471-67e53d310ae9.png)


**Ativando a imagem Docker pelo Powershell**
![image](https://user-images.githubusercontent.com/49702498/229965409-30c447bb-b32e-4df6-a099-8be070dd011e.png)




**Arquivos no MongoDB**


![image](https://user-images.githubusercontent.com/49702498/229966209-7dad412f-1e7b-4541-be6c-b480f324d97e.png)


## :heavy_check_mark: Técnicas e Tecnologias utilizadas no projeto
`Visual Studio Code` - `Paradigma de Orientação a Objeto` - `Java 20` - `Git` - `Spring` -  `MongoDB` - `Docker` - `Dockerhub` - `Fly.io` - `Windows Powershell` - `Postman` - `Maeven`



## :checkered_flag: Considerações finais
Após ter passado 1 semana trabalhando e aprendendo a desenvolver esse projeto junto da linguagem Java e todo seu ecossistema, há muitas coisas no projeto que tenho em mente para que possam ser aperfeiçoadas e implementadas futuramente para melhorar sua coerência e seu propósito junto de todas as suas funcionalidades.
- :construction: :warning: **Progresso total do projeto: 80%**


![Foto final do projeto](https://user-images.githubusercontent.com/49702498/229974311-b290df24-4447-47f5-9de5-ab93d243013a.jpg)



