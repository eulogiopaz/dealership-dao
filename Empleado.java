package modelo;

/**
 * Clase que representa un empleado del concesionario.
 */
public class Empleado {

    // NIF del empleado
    private String nif;

    // Nombre
    private String nombre;

    // Primer apellido
    private String apellido1;

    // Segundo apellido
    private String apellido2;

    // Dirección
    private String direccion;

    // Teléfono
    private String telefono;

    // Correo electrónico
    private String email;

    // Sueldo
    private double sueldo;

    /**
     * Constructor completo.
     */
    public Empleado(String nif, String nombre, String apellido1,
                    String apellido2, String direccion,
                    String telefono, String email,
                    double sueldo) {

        this.nif = nif;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.sueldo = sueldo;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}