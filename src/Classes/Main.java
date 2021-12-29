package Classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("org.graphstream.ui", "swing");

        Graph grafo = new MultiGraph("Grafo");

        String arquivo = "..\\Grafos\\src\\Assets\\graph2.txt";

        String textoDoArquivo = Arquivo.ReadFile(arquivo);

        ArrayList<Dijkstra> vertices = new ArrayList<>();
        ArrayList<Dijkstra> dijkstra = new ArrayList<>();
        ArrayList<Dijkstra> visualizacao = new ArrayList<>();

        if (textoDoArquivo.isEmpty()) {
            System.out.println("Erro ao ler o arquivo");
        } else {
            vertices = Arquivo.converterTexto(textoDoArquivo);
            visualizacao = Arquivo.converterTexto(textoDoArquivo);

            final int ASCII = 64;

            final int tempo = 800;

            grafo.display();

            for (Dijkstra vertice : visualizacao) {
                String identificadorVertice = (Character.toString((char) (ASCII + vertice.getIdentificador())));
                grafo.addNode(identificadorVertice);
            }

            for (Dijkstra vertice : visualizacao) {
                for (Aresta aresta : vertice.getAresta()) {
                    String Origem = (Character.toString((char) (ASCII + aresta.getVerticeOrigem())));
                    String Destino = (Character.toString((char) (ASCII + aresta.getVerticeDestino())));

                    grafo.addEdge(Origem + Destino, Origem, Destino, true).setAttribute("length", aresta.getPeso());
                }
            }

            for (Dijkstra vertice : visualizacao) {
                String node = Character.toString((char) (ASCII + (vertice.getIdentificador())));
                String pai = "~";
                String distancia = "I";

                if ("A".equals(node)) {
                    distancia = "0";
                }

                String texto = node + " { P: " + pai + " | D: " + distancia + " }";

                grafo.getNode(node).setAttribute("label", texto);
            }
            grafo.edges().forEach(e -> e.setAttribute("label", "" + (int) e.getNumber("length")));
            grafo.setAttribute("ui.stylesheet", "url('file:..\\\\Grafos\\\\src\\\\Assets\\\\style')");

            int verticeInicial = 1;
            vertices.get(verticeInicial - 1).setDistancia(0);

            int menorCaminho = 99999;
            int verticeAtual = 0;

            ArrayList<Aresta> arestas = new ArrayList<>();

            Thread.sleep(1500
            );

            while (vertices.size() > 0) {
                for (Dijkstra vertice : vertices) {
                    if (!vertice.isVisitado()) {
                        String node = Character.toString((char) (ASCII + (vertice.getIdentificador())));
                        grafo.getNode(node).setAttribute("ui.class", "buscando");

                        Thread.sleep(tempo);

                        grafo.getNode(node).removeAttribute("ui.class");
                    }
                    if (vertice.getDistancia() < menorCaminho) {
                        verticeAtual = vertices.indexOf(vertice);
                        menorCaminho = vertice.getDistancia();
                    }
                }

                String node = Character.toString((char) (ASCII + (vertices.get(verticeAtual).getIdentificador())));
                grafo.getNode(node).setAttribute("ui.class", "encontrou");

                arestas = vertices.get(verticeAtual).getAresta();

                for (Aresta aresta : arestas) {
                    String origem = Character.toString((char) (ASCII + aresta.getVerticeOrigem()));
                    String destino = Character.toString((char) (ASCII + aresta.getVerticeDestino()));

                    Thread.sleep(tempo);

                    grafo.getEdge(origem + destino).setAttribute("ui.class", "buscando");

                    Thread.sleep(tempo);

                    grafo.getEdge(origem + destino).removeAttribute("ui.class");

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

                            String vertice = Character.toString((char) (ASCII + (vertices.get(buscar).getIdentificador())));
                            String p = Character.toString((char) (ASCII + (vertices.get(verticeAtual).getIdentificador())));
                            String d = Integer.toString(distancia);

                            String texto = vertice + " { P: " + p + " | D: " + d + " }";

                            grafo.getNode(vertice).setAttribute("ui.class", "relaxando");

                            grafo.getNode(vertice).setAttribute("label", texto);

                            Thread.sleep(tempo);

                            grafo.getNode(vertice).removeAttribute("ui.class");
                        }
                    }

                }

                dijkstra.add(vertices.get(verticeAtual));
                vertices.remove(verticeAtual);
                menorCaminho = 99999;

            }

            String matrizAdjacencia = "_ | ";

            int tamanho = dijkstra.size();

            int matriz[][] = new int[tamanho][tamanho];

            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    matriz[i][j] = 0;
                }
            }

            for (Dijkstra vertice : dijkstra) {
                for (Aresta aresta : vertice.getAresta()) {
                    matriz[aresta.getVerticeOrigem() - 1][aresta.getVerticeDestino() - 1] = 1;
                }
            }

            for (int i = 0; i < tamanho; i++) {
                matrizAdjacencia += Character.toString((char) (ASCII + (i + 1))) + " | ";
            }

            matrizAdjacencia += "\n";

            for (int i = 0; i < tamanho; i++) {
                matrizAdjacencia += Character.toString((char) (ASCII + (i + 1))) + " | ";
                for (int j = 0; j < tamanho; j++) {
                    matrizAdjacencia += Integer.toString(matriz[i][j]) + " | ";
                }
                matrizAdjacencia += "\n";
            }

            JOptionPane.showMessageDialog(null, matrizAdjacencia);

        }
    }
}
