package br.com.unipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Vertice {

    private final String nome;
    private int grau;
    private int inDegree; // deve ser 0 para não-dirigido
    private int outDegree;// deve ser 0 para não-dirigido
    private List<Vertice> adjacencias;
    private List<Vertice> adjacentes;

    public void resetaGraus() {
        grau = inDegree = outDegree = 0;
    }

    public void aumentaGrau() { // não-dirigido
        grau++;
    }

    public void aumentaInDegree() {
        grau++;
        inDegree++;
    }

    public void aumentaOutDegree() {
        grau++;
        outDegree++;
    }

    public void adicionaAdjacencia(Vertice vertice) {
        adjacencias.add(vertice);
    }

    public void adicionaAdjacente(Vertice vertice) {
        adjacentes.add(vertice);
    }

    @Override
    public String toString() {
        return """
                %s: grau %d (%d in | %d out)
                """.formatted(nome, grau, inDegree, outDegree);
    }
}
