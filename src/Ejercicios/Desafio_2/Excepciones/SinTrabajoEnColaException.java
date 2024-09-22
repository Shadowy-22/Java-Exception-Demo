package Ejercicios.Desafio_2.Excepciones;

public class SinTrabajoEnColaException extends Exception {
    private String nombre;

    public SinTrabajoEnColaException(String nom) {
        nombre = nom;
    }

    @Override
    public String getMessage() {
        return "La Cola de Trabajo: " + nombre + " no tiene trabajos para procesar. ";
    }
}
