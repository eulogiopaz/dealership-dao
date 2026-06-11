package modelo;

/**
 * Clase que representa un coche del concesionario.
 */
public class Coche {

    // Matrícula del vehículo
    private String matricula;

    // Color del vehículo
    private String color;

    // Modelo del vehículo
    private String modelo;

    // Precio de venta
    private double precio;

    // Kilómetros recorridos
    private double kilometros;

    // Nombre del propietario anterior
    private String propietarioAnterior;

    // Duración de la garantía
    private int garantia;

    // Tipo de vehículo (Nuevo, KM0 o Segunda Mano)
    private String tipoVehiculo;

    /**
     * Constructor completo.
     */
    public Coche(String matricula, String color, String modelo,
                 double precio, double kilometros,
                 String propietarioAnterior,
                 int garantia,
                 String tipoVehiculo) {

        this.matricula = matricula;
        this.color = color;
        this.modelo = modelo;
        this.precio = precio;
        this.kilometros = kilometros;
        this.propietarioAnterior = propietarioAnterior;
        this.garantia = garantia;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public String getPropietarioAnterior() {
        return propietarioAnterior;
    }

    public void setPropietarioAnterior(String propietarioAnterior) {
        this.propietarioAnterior = propietarioAnterior;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}