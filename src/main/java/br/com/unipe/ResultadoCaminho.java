import java.util.List;
import java.util.ArrayList;

/**
 * Encapsula o resultado de uma busca de caminho ponderado (Dijkstra).
 * Guarda tanto a sequência de vértices do caminho quanto o custo total acumulado.
 */
public class ResultadoCaminho {
    private List<String> caminho;
    private int custoTotal;

    /**
     * Construtor para um caminho encontrado.
     *
     * @param caminho    Lista ordenada de nomes que formam o caminho.
     * @param custoTotal Soma dos pesos das arestas percorridas.
     */
    public ResultadoCaminho(List<String> caminho, int custoTotal) {
        this.caminho = caminho;
        this.custoTotal = custoTotal;
    }

    /**
     * Construtor para quando não existe caminho (perfis inalcançáveis).
     * Define custo -1 e caminho vazio conforme especificado no projeto.
     */
    public ResultadoCaminho() {
        this.caminho = new ArrayList<>();
        this.custoTotal = -1;
    }

    public List<String> getCaminho() {
        return caminho;
    }

    public int getCustoTotal() {
        return custoTotal;
    }

    public boolean existeCaminho() {
        return custoTotal != -1;
    }

    @Override
    public String toString() {
        if (!existeCaminho()) {
            return "Sem caminho disponível (perfis inalcançáveis).";
        }
        return "Caminho: " + String.join(" -> ", caminho) + " | Custo total: " + custoTotal;
    }
}