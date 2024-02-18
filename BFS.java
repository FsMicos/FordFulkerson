package FordFulkerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<Integer> recorrerAnchura(int[][] grafoPesos, int inicio, int fin) {
        int[] parent = new int[grafoPesos.length];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(inicio);
        parent[inicio] = inicio;
        while (!queue.isEmpty() && parent[fin] == -1) {
            int current = queue.poll();

            for (int next = 0; next < grafoPesos.length; next++) {
                if (parent[next] == -1 && grafoPesos[current][next] > 0) {
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }
        if (parent[fin] == -1) {
            return null; // No hay camino aumentante
        }

        List<Integer> path = new ArrayList<>();
        for (int v = fin; v != inicio; v = parent[v]) {
            path.add(v);
        }
        path.add(inicio);
        Collections.reverse(path);
        return path;
    }
}
