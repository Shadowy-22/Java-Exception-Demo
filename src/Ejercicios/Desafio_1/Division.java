package Ejercicios.Desafio_1;

public class Division {
    /*
     * Punto b: Cuando "b" es 0, se genera una excepción
     * del tipo ArithmeticException en Java debido a una división por cero.
     * 
     * Punto d: La excepción más adecuada para manejar la división por cero
     * sería IllegalArgumentException.
     * Esta excepción se usa cuando se pasa un argumento ilegal o inapropiado a un
     * método.
     * En este caso, b = 0 sería un argumento inválido para la división.
     */
    
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return a / b;
    }

}