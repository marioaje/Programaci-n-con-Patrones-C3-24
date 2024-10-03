package controller;

import da.CursosDAO;
import models.ConexionModel;
import models.CursoModel;
import view.ConsoleView;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}

