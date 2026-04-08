import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();

        int[][] matriz = null;
        Stack<ObjDato> pila = new Stack<>();
        Queue<Integer> cola = new LinkedList<>();

        boolean seguir = true;

        while (seguir) {
            System.out.println("\n--- MENU PUNTO 13 ---");
            System.out.println("1) Llenar matriz");
            System.out.println("2) Mostrar matriz");
            System.out.println("3) Llenar pila");
            System.out.println("4) Mostrar pila");
            System.out.println("5) Ejecutar punto 13");
            System.out.println("6) Mostrar cola resultado");
            System.out.println("7) Salir");

            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    matriz = m.llenarMatriz(sc);
                    break;

                case 2:
                    if (matriz != null) {
                        m.mostrarMatriz(matriz);
                    } else {
                        System.out.println("Primero debe llenar la matriz");
                    }
                    break;

                case 3:
                    if (matriz != null) {
                        pila.clear();
                        pila = m.llenarPila(pila, sc, matriz.length);
                    } else {
                        System.out.println("Primero debe llenar la matriz");
                    }
                    break;

                case 4:
                    if (!pila.isEmpty()) {
                        m.mostrarPila(pila);
                    } else {
                        System.out.println("La pila esta vacia");
                    }
                    break;

                case 5:
                    if (matriz != null && !pila.isEmpty()) {
                        cola = m.Punto13(matriz, pila);
                        System.out.println("Proceso realizado");
                    } else {
                        System.out.println("Debe llenar la matriz y la pila");
                    }
                    break;

                case 6:
                    if (!cola.isEmpty()) {
                        m.mostrarCola(cola);
                    } else {
                        System.out.println("La cola esta vacia");
                    }
                    break;

                case 7:
                    seguir = false;
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }

        sc.close();
    }
}