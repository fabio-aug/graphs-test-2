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
            aux += (index+1)+ " ";
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
        IndependentSet graph = new IndependentSet(16);
        graph.addEdge(0, 1);
        graph.addEdge(0, 6);
        graph.addEdge(0, 10);
        graph.addEdge(0, 8);
        graph.addEdge(0, 4);
        graph.addEdge(1, 11);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(1, 9);
        graph.addEdge(2, 5);
        graph.addEdge(2, 12);
        graph.addEdge(2, 8);
        graph.addEdge(2, 3);
        graph.addEdge(3, 13);
        graph.addEdge(3, 9);
        graph.addEdge(3, 4);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(4, 14);
        graph.addEdge(4, 5);
        graph.addEdge(5, 10);
        graph.addEdge(5, 11);
        graph.addEdge(5, 15);
        graph.addEdge(6, 11);
        graph.addEdge(6, 15);
        graph.addEdge(6, 12);
        graph.addEdge(7, 12);
        graph.addEdge(7, 15);
        graph.addEdge(7, 13);
        graph.addEdge(8, 13);
        graph.addEdge(8, 15);
        graph.addEdge(8, 14);
        graph.addEdge(9, 10);
        graph.addEdge(9, 15);
        graph.addEdge(9, 14);
        graph.addEdge(10, 12);
        graph.addEdge(10, 13);
        graph.addEdge(11, 14);
        graph.addEdge(11, 13);
        graph.addEdge(12, 14);
        graph.getIndependentSet();
    }

}
