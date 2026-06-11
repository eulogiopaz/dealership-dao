package principal;

import dao.ClienteDAO;
import dao.CocheDAO;
import dao.EmpleadoDAO;

import modelo.Cliente;
import modelo.Coche;
import modelo.Empleado;

public class Main {

    public static void main(String[] args) {

        // Objetos DAO
        ClienteDAO clienteDAO =
                new ClienteDAO();

        EmpleadoDAO empleadoDAO =
                new EmpleadoDAO();

        CocheDAO cocheDAO =
                new CocheDAO();

        // Clientes
        Cliente c1 = new Cliente(
                "11111111A",
                "Juan",
                "Perez",
                "Garcia",
                "Almeria",
                "600111111",
                "juan@gmail.com");

        Cliente c2 = new Cliente(
                "22222222B",
                "Maria",
                "Lopez",
                "Ruiz",
                "Badajoz",
                "600222222",
                "maria@gmail.com");

        Cliente c3 = new Cliente(
                "33333333C",
                "Pedro",
                "Sanchez",
                "Diaz",
                "Sevilla",
                "600333333",
                "pedro@gmail.com");

        // Empleados
        Empleado e1 = new Empleado(
                "44444444D",
                "Antonio",
                "Martin",
                "Gomez",
                "Almería",
                "600444444",
                "antonio@gmail.com",
                1800);

        Empleado e2 = new Empleado(
                "55555555E",
                "Lucia",
                "Morales",
                "Fernandez",
                "Madrid",
                "600555555",
                "lucia@gmail.com",
                2000);

        Empleado e3 = new Empleado(
                "66666666F",
                "Sergio",
                "Gil",
                "Torres",
                "Almería",
                "600666666",
                "sergio@gmail.com",
                2200);

        // Coches
        Coche coche1 = new Coche(
                "1234ABC",
                "Rojo",
                "Seat Ibiza",
                18000,
                0,
                "",
                36,
                "Nuevo");

        Coche coche2 = new Coche(
                "5678DEF",
                "Negro",
                "BMW X1",
                25000,
                15000,
                "Juan Perez",
                0,
                "Segunda Mano");

        Coche coche3 = new Coche(
                "9012GHI",
                "Blanco",
                "Toyota Corolla",
                22000,
                500,
                "",
                24,
                "KM0");

        // Inserciones
        clienteDAO.crearCliente(c1);
        clienteDAO.crearCliente(c2);
        clienteDAO.crearCliente(c3);

        empleadoDAO.crearEmpleado(e1);
        empleadoDAO.crearEmpleado(e2);
        empleadoDAO.crearEmpleado(e3);

        cocheDAO.crearCoche(coche1);
        cocheDAO.crearCoche(coche2);
        cocheDAO.crearCoche(coche3);

        // Consultas
        empleadoDAO.empleadosAlmeria();

        cocheDAO.buscarModeloPorMatricula(
                "1234ABC");

        empleadoDAO.mostrarSueldos();

        // Actualización del 5%
        empleadoDAO.actualizarSueldos();
    }
}