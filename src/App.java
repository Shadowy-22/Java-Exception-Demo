import java.util.Scanner;

import Ejercicios.Desafio_1.Division;
import Ejercicios.Desafio_2.ColaDeTrabajo;
import Ejercicios.Desafio_2.Interfaces.Trabajo;
import Ejercicios.Desafio_4.Streams;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Desafio 1: Division");
            System.out.println("2. Desafio 2: Cola Trabajo");
            System.out.println("3. Desafio 4: Streams");
            System.out.println("0. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    menuDivision(scanner);
                    break;
                case 2:
                    menuColaTrabajo(scanner);
                    break;
                case 3:
                    menuStream(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void menuColaTrabajo(Scanner scanner) {
        boolean exit = false;
        ColaDeTrabajo cola = null; // Declarar cola fuera del switch

        while (!exit) {
            System.out.println("\n--- Cola de Trabajo ---");
            System.out.println("1. Crear la cola");
            System.out.println("2. Alternar el estado de la Cola");
            System.out.println("3. Agregar trabajo a la cola");
            System.out.println("4. Sacar trabajo de la cola");
            System.out.println("0. Volver al menú principal");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    cola = new ColaDeTrabajo("Cola Principal"); // Inicializar cola
                    System.out.println("Cola creada.");
                    break;
                case 2:
                    if (isColaCreada(cola)) {
                        cola.alternarEstadoCola();
                    }
                    break;
                case 3:
                    if (isColaCreada(cola)) {
                        cola.agregarTrabajo(scanner); // Llamar al submenú
                    }
                    break;
                case 4:
                    if (isColaCreada(cola)) {
                        try {
                            Trabajo trabajo = cola.sacar();
                            trabajo.realizarTrabajo(); // Ejecutar el trabajo
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static boolean isColaCreada(ColaDeTrabajo cola) {
        if (cola == null) {
            System.out.println("Primero debes crear la cola.");
            return false;
        }
        return true;
    }

    private static void menuDivision(Scanner scanner) {
        boolean exit = false;
        Division division = new Division();

        while (!exit) {
            System.out.println("\n--- División ---");
            System.out.print("Ingresa el valor de a: ");
            int a = scanner.nextInt();

            System.out.print("Ingresa el valor de b: ");
            int b = scanner.nextInt();

            try {
                int resultado = division.dividir(a, b);
                System.out.println("Resultado: " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Excepción: " + e.getMessage());
            }

            System.out.println("¿Deseas realizar otra operación? (1: Sí, 0: No)");
            int choice = scanner.nextInt();
            exit = (choice == 0);
        }
    }

    private static void menuStream(Scanner scanner) {
        Streams streams = new Streams();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Streams ---");
            System.out.println("1. Filtrar y Ordenar");
            System.out.println("2. Calcular Promedio");
            System.out.println("0. Volver al menú principal");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    streams.ejemploFiltrarYOrdenar(); // Llamamos al primer ejemplo
                    break;
                case 2:
                    streams.ejemploCalcularPromedio(); // Llamamos al segundo ejemplo
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
