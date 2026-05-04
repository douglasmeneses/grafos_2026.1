package br.com.unipe;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(); //não dirigido
        grafo.adicionaVertices("1", "2", "3", "4", "5", "6");
        grafo.addAresta("a1", "1", "3");
        grafo.addAresta("a2", "1", "4");
        ;
        grafo.addAresta("a3", "2", "5");
        grafo.addAresta("a4", "3", "5");
        grafo.addAresta("a5", "4", "4");

        System.out.println(grafo);
        grafo.exibeMatrizAdjacencia();
        grafo.exibeMatrizIncidencia();
    }
}