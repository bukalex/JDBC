package DAO;

import Models.Employee;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.List;

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
        }
    }

    @Override
    public Employee getByID(int id){
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> getAllEmployees(){
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Models.Employee", Employee.class).list();
        }
    }

    @Override
    public void editEmployee(Employee employee){
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteByID(int id){
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.remove(getByID(id));
            transaction.commit();
        }
    }
}
