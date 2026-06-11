package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import modelo.Cliente;

/**
 * Clase DAO para gestionar la tabla clientes.
 */
public class ClienteDAO {

    /**
     * Inserta un cliente en la base de datos.
     */
    public void crearCliente(Cliente cliente) {

        String sql =
                "INSERT INTO clientes VALUES (?,?,?,?,?,?,?)";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNif());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getApellido1());
            ps.setString(4, cliente.getApellido2());
            ps.setString(5, cliente.getDireccion());
            ps.setString(6, cliente.getTelefono());
            ps.setString(7, cliente.getEmail());

            ps.executeUpdate();

            System.out.println(
                    "Cliente insertado correctamente");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Busca un cliente por NIF.
     */
    public void leerCliente(String nif) {

        String sql =
                "SELECT * FROM clientes WHERE nif = ?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, nif);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                System.out.println(
                        rs.getString("nombre")
                                + " "
                                + rs.getString("apellido1"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Actualiza el teléfono de un cliente.
     */
    public void actualizarCliente(
            String nif,
            String telefonoNuevo) {

        String sql =
                "UPDATE clientes SET telefono=? WHERE nif=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, telefonoNuevo);
            ps.setString(2, nif);

            ps.executeUpdate();

            System.out.println(
                    "Cliente actualizado");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente.
     */
    public void eliminarCliente(String nif) {

        String sql =
                "DELETE FROM clientes WHERE nif=?";

        try (Connection con =
                     ConexionBD.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, nif);

            ps.executeUpdate();

            System.out.println(
                    "Cliente eliminado");

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}