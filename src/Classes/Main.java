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
        
        String arquivo = "C:\\Users\\danie\\Documents\\NetBeansProjects\\Grafos\\src\\arquivos-grafo\\graph.txt";
        
        String textoDoArquivo = Arquivo.ReadFile(arquivo);
        
        ArrayList<Vertice> vertices = new ArrayList<>();
        ArrayList<Aresta> arestas = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        
        if(textoDoArquivo.isEmpty()){
            System.out.println("Erro ao ler o arquivo");
        }else{
           vertices = Arquivo.converterTexto(textoDoArquivo);
           
           for(Vertice vertice : vertices){
               System.out.println("Vertice: " + vertice.getIdentificador());
               for (Aresta aresta : vertice.getAresta()) {
                   System.out.println("Origem: " + aresta.getVerticeOrigem() + " Destino: " + aresta.getVerticeDestino() + " Peso: " + aresta.getVerticePeso());
               }
               System.out.println("-------------------");
           }          
        }
    }
}
    
