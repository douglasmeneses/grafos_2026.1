package br.com.unipe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo.addVertice("A");
        grafo.addVertice("B");
        grafo.addAresta("A", "B");
        System.out.println(grafo);
    }
}