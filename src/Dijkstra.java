import java.util.*;

class Dijkstra {
    private int numberOfVertices;
    private ArrayList<int[]>[] edges;

    @SuppressWarnings("unchecked")
    Dijkstra(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.edges = new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i)
            this.edges[i] = new ArrayList<>();
    }

    class EgdeWeight implements Comparable<EgdeWeight> {
        private int vertice;
        private int weight;

        EgdeWeight(int vertice, int weight) {
            this.vertice = vertice;
            this.weight = weight;
        }

        public int compareTo(EgdeWeight other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public void addEdge(int a, int b, int weight) {
        this.edges[a].add(new int[] { b, weight });
        this.edges[b].add(new int[] { a, weight });
    }

    public void shortestPath(int from, int to) {
        PriorityQueue<EgdeWeight> listEdges = new PriorityQueue<>();

        int[][] distance = new int[numberOfVertices][2];

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        listEdges.add(new EgdeWeight(from, 0));
        distance[from][0] = 0;
        distance[from][1] = 0;

        while (!listEdges.isEmpty()) {
            int a = listEdges.poll().vertice;

            for (int[] neighbor : this.edges[a]) {
                int b = neighbor[0];
                int weight = neighbor[1];

                if (distance[b][0] > distance[a][0] + weight) {
                    distance[b][0] = distance[a][0] + weight;
                    distance[b][1] = a;
                    listEdges.add(new EgdeWeight(b, distance[b][0]));
                }
            }
        }

        showInfo(distance, to);
    }

    public void showInfo(int[][] distance, int to) {
        String print = "";
        print = "\n" + to + " - " + Arrays.toString(distance[to]) + print;

        int index = distance[to][1];

        while (index != 0 && distance[index][0] != 0) {
            print = "\n" + index + " - " + Arrays.toString(distance[index]) + print;
            index = distance[index][1];
        }

        print = index + " - " + Arrays.toString(distance[index]) + print;
        System.out.println(print);
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(4);

        dijkstra.addEdge(0, 1, 5);
        dijkstra.addEdge(0, 2, 8);
        dijkstra.addEdge(1, 2, 9);
        dijkstra.addEdge(1, 3, 2);
        dijkstra.addEdge(3, 2, 6);

        dijkstra.shortestPath(0, 3);
    }
}
