import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "Olga2703";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password)){
             EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            Employee employee = new Employee("Alexey", "Gurylev", "Male", 18, 1);
            //employeeDAO.addEmployee(employee);
            //System.out.println(employeeDAO.getAllEmployees().toString());
            //System.out.println(employeeDAO.getByID(4).getAge());
            //employeeDAO.deleteByID(6);
            //System.out.println(employeeDAO.getAllEmployees().toString());
            employeeDAO.editEmployeeByID(2, new Employee("Имя", "Фамилия", "Male", 1, 2));
        }
    }
}
