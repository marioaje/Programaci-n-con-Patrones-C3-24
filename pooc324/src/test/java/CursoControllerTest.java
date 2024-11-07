import controller.CursoController;
import da.CursosDAO;
import models.CursoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import view.ConsoleView;


import org.mockito.Mock;

import java.sql.SQLException;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CursoControllerTest {

    //DAO
    @Mock
    private CursosDAO mockCursosDAO;
    //View
    @Mock
    private ConsoleView mockView;
    //Controller

    @InjectMocks
    private CursoController cursoController;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testobtenerCursos() throws  SQLException{
        //Simulacion del dao por si viene null o con datos.
        when(mockCursosDAO.obtenerCursos()).thenReturn(null);

        //Ejecutame el metodo
        cursoController.obtenerCursos();

        //Verificamos que muestre el mensaje de los cursos o datos,
        //y que verifique si esta un dato en especifico
        verify(mockView).mostrarMensaje("ID: 11 Nombre: Nuevo Curso Empresarial Descripcion: Curso de 6 meses Estado: 1");

//        consoleView.mostrarMensaje("ID: " + item.getId() +
//                " Nombre: " + item.getNombre() +
//                " Descripcion: " + item.getDescripcion() +
//                " Estado: " + item.getEstado()

    }

//    public void obtenerCursos(){
//        //public List<CursoModel> obtenerCursos()
//        try {
//            List<CursoModel> objetoReturn = cursosDAO.obtenerCursos() ;
//            if (objetoReturn != null ){
//                consoleView.mostrarMensaje("Cargando datos...");
//                for ( CursoModel item : objetoReturn){
//                    consoleView.mostrarMensaje("ID: " + item.getId() +
//                            " Nombre: " + item.getNombre() +
//                            " Descripcion: " + item.getDescripcion() +
//                            " Estado: " + item.getEstado()
//                    );
//                }
//                consoleView.mostrarMensaje("Fin de Cargando datos...");
//            }
//            else{
//                consoleView.mostraError("No tiene datos");
//            }
//
//
//        }catch (SQLException e){
//            consoleView.mostraError("Fallo: " + e.getMessage());
//        }

}
