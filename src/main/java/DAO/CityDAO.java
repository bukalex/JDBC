package DAO;

import Models.City;

import java.util.List;

public interface CityDAO {
    void addCity(City city);
    City getByID(int id);
    List<City> getAllCities();
    void editCity(City city);
    void deleteByID(int id);
}
