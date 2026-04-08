import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Metodos {

    public int[][] llenarMatriz(Scanner sc) {
        System.out.println("Ingrese filas de la matriz:");
        int n = sc.nextInt();

        System.out.println("Ingrese columnas de la matriz:");
        int m = sc.nextInt();

        int[][] matriz = new int[n][m];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Ingrese valor [" + i + "][" + j + "]:");
                matriz[i][j] = sc.nextInt();
            }
        }

        return matriz;
    }

    public void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Stack<ObjDato> llenarPila(Stack<ObjDato> p, Scanner sc, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            ObjDato o = new ObjDato();

            System.out.println("Ingrese numero para la pila en posicion " + i + ":");
            o.setNumero(sc.nextInt());

            p.push(o);
        }

        return p;
    }

    public void mostrarPila(Stack<ObjDato> p) {
        for (ObjDato o : p) {
            System.out.print(o.getNumero() + " ");
        }
        System.out.println();
    }

    public void mostrarCola(Queue<Integer> c) {
        for (Integer num : c) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public double promedioPila(Stack<ObjDato> p) {
        if (p.isEmpty()) {
            return 0;
        }

        int suma = 0;
        for (ObjDato o : p) {
            suma += o.getNumero();
        }

        return (double) suma / p.size();
    }

    public Queue<Integer> Punto13(int[][] matriz, Stack<ObjDato> pila) {
        Queue<Integer> cola = new LinkedList<>();

        double promedioAntes = promedioPila(pila);
        System.out.println("Promedio de la pila antes del cambio: " + promedioAntes);

        Stack<ObjDato> aux = new Stack<>();

        // Pasar pila a auxiliar para recorrerla desde abajo
        while (!pila.isEmpty()) {
            aux.push(pila.pop());
        }

        int i = 0;
        while (!aux.isEmpty()) {
            ObjDato o = aux.pop();
            int valorPila = o.getNumero();

            // devolver a pila original
            pila.push(o);

            // multiplicar el valor de la pila por cada registro de la fila i
            for (int j = 0; j < matriz[i].length; j++) {
                int mult = valorPila * matriz[i][j];

                if (mult > 1000) {
                    mult = 1000;
                }

                if (mult < 500 && mult > 490) {
                    mult = 500;
                }

                cola.offer(mult);
            }

            i++;
        }

        double promedioDespues = promedioPila(pila);
        System.out.println("Promedio de la pila despues del cambio: " + promedioDespues);

        return cola;
    }
}