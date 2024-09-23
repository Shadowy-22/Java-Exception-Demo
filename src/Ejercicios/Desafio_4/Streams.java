package Ejercicios.Desafio_4;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public void ejemploFiltrarYOrdenar() {
        List<String> myList = Arrays.asList("a1", "b1", "c2", "c1");

        // Mostrar la lista
        System.out.println("\n--- Lista de Strings ---");
        myList.forEach(m -> System.out.print(m + "  "));

        System.out.println("\n--- Filtrar y Ordenar por la letra C ---");
        myList.stream()
                .filter(s -> s.startsWith("c")) // Filtra los elementos de la lista que comienzan con la letra "c"
                .map(String::toUpperCase) // Convierte los elementos filtrados a mayúsculas
                .sorted() // Ordena los elementos resultantes alfabéticamente (por defecto, orden natural)
                .forEach(System.out::println); // Imprime cada elemento en la consola

        /*
         * ¿Qué retorna su ejecución?
         * Retorna los elementos de la lista "myList" que empiezan con la letra "c",
         * convertidos a mayúsculas y ordenados alfabéticamente.
         *
         * ¿Qué son los Streams?
         * Los Streams son secuencias de datos que permiten procesar colecciones de
         * forma declarativa y funcional, enfocándose en el "qué" y no en el "cómo".
         */

    }

    // Segundo ejemplo: calcular el promedio de una lista de números
    public void ejemploCalcularPromedio() {
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

        System.out.println("\n--- Lista de Enteros ---");
        numeros.forEach(n -> System.out.print(n + "  "));

        System.out.println("\n--- Calcular Promedio ---");
        double promedio = numeros.stream()
                .mapToInt(Integer::intValue) // Convierte los Integer a int para el cálculo
                .average() // Calculamos el promedio
                .orElse(0); // Si la lista está vacía, devuelve 0

        System.out.println("El promedio es: " + promedio);
    }
}
