package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import modelo.Empleado;

/**
 * Clase DAO para gestionar empleados.
 */
public class EmpleadoDAO {

    /**
     * Inserta un empleado.
     */
    public void crearEmpleado(Empleado empleado) {

        String sql =
                "INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, empleado.getNif());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getApellido1());
            ps.setString(4, empleado.getApellido2());
            ps.setString(5, empleado.getDireccion());
            ps.setString(6, empleado.getTelefono());
            ps.setString(7, empleado.getEmail());
            ps.setDouble(8, empleado.getSueldo());

            ps.executeUpdate();

            System.out.println("Empleado insertado");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Consulta un empleado por NIF.
     */
    public void leerEmpleado(String nif) {

        String sql =
                "SELECT * FROM empleados WHERE nif=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, nif);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getString("nombre"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Actualiza sueldo.
     */
    public void actualizarEmpleado(
            String nif,
            double sueldoNuevo) {

        String sql =
                "UPDATE empleados SET sueldo=? WHERE nif=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setDouble(1, sueldoNuevo);
            ps.setString(2, nif);

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Elimina empleado.
     */
    public void eliminarEmpleado(String nif) {

        String sql =
                "DELETE FROM empleados WHERE nif=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, nif);

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Consulta empleados de Almería.
     */
    public void empleadosAlmeria() {

        String sql =
                "SELECT * FROM empleados WHERE direccion='Almería'";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql);

             ResultSet rs =
                     ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        rs.getString("nombre"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Muestra empleados y sueldo.
     */
    public void mostrarSueldos() {

        String sql =
                "SELECT nombre,sueldo FROM empleados";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql);

             ResultSet rs =
                     ps.executeQuery()) {

            while (rs.next()) {

                System.out.println(
                        rs.getString("nombre")
                                + " - "
                                + rs.getDouble("sueldo"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    /**
     * Incrementa un 5% el sueldo de todos los empleados.
     */
    public void actualizarSueldos() {

        try (Connection con =
                     ConexionBD.getConnection()) {

            String sql =
                    "SELECT nif, nombre, sueldo FROM empleados";

            PreparedStatement ps =
                    con.prepareStatement(
                            sql,
                            ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                double sueldoActual =
                        rs.getDouble("sueldo");

                double nuevoSueldo =
                        sueldoActual * 1.05;

                rs.updateDouble(
                        "sueldo",
                        nuevoSueldo);

                rs.updateRow();

                System.out.println(
                        rs.getString("nombre")
                                + " -> "
                                + nuevoSueldo);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}