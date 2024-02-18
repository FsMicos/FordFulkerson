package FordFulkerson;

public class GrafMatPeso {

    private int[][] matPeso; // Matriz de pesos
    private Vertice[] verts;
    private int numVerts;

    // Constructor que inicializa la matriz de pesos con valores infinitos
    public GrafMatPeso(int mx) {
        matPeso = new int[mx][mx];
        verts = new Vertice[mx];
        for (int i = 0; i < mx; i++) {
            for (int j = 0; j < mx; j++) {
                matPeso[i][j] = 0;
            }
        }
        numVerts = 0;
    }

    public void nuevoVertice(String nom) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom);
            v.asigVertice(numVerts);
            verts[numVerts++] = v;
        }
    }

    public void nuevoArco(String a, String b, int peso) throws Exception { // busca en el array ambos vértices y marca la matriz
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) throw new Exception("Vértice no existe");
        matPeso[va][vb] = peso;
    }

    public int[][] getMatPeso() {
        return matPeso;
    }

    public Vertice[] vertices() {
        return verts;
    }

    public int numVertice(String vs) { // devuelve -1 si no lo encuentra
        Vertice v = new Vertice(vs);
        boolean encontrado = false;
        int i = 0;
        for (; (i < numVerts) && !encontrado; ) {
            encontrado = verts[i].equals(v);
            if (!encontrado) i++;
        }
        return (i < numVerts) ? i : -1;
    }

    // Método para imprimir la matriz de pesos (opcional)
    public void imprimirMatrizPeso() {
        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                if (matPeso[i][j] > 9) {
                    System.out.print(matPeso[i][j] + " ");
                } else {
                    System.out.print(matPeso[i][j] + "  ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }
}
