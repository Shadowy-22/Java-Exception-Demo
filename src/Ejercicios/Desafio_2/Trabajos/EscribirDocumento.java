package Ejercicios.Desafio_2.Trabajos;

import Ejercicios.Desafio_2.Interfaces.Trabajo;

public class EscribirDocumento implements Trabajo {
    @Override
    public void realizarTrabajo() {
        System.out.println("Escribiendo Documento...");
    }
}
