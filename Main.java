
package FordFulkerson;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    public static void main(String[] args) throws Exception {

        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        //numero de vertices
        int n = 7;
        GrafMatPeso gra = new GrafMatPeso(n);

        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";
        String g = "G";

        //nombre de los vertices
        gra.nuevoVertice(a, 50, 50);
        gra.nuevoVertice(b, 150, 50);
        gra.nuevoVertice(c, 250, 50);
        gra.nuevoVertice(d, 50, 150);
        gra.nuevoVertice(e, 250, 150);
        gra.nuevoVertice(f, 200, 250);
        gra.nuevoVertice(g, 100, 250);

        //realizamos los enlaces (nodo_inicial, nodo_final, peso)
        gra.nuevoArco(a, b, 7);
        //gra.nuevoArco(b, a, 7);
        gra.nuevoArco(a, d, 5);
        //gra.nuevoArco(d, a, 5);
        gra.nuevoArco(b, c, 8);
        //gra.nuevoArco(c, b, 8);
        gra.nuevoArco(b, d, 9);
        //gra.nuevoArco(d, b, 9);
        gra.nuevoArco(e, b, 7);
        //gra.nuevoArco(b, e, 7);
        gra.nuevoArco(e, c, 5);
        //gra.nuevoArco(c,e, 5);
        gra.nuevoArco(e, d, 15);
        //gra.nuevoArco(d,e, 15);
        gra.nuevoArco(d, f, 6);
        //gra.nuevoArco(e,f,8);
        gra.nuevoArco(f, e, 8);
        //gra.nuevoArco(e,g,9);
        gra.nuevoArco(g, e, 9);
        //gra.nuevoArco(f,g,11);
        gra.nuevoArco(g, f, 11);

        //imprimir los vertices existentes en el grafo
        System.out.println("vertices del grafo");
        for (int w = 0; w < n; w++) {
            System.out.println(gra.vertices()[w].nomVertice() + " ");
        }
        System.out.println("\nMatriz de pesos del grafo:");
        gra.imprimirMatrizPeso();

        FordFulkerson fordFulkerson = new FordFulkerson();
        System.out.println("Flujo máximo  => " + fordFulkerson.algoritmoFordFulkerson(gra.getMatPeso(), 0, 1));
        gra.start(stage);
    }
}
