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
                                                                                       
                                                                                                                                h1{
                                                                                                                                    color: black;
                    
                                                                                                                                }
                    
                    
                                                                                                                                a,p,strong{
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
                                                                                    <h1>Jogos Favoritos do Gustavo \uD83C\uDFAE</ h1>
                    
                    
                                                                                    <strong>Minecraft</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=jLuJbSjo7NA" target="_blank_"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBPpLlaKIzFxZcVyHTW-G_fOu-o8m55dbO_g&s" alt="Minecraft" width="150" height="150" title="Minecraft">  </a><br>
                                                                                    <p></p>
                    
                                                                                    <strong>EA FC (FIFA)</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=TSi0iJYSQ24" target="_blank_"><img src="https://gaming-cdn.com/images/products/19691/380x218/ea-sports-fc-26-pc-ea-app-cover.jpg?v=1758868329" alt="EA FC (FIFA)" width="150" height="150" title="EA FC (FIFA)">  </a><br>
                                                                                    <p></p>      \s
                    
                                                                                    <strong>eFootball (PES)</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=7LH1IvXl6_8" target="_blank_"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6A63kNFp6dOkiTEXeaQEEkEh_XWZUm812vA&s" alt="eFootball (PES)" width="150" height="150" title="eFootball (PES)">  </a><br>
                                                                                    <p></p>                                                                                                   \s
                    
                                                                                    <strong>Fortnite</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=ngg2sZClZMg" target="_blank_"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQROu5spctcQud1Gj4LVtR3Df-eQ7lpcnO8_Q&s" alt="Fortnite" width="150" height="150" title="Fortnite">  </a><br>
                                                                                    <p></p> \s
                    
                                                                                    <strong>Clash Royale</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=1RC1yxqTTd8" target="_blank_"><img src="https://play-lh.googleusercontent.com/gnSC6s8-6Tjc4uhvDW7nfrSJxpbhllzYhgX8y374N1LYvWBStn2YhozS9XXaz1T_Pi2q" alt="Clash Royale" width="150" height="150" title="Clash Royale">  </a><br>
                                                                                    <p></p>\s
                    
                                                                                    <strong>Crash Bandicoot</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=4fbO2-egZ3U target="_blank_"><img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRmTVhxSNg68XHfxeINFKVDgMx4IXnrLZ7VQStphrOD8vwdozA3_TH12iYVxgd03BcyLEsDEib_SrscNTe2E7BzqlxHHUgaK5QIltPlmA" alt="Crash Bandicoot" width="150" height="150" title="Crash Bandicoot">  </a><br>
                                                                                    <p></p>                                                                                                   \s
                    
                    
                                                                                    <strong>Sonic</strong><br>
                                                                                    <a href="https://www.youtube.com/watch?v=L1SzeWaJa94" target="_blank_"><img src="https://upload.wikimedia.org/wikipedia/pt/2/2f/Sonic_Generations_capa.png" alt="Sonic" width="150" height="150" title="Sonic">  </a><br>
                                                                                    <p></p>                                                                                                   \s
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                                                                                <a href="/musicas" class="mudar">Ir para Músicas</a> <br>
                                                                                <a href="/filmes" class="mudar">Ir para Filmes </a> <br>
                    
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
                    
                    
                                                                                        a,p,strong{
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
                    
                    
                                                                                                                                a,p,strong{
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
                                                                                                                            <strong>They Don't Care About Us - Michael Jackson</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=QNJL6nfu__Q" target="_blank_"><img src="https://upload.wikimedia.org/wikipedia/pt/3/3f/They_Don%27t_Care_About_Us.jpg " alt="They Don't Care About Us - Michael Jackson" width="150" height="150" title="They Don't Care About Us - Michael Jackson">  </a><br>
                    
                                                                                                                            <p></p>
                                                                                                                            <strong>Happy - Pharrell Williams</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=ZbZSe6N_BXs" target="_blank_"><img src="https://upload.wikimedia.org/wikipedia/pt/2/29/Capa_de_Happy_%28Pharrell_Williams%29.jpg " alt="Happy - Pharrell Williams" width="150" height="150" title="Happy - Pharrell Williams">  </a><br>
                                                                                                                            <p></p>
                                                                                                                            <strong>Último Dia - Pregador Luo</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=26P3vGqezks" target="_blank_"><img src="https://i1.sndcdn.com/artworks-imNJ6AR8tLm5-0-t500x500.jpg " alt="Último Dia - Pregador Luo" width="150" height="150" title="Último Dia - Pregador Luo">  </a><br>
                    
                                                                                                                            <p></p>
                                                                                                                            <strong>UP! - Connor Price e Forrest Frank</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=wCw-W-2Rs0k" target="_blank_"><img src="https://cdn-images.dzcdn.net/images/cover/24ca487d5c0b806c9a3d74690c4a2444/500x500.jpg " alt="UP! - Connor Price e Forrest Frank" width="150" height="150" title="UP! - Connor Price e Forrest Frank">  </a><br>
                                                                                                                            <p></p>
                                                                                                                            <strong>Peita do Coringão - Memphis Depay e McHariel</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=QThqQkWEQXQ" target="_blank_"><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTW6yXsNdevEhdkNVKIP9BLUNrjmKDRAIehMQ&s " alt="Peita do Coringão - Memphis Depay e McHariel" width="150" height="150" title="Peita do Coringão - Memphis Depay e McHariel">  </a><br>
                                                                                                                            <p></p>
                                                                                                                            <strong>Limitado - Nesk Only e 2metro</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=JnJmk5h1WWA" target="_blank_"><img src="https://i1.sndcdn.com/artworks-F6BheGXr2FzVeKgT-VWj3nA-t500x500.jpg" alt="Limitado - Nesk Only" width="150" height="150" title="Limitado - Nesk Only">  </a><br>
                                                                                                                            <p></p>
                                                                                                                            <strong>What Are You Waiting - Nickelback For?</strong><br>
                                                                                                                            <a href="https://www.youtube.com/watch?v=w-Ng5muAAcg" target="_blank_"><img src="https://upload.wikimedia.org/wikipedia/en/6/6b/What_Are_You_Waiting_For_single_cover.jpg" alt="What Are You Waiting - Nickelback For?" width="150" height="150" title="What Are You Waiting - Nickelback For?">  </a><br>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
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
                                            <a href="https://www.youtube.com/watch?v=ohQ1IZmce5w" target =_blank_><img src="https://ingresso-a.akamaihd.net/prd/img/movie/a-forja-o-poder-da-transformacao/af623e40-b2c6-459e-ab40-db71808757ea.webp" alt="A Forja - o poder da transformação" width="220" height="400" title = "A Forja - o poder da transformação">  </a><br>

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
