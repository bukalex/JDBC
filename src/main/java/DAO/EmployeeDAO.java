package DAO;

import Models.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getByID(int id);
    List<Employee> getAllEmployees();
    void editEmployee(Employee employee);
    void deleteByID(int id);
}
