package Ejercicios.Desafio_2.Trabajos;

import Ejercicios.Desafio_2.Interfaces.Trabajo;

public class EnviarCorreo implements Trabajo {
    @Override
    public void realizarTrabajo() {
        System.out.println("Enviando correo...");
    }
}
