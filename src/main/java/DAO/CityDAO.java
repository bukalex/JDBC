package DAO;

import Models.City;

import java.util.ArrayList;

public interface CityDAO {
    void addCity(City city);
    City getByID(int id);
    ArrayList<City> getAllCities();
    void deleteByID(int id);
}
