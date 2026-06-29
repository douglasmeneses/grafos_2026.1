package br.com.unipe;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    public ResultadoCaminho rotaMaiorAfinidade(String origem, String destino){
        if (origem == null || destino == null) {
            return new ResultadoCaminho();
        }

        if (origem.isBlank() || destino.isBlank()) {
            return new ResultadoCaminho();
        }

        return rede.dijkstra(origem, destino);
    }

    public void exibirRotaMaiorAfinidade(String origem, String destino) {
        ResultadoCaminho resultado = rotaMaiorAfinidade(origem, destino);

        System.out.println("\n===== ROTA DE MAIOR AFINIDADE =====");

        if (!resultado.existeCaminho()) {
            System.out.println("Não existe caminho entre "+ origem + " e " + destino);

            return;
        }

        System.out.println("Origem: " + origem);
        System.out.println("Destino: " + destino);

        imprimirCaminho(resultado);

        System.out.println("Custo total: " + resultado.getCustoTotal());
    }

    private void imprimirCaminho(ResultadoCaminho resultado) {
        System.out.println("\n Melhor caminho:");

        System.out.println(
            String.join(" -> ", resultado.getCaminho())
        );
    }
}