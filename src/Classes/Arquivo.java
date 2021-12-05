package Classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {

    public static String ReadFile(String path) {
        String conteudo = "";

        try {
            FileReader arquivo = new FileReader(path);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = "";

            try {
                linha = lerArquivo.readLine();
                while (linha != null) {
                    conteudo += linha + " ";
                    linha = lerArquivo.readLine();
                }
                arquivo.close();
                return conteudo;
            } catch (IOException exception) {
                System.out.println("Erro: Não foi possível ler o arquivo");
                return "";
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Erro: Arquivo não encontrado");
            return "";
        }
    }

//    public static ArrayList<Vertice> converterTexto(String texto) {
//        ArrayList<Vertice> vertices = new ArrayList<>();
//        ArrayList<Integer> valores = new ArrayList<>();
//
//        String[] stringValues = texto.split(" ");
//
//        for (String stringValue : stringValues) {
//            valores.add(Integer.parseInt(stringValue));
//        }
//
//        for (int i = 0; i < valores.get(0); i++) {
//            Vertice vertice = new Vertice();
//            vertice.setIdentificador(i + 1);
//            vertices.add(vertice);
//        }
//
//        int position = 2;
//        for (int i = 0; i < valores.get(1); i++) {
//            int origem = valores.get(position);
//            int destino = valores.get(position + 1);
//            int peso = valores.get(position + 2);
//            
//            Aresta aresta = new Aresta();
//
//            aresta.setVerticeOrigem(origem);
//            aresta.setVerticeDestino(destino);
//            aresta.setVerticePeso(peso);
//            
//            vertices.get(origem - 1).addAresta(aresta);
//            
//            position += 3;
//        }
//
//        return vertices;
//    }
    
    public static ArrayList<Dijkstra> converterTexto(String texto) {
        ArrayList<Dijkstra> vertices = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        
        String [] arrayDeValores = texto.split(" ");
        
        for(String valor : arrayDeValores){
            valores.add(Integer.parseInt(valor));
        }
        
        for (int i = 0; i < valores.get(0); i++) {
            Dijkstra vertice = new Dijkstra();
            vertice.setIdentificador(i);
            vertices.add(vertice);
        }
        
        int position = 2;
        for (int i = 0; i < valores.get(1); i++) {
            int origem = valores.get(position);
            int destino = valores.get(position + 1);
            int peso = valores.get(position + 2);
            
            Aresta aresta = new Aresta();

            aresta.setVerticeOrigem(origem);
            aresta.setVerticeDestino(destino);
            aresta.setPeso(peso);
            
            vertices.get(origem).addAresta(aresta);
            
            position += 3;
        }
        
        return vertices;
    }
}
