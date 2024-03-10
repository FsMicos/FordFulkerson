package FordFulkerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public List<Integer> recorrerAnchura(int[][] grafoPesos, int inicio, int fin) {
        int[] padres = new int[grafoPesos.length];
        Arrays.fill(padres, -1);
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        padres[inicio] = inicio;
        while (!cola.isEmpty() && padres[fin] == -1) {
            int nodoActual = cola.poll();

            for (int nodoSiguiente = 0; nodoSiguiente < grafoPesos.length; nodoSiguiente++) {
                if (padres[nodoSiguiente] == -1 && grafoPesos[nodoActual][nodoSiguiente] > 0) {
                    padres[nodoSiguiente] = nodoActual;
                    cola.add(nodoSiguiente);
                }
            }
        }
        if (padres[fin] == -1) {
            return null; // No hay camino aumentante
        }



        List<Integer> camino = new ArrayList<>();

        for (int v = fin; v != inicio; v = padres[v]) {
            camino.add(v);
        }
        camino.add(inicio);
        Collections.reverse(camino);
        return camino;
    }
}
