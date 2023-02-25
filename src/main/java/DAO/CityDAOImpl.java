package DAO;

import Models.City;
import Models.Employee;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.util.ArrayList;

public class CityDAOImpl implements CityDAO{
    private final Connection connection;
    public CityDAOImpl(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
            session.close();
        }
    }

    @Override
    public City getByID(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
    }

    @Override
    public ArrayList<City> getAllCities() {
        ArrayList<City> cities = (ArrayList<City>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Models.City").list();
        return cities;
    }

    @Override
    public void deleteByID(int id) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(getByID(id));
            transaction.commit();
            session.close();
        }
    }
}
