import DAO.CityDAO;
import DAO.CityDAOImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import Models.City;
import Models.Employee;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "Olga2703";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, password)){
            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);
            CityDAO cityDAO = new CityDAOImpl(connection);

            Employee employee = new Employee("Alexey", "Gurylev", "Male", 19, 1);
            City city = new City("Rostov");

            /*employeeDAO.addEmployee(employee);
            System.out.println(employeeDAO.getAllEmployees().toString());
            System.out.println(employeeDAO.getByID(4).getAge());
            employeeDAO.deleteByID(5);
            System.out.println(employeeDAO.getAllEmployees().toString());
            employeeDAO.editEmployee(new Employee("Alexey", "Gurylev", "Male", 19, 2));*/

            cityDAO.addCity(city);
            System.out.println(cityDAO.getAllCities().toString());
            System.out.println(cityDAO.getByID(3).toString());
            cityDAO.deleteByID(6);
            System.out.println(cityDAO.getAllCities().toString());
            cityDAO.editCity(new City("Rostov"));
        }
    }
}
