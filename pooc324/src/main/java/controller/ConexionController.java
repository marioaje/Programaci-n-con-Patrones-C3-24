package controller;

import models.ConexionModel;
import view.ConsoleView;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionController {

    //vista???
  /*  public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }

    public void mostraError(String mensaje){
        System.err.println(mensaje);
    }*/

    private ConsoleView vista;


    public ConexionController(ConsoleView vista){
        this.vista = vista;
    }


    public void abrirConexion(){
        Connection connection = ConexionModel.getConnection();

        if( connection != null){
            try{
                connection.close();
                vista.mostrarMensaje("Conexion establecida");
            }catch (SQLException e){
                vista.mostraError("Conexion presenta errores: " + e.getMessage());
            }

        }
        else{

        }



    }

}
