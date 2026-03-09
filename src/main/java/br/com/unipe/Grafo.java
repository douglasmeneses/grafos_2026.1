package br.com.unipe;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private final List<Aresta> arestas;
    private final List<Vertice> vertices;

    public Grafo(){
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void addVertice(String nomeVertice){
        Vertice v = new Vertice(nomeVertice);
        vertices.add(v);
    }

    public void addAresta(String nomeVertice1, String nomeVertice2){
        //TODO: trecho de código duplicado, poderia ser refatorado para evitar repetição
        Vertice v1 = encontraVertice(nomeVertice1);
        if (v1 == null) {
            System.out.println("Vertice " + nomeVertice1 + " não encontrado.");
            return;
        }
        Vertice v2 = encontraVertice(nomeVertice2);
        if (v2 == null) {
            System.out.println("Vertice " + nomeVertice2 + " não encontrado.");
            return;
        }

        Aresta aresta = new Aresta( v1, v2);
        arestas.add(aresta);
    }

    public void addAresta(String nomeAresta, String nomeVertice1, String nomeVertice2){
        Vertice v1 = encontraVertice(nomeVertice1);
        if (v1 == null) {
            System.out.println("Vertice " + nomeVertice1 + " não encontrado.");
            return;
        }
        Vertice v2 = encontraVertice(nomeVertice2);
        if (v2 == null) {
            System.out.println("Vertice " + nomeVertice2 + " não encontrado.");
            return;
        }

        Aresta aresta = new Aresta(nomeAresta, v1, v2);
        arestas.add(aresta);
    }

    public Vertice encontraVertice(String nome){
        for (Vertice vertice : vertices) {
            if (vertice.getNome().equalsIgnoreCase(nome)) {
                return vertice;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "Grafo{\n" +
                "   arestas=" + arestas +
                ",\n   vertices=" + vertices +
                "\n}";
    }
}
