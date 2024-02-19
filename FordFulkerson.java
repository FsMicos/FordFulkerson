package FordFulkerson;

import java.util.Arrays;
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
            imprimirLista(rutaDeAumento);
            int capacidadMinima = encontrarCapacidadMinima(grafoResidual, rutaDeAumento);
            actualizarCapacidadesResiduales(grafoResidual, rutaDeAumento, capacidadMinima);
            flujoMaximo += capacidadMinima;
            rutaDeAumento = bfs.recorrerAnchura(grafoResidual, inicio, fin);
        }
        return flujoMaximo;
    }

    private void imprimirLista(List<Integer> rutaDeAumento) {
        System.out.println("Imprimiendo el camino:");
        for (int elemento : rutaDeAumento) {
            switch (elemento) {
                case 0:
                    System.out.print("A ");
                    break;
                case 1:
                    System.out.print("B ");
                    break;
                case 2:
                    System.out.print("C ");
                    break;
                case 3:
                    System.out.print("D ");
                    break;
                case 4:
                    System.out.print("E ");
                    break;
                case 5:
                    System.out.print("F ");
                    break;
                case 6:
                    System.out.print("G ");
                    break;
            }

        }
        System.out.println("\n");
    }

    private int encontrarCapacidadMinima(int[][] grafoPesos, List<Integer> camino) {
        int capacidadMinima = INF;
        for (int i = 0; i < camino.size() - 1; i++) {
            int desde = camino.get(i);
            int hasta = camino.get(i + 1);
            capacidadMinima = Math.min(capacidadMinima, grafoPesos[desde][hasta]);
        }
        return capacidadMinima;
    }

    private void actualizarCapacidadesResiduales(int[][] grafoPesos, List<Integer> camino, int capacidadMinima) {
        for (int i = 0; i < camino.size() - 1; i++) {
            int desde = camino.get(i);
            int hasta = camino.get(i + 1);
            grafoPesos[desde][hasta] -= capacidadMinima;
        }
    }

}
