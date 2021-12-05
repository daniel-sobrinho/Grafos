package Classes;

public class Dijkstra extends Vertice{
    private int predecessor;
    private int distancia;
    private boolean visitado;
    
    Dijkstra(){
        predecessor = -1;
        distancia = 99999;
        visitado = false;
    }

    public int getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(int predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}
