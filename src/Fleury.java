import java.util.ArrayList;

public class Fleury {
    private int numberOfVertices;
    private ArrayList<Integer>[] edges;

    @SuppressWarnings("unchecked")
    Fleury(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.edges = new ArrayList[this.numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    private void addEdge(Integer a, Integer b) {
        edges[a].add(b);
        edges[b].add(a);
    }

    private void eulerTheorem() {
        boolean isEuler = true;
        for (int i = 0; i < numberOfVertices; i++) {
            isEuler = isEuler && this.edges[i].size() % 2 == 0;
            if (!isEuler)
                break;
        }

        System.out.println("Teorema de Euler: " + isEuler);
        if (isEuler) {
            System.out.println("Caminho feito: ");
            walk(0);
        }
    }

    private void walk(Integer a) {
        for (int i = 0; i < this.edges[a].size(); i++) {
            Integer b = this.edges[a].get(i);
            if (isValidPath(a, b)) {
                removeEdge(a, b);
                System.out.println(" " + ((a < 10) ? " " + (a + 1) : (a + 1)) + " - " + (b + 1));
                walk(b);
            }
        }
    }

    private boolean isValidPath(Integer a, Integer b) {
        // Ele é o único vizinho
        if (this.edges[a].size() == 1) {
            return true;
        }

        // Se possuir mais de 1 vizinho então validar se é uma ponte.
        boolean[] verticeVisited = new boolean[this.numberOfVertices];

        // Contabilizar o número de acessos (aos vestices) a partir do vértice A
        // contando com a aresta A-B.
        int accessWithEdge = deepCounter(a, verticeVisited);

        // Remover a aresta A-B e contabilizar o número de acessos (aos vestices) a
        // partir do vértice A.
        removeEdge(a, b);
        verticeVisited = new boolean[this.numberOfVertices];
        int accessesWithoutEdges = deepCounter(a, verticeVisited);

        // Adicionar novamente a resta A-B ao grafo para evitar possíveis problemas de
        // caminhos.
        addEdge(a, b);

        // Caso o número de acesso aos vértices com a aresta A-B
        // seja maior então não é um bom caminho, pois o acesso aos vértices será
        // limitado.
        return (accessWithEdge > accessesWithoutEdges) ? false : true;
    }

    private int deepCounter(Integer a, boolean[] verticeVisited) {
        verticeVisited[a] = true;
        int count = 1;

        for (int connection : this.edges[a]) {
            if (!verticeVisited[connection]) {
                count = count + deepCounter(connection, verticeVisited);
            }
        }

        return count;
    }

    private void removeEdge(Integer a, Integer b) {
        edges[a].remove(b);
        edges[b].remove(a);
    }

    public static void main(String args[]) {
        Fleury graph = new Fleury(12);

        graph.addEdge(0, 5);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(1, 8);
        graph.addEdge(1, 9);
        graph.addEdge(1, 10);
        graph.addEdge(1, 11);
        graph.addEdge(2, 4);
        graph.addEdge(2, 7);
        graph.addEdge(2, 8);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(3, 10);
        graph.addEdge(4, 5);
        graph.addEdge(6, 11);
        graph.addEdge(8, 9);

        graph.eulerTheorem();
    }
}
