package DAO;

import Models.Employee;

import java.util.ArrayList;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    Employee getByID(int id);
    ArrayList<Employee> getAllEmployees();
    void editEmployeeByID(Employee employee);
    void deleteByID(int id);
}
