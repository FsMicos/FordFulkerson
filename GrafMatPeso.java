package FordFulkerson;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GrafMatPeso {

    private int[][] matPeso; // Matriz de pesos
    private Vertice[] verts;
    private int numVerts;
    private final int CIRCLE_RADIUS = 20;

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

    public void nuevoVertice(String nom, int ejeX, int ejeY) {
        boolean esta = numVertice(nom) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nom, ejeX, ejeY);
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
        Vertice v = new Vertice(vs, 0, 0);
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


    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualización del Grafo");

        Pane root = new Pane();


        Circle puntoA1 = new Circle(3, Color.RED);
        puntoA1.setTranslateX(50);
        puntoA1.setTranslateY(50);
        root.getChildren().add(puntoA1);
        double velocidadX = 0;
        double velocidadY = 1;

        Circle puntoA2 = new Circle(3, Color.RED);
        puntoA2.setTranslateX(42);
        puntoA2.setTranslateY(50);
        root.getChildren().add(puntoA2);

        Circle puntoA3 = new Circle(3, Color.RED);
        puntoA3.setTranslateX(34);
        puntoA3.setTranslateY(50);
        root.getChildren().add(puntoA3);

        Circle puntoA4 = new Circle(3, Color.RED);
        puntoA4.setTranslateX(58);
        puntoA4.setTranslateY(50);
        root.getChildren().add(puntoA4);

        Circle puntoA5 = new Circle(3, Color.RED);
        puntoA5.setTranslateX(66);
        puntoA5.setTranslateY(50);
        root.getChildren().add(puntoA5);


        Circle puntoB1 = new Circle(3, Color.DARKVIOLET);
        puntoB1.setTranslateX(50);
        puntoB1.setTranslateY(50);
        root.getChildren().add(puntoB1);
        double velocidadBX = 1;
        double velocidadBY = 0;
        double velocidadCX = -1;
        double velocidadCY = 1;

        Circle puntoB2 = new Circle(3, Color.DARKVIOLET);
        puntoB2.setTranslateX(50);
        puntoB2.setTranslateY(42);
        root.getChildren().add(puntoB2);

        Circle puntoB3 = new Circle(3, Color.DARKVIOLET);
        puntoB3.setTranslateX(50);
        puntoB3.setTranslateY(34);
        root.getChildren().add(puntoB3);

        Circle puntoB4 = new Circle(3, Color.DARKVIOLET);
        puntoB4.setTranslateX(50);
        puntoB4.setTranslateY(58);
        root.getChildren().add(puntoB4);

        Circle puntoB5 = new Circle(3, Color.DARKVIOLET);
        puntoB5.setTranslateX(50);
        puntoB5.setTranslateY(66);
        root.getChildren().add(puntoB5);

        Circle puntoB6 = new Circle(3, Color.DARKVIOLET);
        puntoB6.setTranslateX(50);
        puntoB6.setTranslateY(26);
        root.getChildren().add(puntoB6);

        Circle puntoB7 = new Circle(3, Color.DARKVIOLET);
        puntoB7.setTranslateX(50);
        puntoB7.setTranslateY(74);
        root.getChildren().add(puntoB7);


        // Agrega círculos para representar los vértices
        drawCircle(root, verts[0]);
        drawCircle(root, verts[1]);
        drawCircle(root, verts[2]);
        drawCircle(root, verts[3]);
        drawCircle(root, verts[4]);
        drawCircle(root, verts[5]);
        drawCircle(root, verts[6]);

        // Conecta los vértices con líneas y cabezas de flecha
        drawArrow(root, verts[0], verts[1], 7);
        drawArrow(root, verts[0], verts[3], 5);
        drawArrow(root, verts[1], verts[2], 8);
        drawArrow(root, verts[1], verts[3], 9);
        drawArrow(root, verts[4], verts[1], 7);
        drawArrow(root, verts[4], verts[2], 5);
        drawArrow(root, verts[4], verts[3], 15);
        drawArrow(root, verts[3], verts[5], 6);
        drawArrow(root, verts[5], verts[4], 8);
        drawArrow(root, verts[6], verts[4], 9);
        drawArrow(root, verts[6], verts[5], 11);


        animarPunto(puntoA2, velocidadX, velocidadY, -8, 0);
        animarPunto(puntoA3, velocidadX, velocidadY, 8, 0);
        animarPunto(puntoA4, velocidadX, velocidadY, -16, 0);
        animarPunto(puntoA5, velocidadX, velocidadY, 16, 0);
        animarPunto(puntoA1, velocidadX, velocidadY, 0, 0);

        animarPunto(puntoB2, velocidadBX, velocidadBY, 0, -8);
        animarPunto(puntoB3, velocidadBX, velocidadBY, 0, 8);
        animarPunto(puntoB4, velocidadBX, velocidadBY, 0, -16);
        animarPunto(puntoB5, velocidadBX, velocidadBY, 0, 16);
        animarPunto(puntoB1, velocidadBX, velocidadBY, 0, 0);
        animarPunto(puntoB6, velocidadBX, velocidadBY, 0, 24);
        animarPunto(puntoB7, velocidadBX, velocidadBY, 0, -24);

       //animarPunto(puntoB2, velocidadCX, velocidadCY, 0, -158);
       //animarPunto(puntoB3, velocidadCX, velocidadCY, 0, 158);
       //animarPunto(puntoB4, velocidadCX, velocidadCY, 0, -166);
       //animarPunto(puntoB5, velocidadCX, velocidadCY, 0, 166);
       //animarPunto(puntoB1, velocidadCX, velocidadCY, 150, 150);


        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void animarPunto(Circle punto, double velocidadX, double velocidadY, int i, int j) {
        double posicionX = punto.getTranslateX();
        double posicionY = punto.getTranslateX();
        // Crea una animación para mover el punto
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), event -> {
            // Actualiza la posición del punto en cada frame

            if (punto.getTranslateY() == 150 || punto.getTranslateX() == 150) {
                punto.setTranslateX(50 + (i));
                punto.setTranslateY(50 + (j));

            }
            punto.setTranslateX(punto.getTranslateX() + velocidadX);
            punto.setTranslateY(punto.getTranslateY() + velocidadY);

        }));

        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
    }

    private void drawCircle(Pane group, Vertice vertice) {
        Circle circle = new Circle(vertice.getEjeX(), vertice.getEjeY(), CIRCLE_RADIUS);
        circle.setFill(Color.LIGHTBLUE);

        group.getChildren().add(circle);

        // Agrega etiquetas para los vértices
        Text text = new Text(vertice.getEjeX() - CIRCLE_RADIUS / 2 - 6, vertice.getEjeY() + CIRCLE_RADIUS / 2 - 1, vertice.nomVertice());
        group.getChildren().add(text);
    }

    private void drawArrow(Pane group, Vertice start, Vertice end, int weight) {
        Line line = new Line(start.getEjeX(), start.getEjeY(), end.getEjeX(), end.getEjeY());
        group.getChildren().add(line);

        // Crea la cabeza de la flecha
        double arrowHeadSize = 10;
        double angle = Math.atan2(end.getEjeY() - start.getEjeY(), end.getEjeX() - start.getEjeX());
        double x1 = end.getEjeX() - arrowHeadSize * Math.cos(angle - Math.toRadians(30));
        double y1 = end.getEjeY() - arrowHeadSize * Math.sin(angle - Math.toRadians(30));
        double x2 = end.getEjeX() - arrowHeadSize * Math.cos(angle + Math.toRadians(30));
        double y2 = end.getEjeY() - arrowHeadSize * Math.sin(angle + Math.toRadians(30));

        Polygon arrowHead = new Polygon(end.getEjeX(), end.getEjeY(), x1, y1, x2, y2);
        arrowHead.setFill(Color.CORAL);
        group.getChildren().add(arrowHead);

        // Agrega una etiqueta de texto para el peso de la arista
        double textX = (start.getEjeX() + end.getEjeX()) / 2;
        double textY = (start.getEjeY() + end.getEjeY()) / 2 - 5;
        Text weightText = new Text(textX, textY, Integer.toString(weight));
        group.getChildren().add(weightText);
    }

}
