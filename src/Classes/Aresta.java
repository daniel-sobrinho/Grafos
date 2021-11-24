package Classes;

public class Aresta {

    private Vertice verticeOrigem;
    private Vertice verticeDestino;
    private int verticePeso;

    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(Vertice verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(Vertice verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public int getVerticePeso() {
        return verticePeso;
    }

    public void setVerticePeso(int verticePeso) {
        this.verticePeso = verticePeso;
    }
}
