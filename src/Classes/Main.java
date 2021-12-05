package Classes;

import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph grafo = new MultiGraph("Grafo");

        String arquivo = "C:\\Users\\danie\\Documents\\NetBeansProjects\\Grafos\\src\\Assets\\graph.txt";

        String textoDoArquivo = Arquivo.ReadFile(arquivo);

        ArrayList<Dijkstra> vertices = new ArrayList<>();
        ArrayList<Dijkstra> dijkstra = new ArrayList<>();

        if (textoDoArquivo.isEmpty()) {
            System.out.println("Erro ao ler o arquivo");
        } else {
            vertices = Arquivo.converterTexto(textoDoArquivo);

            int verticeInicial = 1;
            vertices.get(verticeInicial - 1).setDistancia(0);

            int menorCaminho = 99999;
            int verticeAtual = 0;

            ArrayList<Aresta> arestas = new ArrayList<>();

            while (vertices.size() > 0) {
                for (Dijkstra vertice : vertices) {
                    if (vertice.getDistancia() < menorCaminho) {
                        verticeAtual = vertices.indexOf(vertice);
                    }
                }

                arestas = vertices.get(verticeAtual).getAresta();

                for (Aresta aresta : arestas) {
                    int distancia = vertices.get(verticeAtual).getDistancia() + aresta.getPeso();
                    int buscar = aresta.getVerticeDestino();
                    for (Dijkstra vertice : vertices) {
                        int verticeID = vertice.getIdentificador();
                        if(verticeID == buscar){
                            buscar = vertices.indexOf(vertice);
                        }
                    }
                    
                    if(buscar < vertices.size()){
                        if(vertices.get(buscar).getDistancia() > distancia){
                            vertices.get(buscar).setDistancia(distancia);
                            vertices.get(buscar).setPredecessor(vertices.get(buscar).getIdentificador());
                        }
                    }
                    
                    
                }

                dijkstra.add(vertices.get(verticeAtual));
                vertices.remove(verticeAtual);

            }

            System.out.println("-------------------------------------------");
            for (Dijkstra vertice : dijkstra) {
                System.out.println("Vertice: " + vertice.getIdentificador() + " | Predecessor: " + vertice.getPredecessor() + " Distancia: " + vertice.getDistancia());
            }

//            for (Dijkstra vertice : vertices) {
//                System.out.println("ID: " + vertice.getIdentificador());
//                for (Aresta aresta : vertice.getAresta()) {
//                    System.out.println("Origem: " + aresta.getVerticeOrigem() + " Destino: " + aresta.getVerticeDestino() + " Peso: " + aresta.getPeso());
//                }
//                System.out.println("-------------------------------------------");
//            }

        }
    }
}
