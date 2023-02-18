import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO{
    private final Connection connection;
    public EmployeeDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee){
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES ((?), (?), (?), (?), (?))")){
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityID());

            statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee getByID(int id){
        Employee employee = new Employee();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee WHERE id = (?)")){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityID = resultSet.getInt("city_id");

                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setGender(gender);
                employee.setAge(age);
                employee.setCityID(cityID);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> employees = new ArrayList<>();

        try(PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM employee")){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String gender = resultSet.getString("gender");
                int age = resultSet.getInt("age");
                int cityID = resultSet.getInt("city_id");

                employees.add(new Employee(firstName, lastName, gender, age, cityID));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public void editEmployeeByID(int id, Employee employee){
        try(PreparedStatement statement = connection.prepareStatement(
                "UPDATE employee SET first_name = (?), last_name = (?), gender = (?), age = (?), city_id = (?) WHERE id = (?)")){
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityID());

            statement.setInt(6, id);
            statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteByID(int id){
        try(PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM employee WHERE id = (?)")){
            statement.setInt(1, id);

            statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
