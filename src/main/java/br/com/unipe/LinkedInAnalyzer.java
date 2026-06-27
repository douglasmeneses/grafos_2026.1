package br.com.unipe;

import java.util.*;

public class LinkedInAnalyzer {

    private final Grafo rede;

    public LinkedInAnalyzer(Grafo rede) {
        this.rede = rede;
    }

    public int grauSeparacao(String origem, String destino) {
        Queue<String> fila = new LinkedList<>();
        Map<String, Integer> visitados = new HashMap<>();

        fila.add(origem);
        visitados.put(origem, 0);

        while (!fila.isEmpty()) {
            String atual = fila.poll();
            int passos = visitados.get(atual);

            if (atual.equals(destino)) {
                return passos;
            }

            Vertice verticeAtual = rede.encontraVertice(atual).orElse(null);
            if (verticeAtual == null) continue;

            for (Vertice vizinho : verticeAtual.getAdjacencias()) {
                if (!visitados.containsKey(vizinho.getNome())) {
                    visitados.put(vizinho.getNome(), passos + 1);
                    fila.add(vizinho.getNome());
                }
            }
        }

        return -1; //sem conexão
    }
}