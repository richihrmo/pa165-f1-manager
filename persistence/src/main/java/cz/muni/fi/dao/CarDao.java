package cz.muni.fi.dao;

import cz.muni.fi.entities.Car;
import cz.muni.fi.entities.Driver;

import java.util.List;

/**
 * @author Robert Tamas
 */
public interface CarDao {

    /**
     * List all cars which are in DB
     *
     * @return list of cars
     */
    public List<Car> listAllCars();

    /**
     * Find specific car by its driver
     *
     * @param driver driver
     * @return car with driver
     * @throws IllegalArgumentException when argumet is null
     */
    public Car findCarByDriver(Driver driver) throws IllegalArgumentException;

    /**
     * Find specific car by its id
     *
     * @param id DB id
     * @return car
     * @throws IllegalArgumentException when argumet is null
     */
    public Car findCarById(Long id) throws IllegalArgumentException;

    /**
     * Adds car to DB
     *
     * @param car car to be added
     * @throws IllegalArgumentException when argumet is null
     */
    public void addCar(Car car) throws IllegalArgumentException;

    /**
     * Updates car in DB
     *
     * @param car car to be updated
     * @throws IllegalArgumentException when argumet is null
     */
    public void updateCar(Car car) throws IllegalArgumentException;

    /**
     * Deletes car from DB
     *
     * @param car car to be deleted
     * @throws IllegalArgumentException when argumet is null
     */
    public void deleteCar(Car car) throws IllegalArgumentException;
}