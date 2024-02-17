package FordFulkerson;

public class Vertice {
    String nombre;
    int numVertice;
    
    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
    }
        
    public String nomVertice(){ // devuelve el nombre del vértice
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
}
