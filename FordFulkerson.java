package FordFulkerson;

import java.util.List;

public class FordFulkerson {

    private final int INF = Integer.MAX_VALUE;
    private BFS bfs = new BFS();

    public int algoritmoFordFulkerson(int[][] grafoPesos, int inicio, int fin) {
        int flujoMaximo = 0;
        int[][] grafoResidual = new int[grafoPesos.length][grafoPesos.length];
        for (int i = 0; i < grafoPesos.length; i++) {
            System.arraycopy(grafoPesos[i], 0, grafoResidual[i], 0, grafoPesos[0].length);
        }

        List<Integer> rutaDeAumento = bfs.recorrerAnchura(grafoResidual, inicio, fin);
        while (rutaDeAumento != null) {
            int minCapacity = findMinCapacity(grafoResidual, rutaDeAumento);
            updateResidualCapacities(grafoResidual, rutaDeAumento, minCapacity);
            flujoMaximo += minCapacity;
            rutaDeAumento = bfs.recorrerAnchura(grafoResidual, inicio, fin);
        }
        return flujoMaximo;
    }

    private int findMinCapacity(int[][] graph, List<Integer> path) {
        int minCapacity = INF;
        for (int i = 0; i < path.size() - 1; i++) {
            int desde = path.get(i);
            int hasta = path.get(i + 1);
            minCapacity = Math.min(minCapacity, graph[desde][hasta]);
        }
        return minCapacity;
    }

    private void updateResidualCapacities(int[][] graph, List<Integer> path, int minCapacity) {
        for (int i = 0; i < path.size() - 1; i++) {
            int desde = path.get(i);
            int hasta = path.get(i + 1);
            graph[desde][hasta] -= minCapacity;
            graph[hasta][desde] += minCapacity;
        }
    }

}
