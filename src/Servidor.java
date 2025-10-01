import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.nio.charset.*;
import java.net.InetSocketAddress;

public class Servidor {

    public static void main(String[] args) throws Exception {
        //Escuta em todas as interfaces de rede
        HttpServer servidor = HttpServer.create(new InetSocketAddress("0.0.0.0", 8080), 0);

        //rotas fixas
        servidor.createContext("/", troca->enviarResposta(troca, "Olá mundo"));
        servidor.createContext("/sobre", troca->enviarResposta(troca, "<h1> Sobre <h1>"));
        servidor.createContext("/contato", troca->enviarResposta(troca, "<h2> Contato <h2>"));
        servidor.createContext("/ajuda", troca->enviarResposta(troca, "<h2> Ajuda <h2>"));
        servidor.createContext("/servicos", troca->enviarResposta(troca, "<h2> Serviços <h2>"));
        servidor.createContext("/agradecimentos", troca->enviarResposta(troca, "<h2> Agradecimentos <h2>"));
        servidor.createContext("/index", troca ->{
            String html = """
                    <!DOCTYPE html>
                    <html lang="pt-br">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>ATIVIDADE</title>
                    
                        <style>
                            body{
                    
                    
                                background: linear-gradient(135deg, #3f5ff1,  #2fa33c);/* Fazer um gradiente*/
                                text-align: center;
                            }  \s
                    
                            h1{
                                color: white;
                                background-color: rgb(54, 55, 57);
                            }
                    
                            .botao{
                                display: inline-block;
                                margin: 15px;
                                padding: 20px;
                                background-color: rgb(19, 19, 187);
                                color: white;
                                text-decoration: none;  /* //Ele tira a linha debaixo da palavra de Link */
                                border-radius: 100px;
                                box-shadow: 0 4px 10px rgba(0, 0,0,0.3); /*Sombra*/
                                }
                    
                                .botao:hover{ /* Aplica elementos quando o ponteiro do mouse passa por cima*/
                                    background-color: red;
                                    box-shadow: 0 4px 10px rgba(0, 0,0,0.8);/*Sombra*/
                                }
                    
                                .mudar{
                                      display: inline-block;
                                      margin: 15px;
                                      padding: 20px;
                                      background-color: rgb(19, 19, 187);
                                      color: white;
                                      text-decoration: none;  /* //Ele tira a linha debaixo da palavra de Link */
                                      border-radius: 100px;
                                      box-shadow: 0 4px 10px rgb white; /*Sombra*/
                                      }
                                  
                    
                    
                        </style>
                    
                    </head>
                    <body>
                        <h1>Bem-Vindo ao Portal do Gustavo Nunes</h1>
                        <a href="/jogos" class="botao">Jogos</a>
                        <a href="/musicas" class="botao"> Músicas</a>
                        <a href="/filmes" class="botao">Filmes</a>
                    </body>
                    </html>
                    """;
                    enviarResposta(troca, html);
                });

        servidor.createContext("/jogos", troca ->{
            String html = """
                    <!DOCTYPE html>
                                                            <html lang="pt-br">
                                                            <head>
                                                                <meta charset="UTF-8">
                                                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                                                <title>ATIVIDADE</title>
                    
                                                                <style>
                                                                    body{
                    
                    
                                                                        background: linear-gradient(135deg, #3f5ff1,  #d71f1f);/* Fazer um gradiente*/
                                                                        text-align: center;
                                                                    }\s
                    
                                                                    h1{
                                                                        color: white;
                                                                    }
                    
                    
                                                                    p{
                                                                        color: white;
                                                                    }
                                                                    .mudar{
                                                                        display: inline-block;
                                                                        margin: 15px;
                                                                        padding: 20px;
                                                                        background-color: rgb(19, 19, 187);
                                                                        color: white;
                                                                         text-decoration: none;  /* //Ele tira a linha debaixo da palavra de Link */
                                                                        border-radius: 100px;
                                                                        box-shadow: 0 4px 10px rgb white; /*Sombra*/
                                                                        }
                    
                    
                                                                </style>
                    
                                                            </head>
                                                            <body>
                                                                <h1>Jogos Favoritos do Gustavo 🎮</h1>
                                                                <p>Minecraft</p>
                                                                <p>EA FC (FIFA)</p>
                                                                <p>eFootball (PES)</p>
                                                                <p>Fortnite</p>
                                                                <p>Clash Royale</p>
                                                                <p>Crash Bandicoot</p>
                                                                <p>Sonic</p>
                    
                                                            <a href="/musicas" class="mudar">Ir para Músicas 🎵</a> <br>
                                                            <a href="/filmes" class="mudar">Ir para Filmes 🎞️</a> <br>
                    
                                                            </body>
                                                            </html>
                    """;
            enviarResposta(troca, html);
        });
        servidor.createContext("/musicas", troca ->{
            String html = """
                    <!DOCTYPE html>
                                                            <html lang="pt-br">
                                                            <head>
                                                                <meta charset="UTF-8">
                                                                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                                                <title>ATIVIDADE</title>
                    
                                                                <style>
                                                                    body{
                    
                    
                                                                        background: linear-gradient(135deg, #dcf13f,  #2fa33c);/* Fazer um gradiente*/
                                                                        text-align: center;
                                                                    }
                    
                                                                    h1{
                                                                        color: black;
                    
                                                                    }
                    
                    
                                                                    p{
                                                                        color: white;
                                                                    }
                    
                                                                .mudar{
                                                                        display: inline-block;
                                                                        margin: 15px;
                                                                        padding: 20px;
                                                                        background-color: rgb(19, 19, 187);
                                                                        color: white;
                                                                         text-decoration: none;  /* //Ele tira a linha debaixo da palavra de Link */
                                                                        border-radius: 100px;
                                                                        box-shadow: 0 4px 10px rgb white; /*Sombra*/
                                                          }
                    
                    
                    
                                                                </style>
                    
                                                            </head>
                                                            <body>
                                                                <h1>Músicas Favoritas do Gustavo 🎵</h1>
                                                                <p>They Don't Care About Us - Michael Jackson</p>
                                                                <p>Happy - Pharrell Williams</p>
                                                                <p>Último Dia - Pregador Luo</p>
                                                                <p>UP! - Connor Price e Forrest Frank </p>
                                                                <p>Peita do Coringão - Memphis Depay e McHariel</p>
                                                                <p>Limitado - Nesk Only</p>
                                                                <p>What Are You Waiting - Nickelback For?</p>
                    
                                                            <a href="/jogos" class="mudar">Ir para Jogos 🎮</a> <br>
                                                            <a href="/filmes"class="mudar">Ir para Filmes 🎞️</a> <br>
                    
                                                            </body>
                                                            </html>
                    """;

            enviarResposta(troca, html);
        });
        servidor.createContext("/filmes", troca ->{
            String html = """
                   <!DOCTYPE html>
                                        <html lang="pt-br">
                                        <head>
                                            <meta charset="UTF-8">
                                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                            <title>ATIVIDADE</title>
                    
                                            <style>
                                                body{
                    
                    
                                                    background: linear-gradient(135deg, #ff0707,  #000000);/* Fazer um gradiente*/
                                                    text-align: center;
                                                } 
                    
                                                h1{
                                                    color: rgb(225, 227, 232);
                                                }
                    
                    
                                                p,strong{
                                                    color: white;
                                                }
                    
                                                .mudar{
                                                    display: inline-block;
                                                    margin: 15px;
                                                    padding: 20px;
                                                    background-color: rgb(19, 19, 187);
                                                    color: white;
                                                     text-decoration: none;  /* //Ele tira a linha debaixo da palavra de Link */
                                                    border-radius: 100px;
                                                    box-shadow: 0 4px 10px rgb white; /*Sombra*/
                                                    }
                    
                                            </style>
                    
                                        </head>
                                        <body>
                                            <h1>Filmes favoritos do Gustavo 🎞️</h1>
                                            <strong>A Forja - o poder da transformação</strong><br>
                                            <a href="https://www.youtube.com/watch?v=ohQ1IZmce5w" target =_blank_><img src="https://ingresso-a.akamaihd.net/prd/img/movie/a-forja-o-poder-da-transformacao/af623e40-b2c6-459e-ab40-db71808757ea.webp" alt="A Forja - o poder da transformaçã" width="220" height="400" title = "A Forja - o poder da transformação">  </a><br>

                                            <h2></h2>
                                             <strong>Homem-Aranha Sem volta para Casa</strong><br>
                                            <a href="https://www.youtube.com/watch?v=CyiiEJRZjSU" target =_blank_><img src="https://upload.wikimedia.org/wikipedia/pt/thumb/0/00/Spider-Man_No_Way_Home_poster.jpg/250px-Spider-Man_No_Way_Home_poster.jpg" alt="Homem-Aranha Sem volta para Casa" width="220" height="400" title = "Homem-Aranha Sem volta para Casa">  </a><br>

                                            <h2></h2>
                                            <strong>Vingadores Últimato</strong><br>
                                            <a href="https://www.youtube.com/watch?v=spJoZReeIeQ&t=3s" target =_blank_><img src="https://upload.wikimedia.org/wikipedia/pt/thumb/9/9b/Avengers_Endgame.jpg/250px-Avengers_Endgame.jpg" alt="Vingadores Últimato" width="220" height="400" title = "Vingadores Últimato">  </a><br>

                                            <h2></h2>
                                            <strong>Super Mario Bros o filme</strong><br>
                                            <a href="https://www.youtube.com/watch?v=Cb4WV4aXBpk" target =_blank_><img src="https://br.web.img2.acsta.net/pictures/23/04/03/19/45/2854005.jpg" alt="Super Mario Bros o filme" width="220" height="400" title = "Super Mario Bros o filme">  </a><br>

                                            <h2></h2>
                                            <strong>Um filme Minecraft</strong><br>
                                            <a href="https://www.youtube.com/watch?v=3IVPHxs4NoM&t=4s" target =_blank_><img src="https://m.media-amazon.com/images/M/MV5BYzFjMzNjOTktNDBlNy00YWZhLWExYTctZDcxNDA4OWVhOTJjXkEyXkFqcGc@._V1_.jpg" alt="Um filme Minecraft" width="220" height="400" title = "Um filme Minecraft">  </a><br>
                                           

                                            <h2></h2>
                                            <strong>Sonic 3 - o filme</strong><br>
                                            <a href="https://www.youtube.com/watch?v=-bcjtApoUyU" target =_blank_><img src="https://m.media-amazon.com/images/S/pv-target-images/d3d170cab1ef757a9a437cb9aa70bb33a8897f31f327f02c2de4d5a50dd32ff4.jpg" alt="Sonic 3 - o filme" width="220" height="400" title = "Sonic 3 - o filme">  </a><br>
                                           
                                            <h2></h2>
                                            <strong>Arranha-Céu: Coragem Sem Limite</strong><br>
                                            <a href="https://www.youtube.com/watch?v=DUP-La3JCDo" target =_blank_><img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcRpzGVj7TVqbOyQGaJhUwAFqEQtn0Mh_J1h88PJgXys7_oBp3pwPM9wMRPB1WquRg_yDJ6MfqLqNbkoTnwa_GxuPhg7bW02dq4b3dW0YJg" alt="Arranha-Céu: Coragem Sem Limite" width="220" height="400" title = "Arranha-Céu: Coragem Sem Limite">  </a><br>
                                           










                                         
                                            
                                         
                    
                                        <a href="/jogos" class="mudar">Ir para Jogos 🎮</a> <br>
                                        <a href="/musicas" class="mudar">Ir para Músicas 🎵</a> <br>
                    
                                        </body>
                                        </html>
                    """;

            enviarResposta(troca, html);
        });


        //rotas dinâmicas      //boasvinda?nome=GUSTAVO
        servidor.createContext("/boasvindas", troca -> {
            String consulta = troca.getRequestURI().getQuery();
            String nome = consulta.replace("nome=" , "");
            String resposta = "Seja bem-vindo " + nome;
            enviarResposta(troca, resposta);
                });



        //Iniciar o servidor
        servidor.start();

        //Manter o servidor ativo
        while (true){
            Thread.sleep(1000);
        }

    }
    public static void enviarResposta(com.sun.net.httpserver.HttpExchange  troca, String resposta ) throws  java.io.IOException{
        byte[] bytes;
        bytes = resposta.getBytes(StandardCharsets.UTF_8); //Permite caracteres especiais

        //Confirmação de que deu certo e o tamanho da mensagem
        troca.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        troca.sendResponseHeaders(200,bytes.length);


        //Envio para o cliente do resultado
        try(OutputStream os = troca.getResponseBody()){
            // Escreve a mensagem para o cliente
            os.write(bytes);

        }
    }

}
