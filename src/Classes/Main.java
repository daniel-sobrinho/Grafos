package Classes;

import java.util.ArrayList;
import java.util.List;



public class Main {
    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//      Caminho do arquivo com os dados do Grafo
        String arquivo = "C:\\Users\\danie\\Documents\\NetBeansProjects\\Grafos\\src\\arquivos-grafo\\graph.txt";
        
        String valores = Arquivo.ReadFile(arquivo);
        
        if(valores.isEmpty()){
            System.out.println("Erro ao ler o arquivo");
        }else{
            System.out.println(valores);
        }
























        
//      Arrays de Vértices e Arestas
//        List<Aresta> arestas = new ArrayList<>();
//        List<Vertice> vertices = new ArrayList<>();
        

//        try{
//            
//            
//            for(int i=0; i<stringArray.length; i++){
//                if(i == 0){
//                    String valorArray = stringArray[0];
//                    int ASCII = 65;
//                    int verticesQtd = Integer.parseInt(valorArray);
//                    
//                    for(int verticeCount = 0; verticeCount < verticesQtd; verticeCount++){
//                        Vertice vertice = new Vertice();
//                        vertice.setIdentificador(Character.toString((char)ASCII));
//                        System.out.println(vertice.getIdentificador());
//                        vertices.add(vertice);
//                        ASCII++;
//                    }
//                }
//            }
//        }catch(Exception error){
//            System.out.println(error);
//        }
    }        
}
    
