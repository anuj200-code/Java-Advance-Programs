import java.util.*;

class TopoSort {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++)
            for (int j : graph.get(i))
                indegree[j]++;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (indegree[i] == 0) q.add(i);

        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int adj : graph.get(node)) {
                indegree[adj]--;
                if (indegree[adj] == 0) q.add(adj);
            }
        }

        System.out.println("Topological Order: " + order);
    }
}
