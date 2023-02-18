import java.util.ArrayList;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getByID(int id);
    ArrayList<Employee> getAllEmployees();
    void editEmployeeByID(int id, Employee employee);
    void deleteByID(int id);
}
