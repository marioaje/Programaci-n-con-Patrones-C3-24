package controller;

import da.CursosDAO;
import models.ConexionModel;
import models.CursoModel;
import view.ConsoleView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoController {

        private ConsoleView consoleView;
        private CursosDAO cursosDAO;
        private ConexionModel conexionModel;

        public CursoController (ConsoleView consoleView){
            this.consoleView = consoleView;
            Connection connection = ConexionModel.getConnection();
            this.cursosDAO = new CursosDAO(connection);
        }
        public void agregarCurso(String nombre, String descripcion, int estado){
            CursoModel datos = new CursoModel(nombre, descripcion, estado);

            try{
                cursosDAO.agregarCurso(datos);
                consoleView.mostrarMensaje("Datos insertados");
            }catch (SQLException e){
                consoleView.mostraError("Fallo: " + e.getMessage());
            }
        }


        public void modificarCurso(String nombre, String descripcion, int estado, int id){
            CursoModel datos = new CursoModel(nombre, descripcion, estado);
            datos.setId(id);

            try{
                cursosDAO.modificarCurso(datos);
                consoleView.mostrarMensaje("Datos modificados");
            }catch (SQLException e){
                consoleView.mostraError("Fallo: " + e.getMessage());
            }


        }


    public void obtenerCursos(){
        //public List<CursoModel> obtenerCursos()
        try {
            List<CursoModel> objetoReturn = cursosDAO.obtenerCursos() ;
            if (objetoReturn != null ){
                consoleView.mostrarMensaje("Cargando datos...");
                for ( CursoModel item : objetoReturn){
                    consoleView.mostrarMensaje("ID: " + item.getId() +
                            " Nombre: " + item.getNombre() +
                            " Descripcion: " + item.getDescripcion() +
                            " Estado: " + item.getEstado()
                    );
                }
                consoleView.mostrarMensaje("Fin de Cargando datos...");
            }
            else{
                consoleView.mostraError("No tiene datos");
            }


        }catch (SQLException e){
            consoleView.mostraError("Fallo: " + e.getMessage());
        }

    }


}

