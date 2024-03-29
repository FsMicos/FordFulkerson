package FordFulkerson;

public class Vertice {
    private String nombre;
    private int ejeX;
    private int ejeY;
    private int numVertice;

    public Vertice(String nombre, int ejeX, int ejeY) {
        this.nombre = nombre;
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        numVertice = -1;
    }

    public String nomVertice() { // devuelve el nombre del vértice
        return nombre;
    }

    public boolean equals(Vertice n) { // devuelve true si dos vértices son iguales
        return nombre.equals(n.nombre);
    }

    public void asigVertice(int n) { // establece el número de vértices
        numVertice = n;
    }

    public String toString() { // caracteristicas del vértice
        return nombre + " (" + numVertice + ")";
    }

    public int getEjeX() {
        return ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }
}
