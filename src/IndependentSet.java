import java.util.ArrayList;

public class IndependentSet {

    private int numberOfVertices;
    private ArrayList<Integer>[] edges;

    IndependentSet(int numberOfVertices) {
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

    private void getIndependentSet() {
        int loop = this.numberOfVertices;
        String aux = "";
        while (loop > 0) {
            int value = -1;
            int index = -1;
            boolean isFirst = true;
            for (int i = 0; i < edges.length; i++) {
                if (edges[i] != null) {
                    if (isFirst) {
                        isFirst = false;
                        index = i;
                        value = this.edges[i].size();
                    } else {
                        if (this.edges[i].size() < value) {
                            value = this.edges[i].size();
                            index = i;
                        }
                    }
                }
            }
            aux += index + " ";
            for (int i = 0; i < this.edges[index].size(); i++) {
                int idx = this.edges[index].get(i);
                if (this.edges[idx] != null) {
                    this.edges[idx] = null;
                    loop--;
                }
            }
            this.edges[index] = null;
            loop--;
        }
        System.out.println(aux);
    }

    public static void main(String args[]) {
        IndependentSet graph = new IndependentSet(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(2, 6);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);
        graph.addEdge(5, 2);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(6, 5);
        graph.getIndependentSet();
    }

}
