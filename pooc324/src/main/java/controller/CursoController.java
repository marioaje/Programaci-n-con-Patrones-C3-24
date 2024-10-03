package controller;

import da.CursosDAO;
import models.ConexionModel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CursoController {

        private ConsoleView consoleView;
        private CursosDAO cursosDAO;
        private ConexionModel conexionModel;

        public CursoController (ConsoleView consoleView){
            this.consoleView = consoleView;
            Connection connection = this.conexionModel.getConnection();
            this.cursosDAO = new CursosDAO(connection);
        }
}

