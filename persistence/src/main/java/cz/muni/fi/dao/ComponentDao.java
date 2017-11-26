package cz.muni.fi.dao;

import cz.muni.fi.entities.Component;

import java.util.List;

/**
 * @author Matus Macko
 */
public interface ComponentDao {
    /**
     * List all available components in DB
     *
     * @return list of all available components
     */
    List<Component> listAvailableComponents();

    /**
     * List all components in DB
     *
     * @return list of all components
     */
    List<Component> listAllComponents();

    /**
     * Find component in DB by name
     *
     * @param name component name
     * @return found component or null
     * @throws IllegalArgumentException when argumet is null
     */
    Component findComponentByName(String name) throws IllegalArgumentException;

    /**
     * Find component in DB by id
     *
     * @param id component id
     * @return found component or null
     * @throws IllegalArgumentException when argumet is null
     */
    Component findComponentById(Long id) throws IllegalArgumentException;

    /**
     * Add component to DB
     *
     * @param component component to be added
     * @throws IllegalArgumentException when argumet is null
     */
    Component addComponent(Component component) throws IllegalArgumentException;

    /**
     * Update component in DB
     *
     * @param component compondent to be updated
     * @throws IllegalArgumentException when argumet is null
     */
    Component updateComponent(Component component) throws IllegalArgumentException;

    /**
     * Delete component from DB
     *
     * @param component component to be deleted
     * @throws IllegalArgumentException when argumet is null
     */
    Component deleteComponent(Component component) throws IllegalArgumentException;
}