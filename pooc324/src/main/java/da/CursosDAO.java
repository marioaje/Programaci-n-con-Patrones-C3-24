package da;

import models.CursoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
