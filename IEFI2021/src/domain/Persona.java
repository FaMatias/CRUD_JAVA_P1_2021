package domain;

public class Persona {
    
    private int idPersona;
    private String nombre;
    private String apellido;
    private String dni;

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellido, String dni) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    
}
