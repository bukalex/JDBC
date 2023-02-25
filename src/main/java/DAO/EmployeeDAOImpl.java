package DAO;

import Models.Employee;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
    private final Connection connection;
    public EmployeeDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addEmployee(Employee employee){
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            session.close();
        }
    }

    @Override
    public Employee getByID(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> employees = (ArrayList<Employee>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Models.Employee").list();
        return employees;
    }

    @Override
    public void editEmployeeByID(Employee employee){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void deleteByID(int id){
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(getByID(id));
            transaction.commit();
            session.close();
        }
    }
}
