package da;

import models.CursoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursosDAO {

    private Connection connection;

    public CursosDAO (Connection connection ){
        this.connection = connection;
    }

    public void agregarCurso(CursoModel objeto) throws SQLException {

        //INSERT INTO `prof_curso`(`nombre`, `descripcion`, `estado`) VALUES (?, ?, ?)
        String query = "INSERT INTO `prof_curso`(`nombre`, `descripcion`, `estado`) VALUES (?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getDescripcion());
            stmt.setInt(3, objeto.getEstado());
            stmt.executeUpdate();
        }

    }


    public void modificarCurso(CursoModel objeto) throws SQLException {
//UPDATE `prof_curso` SET `id`='[value-1]',`nombre`='[value-2]',`descripcion`='[value-3]',`estado`='[value-4]' WHERE 1
        //INSERT INTO `prof_curso`(`nombre`, `descripcion`, `estado`) VALUES (?, ?, ?)
        String query = "UPDATE `prof_curso` SET `nombre`=?,`descripcion`=?,`estado`=? WHERE `id` = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, objeto.getNombre());
            stmt.setString(2, objeto.getDescripcion());
            stmt.setInt(3, objeto.getEstado());
            stmt.setInt(4, objeto.getId());
            stmt.executeUpdate();
        }

    }


    public List<CursoModel> obtenerCursos() throws SQLException {
        List<CursoModel> objetoReturn = new ArrayList<>();

        String query = "SELECT `id`, `nombre`, `descripcion`, `estado` FROM `prof_curso`";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet listaBaseDatos = stmt.executeQuery();
            while ( listaBaseDatos.next() ){
                CursoModel objeto = new CursoModel(
                                            listaBaseDatos.getString("nombre"),
                                            listaBaseDatos.getString("descripcion"),
                                            listaBaseDatos.getInt("estado")
                                    );
                objeto.setId(listaBaseDatos.getInt("id"));

                objetoReturn.add(objeto);
            }
            return  objetoReturn;
        }

    }


    //DELETE FROM `prof_curso` WHERE 0


    //SELECT `id`, `nombre`, `descripcion`, `estado` FROM `prof_curso` WHERE 1

}
