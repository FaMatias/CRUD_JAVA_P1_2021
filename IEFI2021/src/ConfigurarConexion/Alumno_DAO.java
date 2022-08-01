package ConfigurarConexion;

;
import domain.Persona;
import java.sql.*;
import java.util.*;

public class Alumno_DAO {

    private static final String SQL_SELECT = "SELECT id_alumno, nombre, apellido, DNI FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombre, apellido, DNI) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre = ?, apellido = ?, DNI = ? WHERE id_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE id_alumno = ?";
    
    public List<Persona> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona alumnos = null;
        List<Persona> personas = new ArrayList<Persona>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("DNI");

                alumnos = new Persona();
                alumnos.setIdPersona(idPersona);
                alumnos.setNombre(nombre);
                alumnos.setApellido(apellido);
                alumnos.setDni(dni);

                personas.add(alumnos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }
    
    public int insertar(Persona alumnos) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, alumnos.getNombre());
            stmt.setString(2, alumnos.getApellido());
            stmt.setString(3, alumnos.getDni());
            
            System.out.println("Ejecutando quiery: " + SQL_INSERT);
            registros = stmt.executeUpdate();
            System.out.println("Registros afectados: " + registros);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return registros;
    }
    
    public int actualizar(Persona alumnos) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando quiery: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumnos.getNombre());
            stmt.setString(2, alumnos.getApellido());
            stmt.setString(3, alumnos.getDni());
            stmt.setInt(4, alumnos.getIdPersona());
            
            registros = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + registros);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return registros;
    }
    
     public int eliminar(Persona alumnos) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumnos.getIdPersona());
            registros = stmt.executeUpdate();
            System.out.println("Registros eliminados: " + registros);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
                Conexion.close(stmt);
                Conexion.close(conn);
        }
        return registros;
    }
}
