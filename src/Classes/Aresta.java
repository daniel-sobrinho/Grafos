package Classes;

public class Aresta {

    private int verticeOrigem;
    private int verticeDestino;
    private int peso;
    
    Aresta(){
        peso = 0;
    }

    public int getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(int verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(int verticeDestino) {
        this.verticeDestino = verticeDestino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int Peso) {
        this.peso = Peso;
    }

    
}
