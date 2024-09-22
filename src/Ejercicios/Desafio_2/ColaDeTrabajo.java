package Ejercicios.Desafio_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import Ejercicios.Desafio_2.Excepciones.*;
import Ejercicios.Desafio_2.Interfaces.Trabajo;
import Ejercicios.Desafio_2.Trabajos.*;

public class ColaDeTrabajo {
    private String nombre; // Nombre de la cola
    private boolean lista; // Estado de la cola (Si esta lista o no para retornar trabajos)
    private Queue<Trabajo> trabajos = new LinkedList<>(); // Utilizamos la interfaz Queue y le asignamos una LinkedList
                                                          // para su estructura interna

    public ColaDeTrabajo(String nombre) {
        this.nombre = nombre;
        this.lista = true; // Por ejemplo, inicializamos como lista
    }

    public void encolar(Trabajo trabajo) {
        trabajos.offer(trabajo); // Agregar trabajo a la cola
    }

    public Trabajo sacar() throws NoListaException, SinTrabajoEnColaException {
        // Se manejan primero las excepciones antes de retornar el elemento.
        if (!lista) {
            throw new NoListaException(nombre, trabajos.size());
        }
        if (trabajos.isEmpty()) {
            throw new SinTrabajoEnColaException(nombre);
        }
        return trabajos.poll();
    }

    // Método para alternar el estado de la cola
    public void alternarEstadoCola() {
        this.lista = !this.lista; // Invierte el valor actual de la cola
        if (!lista) {
            System.out.println("La cola cambió su estado a NO LISTA");
        } else {
            System.out.println("La cola cambió su estado a LISTA");
        }
    }

    public void agregarTrabajo(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Agregar Trabajo ---");
            System.out.println("1. Enviar Correo");
            System.out.println("2. Escribir Documento");
            System.out.println("3. Realizar Calculos");
            System.out.println("0. Volver");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
                case 1:
                    this.encolar(new EnviarCorreo()); // Agregar trabajo de enviar correo
                    System.out.println("Trabajo de 'Enviar Correo' agregado a la cola.");
                    break;
                case 2:
                    this.encolar(new EscribirDocumento()); // Agregar trabajo de escribir documento
                    System.out.println("Trabajo de 'Escribir Documento' agregado a la cola.");
                    break;
                case 3:
                    this.encolar(new RealizarCalculos()); // Agregar trabajo de escribir documento
                    System.out.println("Trabajo de 'Realizar Calculos' agregado a la cola.");
                    break;
                case 0:
                    exit = true; // Volver al menú principal
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
