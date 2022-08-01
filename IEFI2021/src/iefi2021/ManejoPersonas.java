
package iefi2021;

import ConfigurarConexion.Alumno_DAO;
import domain.Persona;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ManejoPersonas {
        
    public static void main(String[] args) throws SQLException { 
        
        Alumno_DAO alumno_DAO = new Alumno_DAO();
        List<Persona> personas = alumno_DAO.seleccionar();
        
        Scanner a = new Scanner (System.in);
        int opcion;
        
        System.out.println("Ingrese 1 para listar, 2 para insertar, 3 para modificar o 4 para eliminar");
        opcion =  a.nextInt();
        
        switch (opcion) {
        case 1:{ System.out.println ("Listado objetos de tipo Alumno");
            personas.forEach((persona) -> {
            System.out.println("persona:" + persona);
            });
            break;   
                                
        }case 2:{ System.out.println ("Insertar un objeto de alumno existente");
            Persona persona = new Persona();
            persona.setNombre("Recu");
            persona.setApellido("IEFI");
            persona.setDni("20212021");
            alumno_DAO.insertar(persona);
            break;
        
        }case 3:{ System.out.println ("Actualizar un registro");
            Persona persona = new Persona();
            persona.setIdPersona(10);
            persona.setNombre("Recuperatorio");
            persona.setApellido("Aprobado");
            persona.setDni("21212121");        
            alumno_DAO.actualizar(persona);
            break;
            
        }case 4:{ System.out.println ("Eliminar un registro");            
            Persona persona = new Persona();
            persona.setIdPersona(10);      
            alumno_DAO.eliminar(persona);
            break;
            
        }default:{ System.err.println ("Ingrese un numero de opcion valido");
        }
        }
}
}


    
