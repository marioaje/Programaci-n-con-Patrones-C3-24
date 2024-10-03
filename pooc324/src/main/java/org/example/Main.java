package org.example;

import controller.*;
import view.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Proyecto conectando MySQL!");
        System.out.println("-------------------------");

        ConsoleView vista = new ConsoleView();
        ConexionController controlador = new ConexionController(vista);

        controlador.abrirConexion();

        CursoController cursoController = new CursoController(vista);
        String nombre = "Nuevo Curso Empresarial";
        String descripcion = "Curso de 6 meses";
        int estado = 1;

        cursoController.agregarCurso(nombre, descripcion, estado);



    }
}