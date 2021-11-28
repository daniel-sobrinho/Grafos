package Classes;

import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Main {
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");
		
	Graph grafo = new SingleGraph("Grafo");
        
//      Caminho do arquivo com os dados do Grafo
        String arquivo = "C:\\Users\\danie\\Documents\\NetBeansProjects\\Grafos\\src\\arquivos-grafo\\graph.txt";
        
        String textoDoArquivo = Arquivo.ReadFile(arquivo);
        
        ArrayList<Vertice> vertices = new ArrayList<>();
        ArrayList<Aresta> arestas = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        
        if(textoDoArquivo.isEmpty()){
            System.out.println("Erro ao ler o arquivo");
        }else{
            textoDoArquivo = Arquivo.removeEspacos(textoDoArquivo);
            
            for(int i=0; i<textoDoArquivo.length();i++){
                char charTemp = textoDoArquivo.charAt(i);
                String charAsString = Character.toString(charTemp);
                valores.add(Integer.parseInt(charAsString));
            }
            
            if(valores.get(0) > 0){
                int ASCII = 64;
                
                for(int i=0; i<valores.get(0); i++){
                    Vertice vertice = new Vertice();
                    vertice.setIdentificador((char)(ASCII + (i+1)));
                    vertices.add(vertice);
                }
                
                if(valores.get(1) > 0){
                    int position = 2;
                    for(int i=0; i<valores.get(1); i++){
                        Aresta aresta = new Aresta();
                        aresta.setVerticeOrigem((char)(ASCII + valores.get(position)));
                        aresta.setVerticeDestino((char)(ASCII + valores.get(position+1)));
                        aresta.setVerticePeso(valores.get(position+2));
                        arestas.add(aresta);
                        position+=3;
                    }
                }
                
                for(Vertice vertice : vertices){
                    grafo.addNode(Character.toString(vertice.getIdentificador()));
                }
                
                for(Aresta aresta : arestas){
                    String origem = Character.toString(aresta.getVerticeOrigem());
                    String destino = Character.toString(aresta.getVerticeDestino());
                    String nomeAresta = origem + destino;
                    int peso = aresta.getVerticePeso();
                    grafo.addEdge(nomeAresta , origem, destino);
                }
                
            }
        }
        
        grafo.display();
    }        
}
    
