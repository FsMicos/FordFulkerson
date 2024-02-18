package FordFulkerson;

import java.util.List;

public class FordFulkerson {

    private static final int INF = Integer.MAX_VALUE;

    public static int fordFulkerson(int[][] graph, int source, int sink) {
        int maxFlow = 0;
        int[][] residualGraph = new int[graph.length][graph[0].length];
        for (int i = 0; i < graph.length; i++) {
            System.arraycopy(graph[i], 0, residualGraph[i], 0, graph[0].length);
        }

        List<Integer> augmentingPath = BFS.recorrerAnchura(residualGraph, source, sink);
        while (augmentingPath != null) {
            int minCapacity = findMinCapacity(residualGraph, augmentingPath);
            updateResidualCapacities(residualGraph, augmentingPath, minCapacity);
            maxFlow += minCapacity;
            augmentingPath = BFS.recorrerAnchura(residualGraph, source, sink);
        }
        return maxFlow;
    }

    private static int findMinCapacity(int[][] graph, List<Integer> path) {
        int minCapacity = INF;
        for (int i = 0; i < path.size() - 1; i++) {
            int desde = path.get(i);
            int hasta = path.get(i + 1);
            minCapacity = Math.min(minCapacity, graph[desde][hasta]);
        }
        return minCapacity;
    }

    private static void updateResidualCapacities(int[][] graph, List<Integer> path, int minCapacity) {
        for (int i = 0; i < path.size() - 1; i++) {
            int desde = path.get(i);
            int hasta = path.get(i + 1);
            graph[desde][hasta] -= minCapacity;
            graph[hasta][desde] += minCapacity;
        }
    }

}
