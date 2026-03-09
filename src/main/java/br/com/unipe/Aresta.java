package br.com.unipe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Aresta {
    private String nome;
    private Vertice v1;
    private Vertice v2;

    //Construtor para arestas sem nome
    public Aresta(Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public String toString() {
        String nomeAresta = nome != null ? nome : "";
        return nomeAresta + "{" + v1 + "," + v2 + "}";
    }
}
