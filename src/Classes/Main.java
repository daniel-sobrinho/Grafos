package Classes;

import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {

    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        Graph grafo = new MultiGraph("Grafo");

        String arquivo = "..\\Grafos\\src\\Assets\\graph.txt";

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
                        menorCaminho = vertice.getDistancia();
                    }
                }

                arestas = vertices.get(verticeAtual).getAresta();

                for (Aresta aresta : arestas) {
                    int distancia = vertices.get(verticeAtual).getDistancia() + aresta.getPeso();
                    int buscar = aresta.getVerticeDestino();
                    for (Dijkstra vertice : vertices) {
                        int verticeID = vertice.getIdentificador();
                        if (verticeID == buscar) {
                            buscar = vertices.indexOf(vertice);
                        }
                    }

                    if (buscar < vertices.size()) {
                        if (vertices.get(buscar).getDistancia() > distancia) {
                            vertices.get(buscar).setDistancia(distancia);
                            vertices.get(buscar).setPredecessor(vertices.get(verticeAtual).getIdentificador());
                        }
                    }

                }

                dijkstra.add(vertices.get(verticeAtual));
                vertices.remove(verticeAtual);
                menorCaminho = 99999;

            }

            final int ASCII = 64;

            for (Dijkstra vertice : dijkstra) {
                String identificadorVertice = (Character.toString((char)(ASCII + vertice.getIdentificador())));
                grafo.addNode(identificadorVertice);
            }

            for (Dijkstra vertice : dijkstra) {
                for (Aresta aresta : vertice.getAresta()) {
                    String Origem = (Character.toString((char)(ASCII + aresta.getVerticeOrigem())));
                    String Destino = (Character.toString((char)(ASCII + aresta.getVerticeDestino())));

                    grafo.addEdge(Origem + Destino, Origem, Destino, true).setAttribute("length", aresta.getPeso());
                }
            }
                grafo.nodes().forEach(n -> n.setAttribute("label", n.getId()));
		grafo.edges().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("length")));
                grafo.setAttribute("ui.stylesheet", "url('file:..\\\\Grafos\\\\src\\\\Assets\\\\style')");
                grafo.display();
        }
    }
}
