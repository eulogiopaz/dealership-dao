package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // URL de conexión a la base de datos
    private static final String URL =
            "jdbc:mysql://localhost:3306/concesionario";

    // Usuario de MySQL
    private static final String USER = "root";

    // Contraseña de MySQL
    private static final String PASSWORD = ""; // Sustituir oir ka contraseña del servidor correspondiente de MySQL

    // Método que devuelve una conexión
    public static Connection getConnection() {

        Connection conexion = null;

        try {

            conexion =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD);

            System.out.println(
                    "Conexión realizada correctamente");

        } catch (SQLException e) {

            System.out.println(
                    "Error al conectar");

            e.printStackTrace();
        }

        return conexion;
    }
}