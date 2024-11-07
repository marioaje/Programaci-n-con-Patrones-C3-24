package org.example;

import controller.*;
import view.*;
import view.Biblioteca.FormBiblioteca;
import view.Usuarios;

import javax.swing.*;

public class Main {

//    FormBiblioteca formBiblioteca = new FormBiblioteca();
//
//    private int counter = 0;
//    private final int rounds = 3000000;
//
//    public void run() {
//        String name = Thread.currentThread().getName();
//        for (int i = 0; i < rounds; i++) {
//            // Sincronización para evitar conflictos en los hilos.
//            synchronized (this) {
//                counter++;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Proyecto conectando MySQL!");
        System.out.println("-------------------------");

        // Ejecutar el código de la GUI en el hilo de despacho de eventos
//        Usuarios uiUsuarios = new Usuarios();
//        uiUsuarios.setContentPane(uiUsuarios.getContentPane());
//        uiUsuarios.setTitle("Titulo");
//        uiUsuarios.setSize(300 , 400);
//        uiUsuarios.setVisible(true);
//        uiUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

 /*       usuariosForm.getCancelarButton().addActionListener(e -> {
            System.exit(0);
        });*/

//        try {
//            // Crear una instancia de Main que actúa como el objeto compartido por los hilos
//            Main main = new Main();
//
//            // Crear dos hilos que ejecutan el método run()
//            Thread t1 = new Thread(main::run, "thread1");
//            Thread t2 = new Thread(main::run, "thread2");
//
//            // Iniciar los hilos
//            t1.start();
//            t2.start();
//
//            // Esperar a que ambos hilos terminen su ejecución
//            t1.join();
//            t2.join();
//
//            // Mostrar el valor final de counter
//            System.out.println("Valor final de counter: " + main.counter);
//
//        } catch (InterruptedException e) {
//            System.out.println("¡Hilo interrumpido!");
//        }

        // Parte comentada que conecta con la base de datos

        ConsoleView vista = new ConsoleView();
        ConexionController controlador = new ConexionController(vista);

        controlador.abrirConexion();

        CursoController cursoController = new CursoController(vista);
        String nombre = "55-React";
        String descripcion = "Curso de 2 meses";
        int estado = 1;
        cursoController.obtenerCursos();
        cursoController.agregarCurso(nombre, descripcion, estado);

        cursoController.modificarCurso("POO", "C324", 0, 3);
        cursoController.obtenerCursos();

    }
}
