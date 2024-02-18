package FordFulkerson;

public class Main {
    public static void main(String[] args) throws Exception {
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
        gra.nuevoVertice(a);
        gra.nuevoVertice(b);
        gra.nuevoVertice(c);
        gra.nuevoVertice(d);
        gra.nuevoVertice(e);
        gra.nuevoVertice(f);
        gra.nuevoVertice(g);

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
        System.out.println("Flujo máximo  => " + fordFulkerson.algoritmoFordFulkerson(gra.getMatPeso(), 0, 3));
    }
}
