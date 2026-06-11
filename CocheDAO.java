package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import modelo.Coche;

/**
 * Clase DAO para gestionar coches.
 */
public class CocheDAO {

    /**
     * Inserta un coche.
     */
    public void crearCoche(Coche coche) {

        String sql =
                "INSERT INTO coches VALUES (?,?,?,?,?,?,?,?)";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, coche.getMatricula());
            ps.setString(2, coche.getColor());
            ps.setString(3, coche.getModelo());
            ps.setDouble(4, coche.getPrecio());
            ps.setDouble(5, coche.getKilometros());
            ps.setString(6, coche.getPropietarioAnterior());
            ps.setInt(7, coche.getGarantia());
            ps.setString(8, coche.getTipoVehiculo());

            ps.executeUpdate();

            System.out.println("Coche insertado");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Busca un coche por matrícula.
     */
    public void leerCoche(String matricula) {

        String sql =
                "SELECT * FROM coches WHERE matricula=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, matricula);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getString("modelo"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Actualiza el precio de un coche.
     */
    public void actualizarCoche(
            String matricula,
            double nuevoPrecio) {

        String sql =
                "UPDATE coches SET precio=? WHERE matricula=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setDouble(1, nuevoPrecio);
            ps.setString(2, matricula);

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Elimina un coche.
     */
    public void eliminarCoche(String matricula) {

        String sql =
                "DELETE FROM coches WHERE matricula=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, matricula);

            ps.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Obtiene el modelo de un coche dada una matrícula.
     */
    public void buscarModeloPorMatricula(
            String matricula) {

        String sql =
                "SELECT modelo FROM coches WHERE matricula=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, matricula);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Modelo: "
                                + rs.getString("modelo"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}