import java.util.*;

class Dijkstra {
    private int numberOfVertices;
    private ArrayList<int[]>[] edges;

    @SuppressWarnings("unchecked")
    Dijkstra(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.edges = new ArrayList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++)
            this.edges[i] = new ArrayList<>();
    }

    class EdgeWeight implements Comparable<EdgeWeight> {
        private int vertice;
        private int weight;

        EdgeWeight(int vertice, int weight) {
            this.vertice = vertice;
            this.weight = weight;
        }

        public int compareTo(EdgeWeight other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public void addEdge(int a, int b) {
        this.edges[a].add(new int[] { b, 1 });
        this.edges[b].add(new int[] { a, 1 });
    }

    public void shortestPath(int from, int to) {
        PriorityQueue<EdgeWeight> listEdges = new PriorityQueue<>();

        int[][] distance = new int[numberOfVertices][2];

        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        listEdges.add(new EdgeWeight(from, 0));
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
                    listEdges.add(new EdgeWeight(b, distance[b][0]));
                }
            }
        }

        showInfo(distance, to);
    }

    public String concatInfo(int[][] distance, int index) {
        String vertice = "Vértice: " + index;
        String cost = "Custo: " + distance[index][0];
        String previous = "Anterior: " + ((distance[index][1] == 0) ? "--" : distance[index][1]);
        return vertice + " | " + "[" + cost + ", " + previous + "]";
    }

    public void showInfo(int[][] distance, int to) {
        String print = "\n" + concatInfo(distance, to);

        int index = distance[to][1];

        while (index != 0 && distance[index][0] != 0) {
            print = "\n" + concatInfo(distance, index) + print;
            index = distance[index][1];
        }

        print = concatInfo(distance, index) + print;
        System.out.println(print);
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(76);

        dijkstra.addEdge(0, 1);
        dijkstra.addEdge(0, 9);
        dijkstra.addEdge(1, 2);
        dijkstra.addEdge(1, 10);
        dijkstra.addEdge(2, 3);
        dijkstra.addEdge(2, 11);
        dijkstra.addEdge(3, 4);
        dijkstra.addEdge(3, 12);
        dijkstra.addEdge(4, 5);
        dijkstra.addEdge(4, 13);
        dijkstra.addEdge(5, 6);
        dijkstra.addEdge(5, 14);
        dijkstra.addEdge(6, 7);
        dijkstra.addEdge(6, 15);
        dijkstra.addEdge(7, 8);
        dijkstra.addEdge(7, 16);
        dijkstra.addEdge(8, 17);
        dijkstra.addEdge(9, 10);
        dijkstra.addEdge(9, 18);
        dijkstra.addEdge(10, 11);
        dijkstra.addEdge(10, 19);
        dijkstra.addEdge(11, 12);
        dijkstra.addEdge(11, 20);
        dijkstra.addEdge(12, 13);
        dijkstra.addEdge(12, 21);
        dijkstra.addEdge(13, 14);
        dijkstra.addEdge(13, 22);
        dijkstra.addEdge(14, 15);
        dijkstra.addEdge(14, 23);
        dijkstra.addEdge(15, 16);
        dijkstra.addEdge(16, 17);
        dijkstra.addEdge(16, 24);
        dijkstra.addEdge(17, 25);
        dijkstra.addEdge(18, 19);
        dijkstra.addEdge(18, 26);
        dijkstra.addEdge(19, 20);
        dijkstra.addEdge(19, 27);
        dijkstra.addEdge(20, 21);
        dijkstra.addEdge(20, 28);
        dijkstra.addEdge(21, 22);
        dijkstra.addEdge(22, 23);
        dijkstra.addEdge(22, 29);
        dijkstra.addEdge(23, 30);
        dijkstra.addEdge(24, 25);
        dijkstra.addEdge(24, 31);
        dijkstra.addEdge(25, 32);
        dijkstra.addEdge(26, 27);
        dijkstra.addEdge(26, 33);
        dijkstra.addEdge(27, 28);
        dijkstra.addEdge(27, 34);
        dijkstra.addEdge(28, 35);
        dijkstra.addEdge(29, 30);
        dijkstra.addEdge(29, 36);
        dijkstra.addEdge(31, 32);
        dijkstra.addEdge(31, 38);
        dijkstra.addEdge(32, 39);
        dijkstra.addEdge(33, 34);
        dijkstra.addEdge(33, 40);
        dijkstra.addEdge(34, 35);
        dijkstra.addEdge(34, 41);
        dijkstra.addEdge(35, 42);
        dijkstra.addEdge(36, 44);
        dijkstra.addEdge(37, 38);
        dijkstra.addEdge(37, 46);
        dijkstra.addEdge(38, 39);
        dijkstra.addEdge(38, 47);
        dijkstra.addEdge(39, 48);
        dijkstra.addEdge(40, 41);
        dijkstra.addEdge(40, 49);
        dijkstra.addEdge(41, 42);
        dijkstra.addEdge(41, 50);
        dijkstra.addEdge(42, 43);
        dijkstra.addEdge(42, 51);
        dijkstra.addEdge(43, 44);
        dijkstra.addEdge(43, 52);
        dijkstra.addEdge(44, 45);
        dijkstra.addEdge(44, 53);
        dijkstra.addEdge(45, 46);
        dijkstra.addEdge(45, 54);
        dijkstra.addEdge(46, 47);
        dijkstra.addEdge(46, 55);
        dijkstra.addEdge(47, 48);
        dijkstra.addEdge(47, 56);
        dijkstra.addEdge(48, 57);
        dijkstra.addEdge(49, 50);
        dijkstra.addEdge(49, 58);
        dijkstra.addEdge(50, 51);
        dijkstra.addEdge(50, 59);
        dijkstra.addEdge(51, 52);
        dijkstra.addEdge(51, 60);
        dijkstra.addEdge(52, 53);
        dijkstra.addEdge(52, 61);
        dijkstra.addEdge(53, 54);
        dijkstra.addEdge(53, 62);
        dijkstra.addEdge(54, 55);
        dijkstra.addEdge(54, 63);
        dijkstra.addEdge(55, 56);
        dijkstra.addEdge(55, 64);
        dijkstra.addEdge(56, 57);
        dijkstra.addEdge(56, 65);
        dijkstra.addEdge(57, 66);
        dijkstra.addEdge(58, 59);
        dijkstra.addEdge(58, 67);
        dijkstra.addEdge(59, 60);
        dijkstra.addEdge(59, 68);
        dijkstra.addEdge(60, 61);
        dijkstra.addEdge(60, 69);
        dijkstra.addEdge(61, 62);
        dijkstra.addEdge(61, 70);
        dijkstra.addEdge(62, 63);
        dijkstra.addEdge(62, 71);
        dijkstra.addEdge(63, 64);
        dijkstra.addEdge(63, 72);
        dijkstra.addEdge(64, 65);
        dijkstra.addEdge(64, 73);
        dijkstra.addEdge(65, 66);
        dijkstra.addEdge(65, 74);
        dijkstra.addEdge(66, 75);
        dijkstra.addEdge(67, 68);
        dijkstra.addEdge(68, 69);
        dijkstra.addEdge(69, 70);
        dijkstra.addEdge(70, 71);
        dijkstra.addEdge(71, 72);
        dijkstra.addEdge(72, 73);
        dijkstra.addEdge(73, 74);
        dijkstra.addEdge(74, 75);

        dijkstra.shortestPath(27, 24);
    }
}
