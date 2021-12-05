package Classes;

import java.util.ArrayList;

public class Vertice {

    private int identificador;
    private ArrayList<Aresta> aresta;

    public Vertice() {
        this.aresta = new ArrayList<>();
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public ArrayList<Aresta> getAresta() {
        return aresta;
    }

    public void addAresta(Aresta aresta) {
        this.aresta.add(aresta);
    }
}
