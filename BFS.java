package FordFulkerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<Integer> recorrerAnchura(int[][] g, int source, int sink) {
        int[] parent = new int[g.length];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        parent[source] = source;
        while (!queue.isEmpty() && parent[sink] == -1) {
            int current = queue.poll();

            for (int next = 0; next < g.length; next++) {
                if (parent[next] == -1 && g[current][next] > 0) {
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }
        if (parent[sink] == -1) {
            return null; // No hay camino aumentante
        }

        List<Integer> path = new ArrayList<>();
        for (int v = sink; v != source; v = parent[v]) {
            path.add(v);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
