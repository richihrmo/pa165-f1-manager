package cz.muni.fi.DaoTests;

import cz.muni.fi.PersistenceApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Robert Tamas
 */
@ContextConfiguration(classes = PersistenceApplicationContext.class)
public class ComponentDaoTest extends AbstractTestNGSpringContextTests {

    @PersistenceContext
    private EntityManager em;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private ComponentDaoImpl componentManager = new ComponentDaoImpl();

    private Component engine;
    private Component aerodynamic;
    private Component transmission;

    @BeforeMethod
    public void setup() {
        transmission = new Component();
        transmission.setName("Transmission");
        transmission.setType(EComponentType.TRANSMISSION);
        transmission.setIsAvailable(true);

        engine = new Component();
        engine.setName("Engine");
        engine.setType(EComponentType.ENGINE);
        engine.setIsAvailable(false);

        aerodynamic = new Component();
        aerodynamic.setName("Aerodynamic");
        aerodynamic.setType(EComponentType.AERODYNAMIC);
        aerodynamic.setIsAvailable(true);

        em.getTransaction().begin();
        em.persist(transmission);
        em.persist(engine);
        em.persist(aerodynamic);
        em.getTransaction().commit();
    }

    @Test
    public void listAvailableComponentsTest() {
        List<Component> foundAvailableComponents = componentManager.listAvailableComponents();
        assertThat(foundAvailableComponents).containsExactlyInAnyOrder(engine, aerodynamic);
    }

    @Test
    public void listAllComponentsTest() {
        List<Component> foundComponents = componentManager.listAllComponents();
        assertThat(foundComponents).containsExactlyInAnyOrder(transmission, engine, aerodynamic);
    }

    @Test
    public void findComponentByNameTest() {
        Component foundComponent = componentManager.findComponent(engine.getName());
        assertThat(foundComponent).isEqualTo(engine);
    }

    @Test
    public void findComponentByIDTest() {
        Component foundComponent = componentManager.findComponent(aerodynamic.getId());
        assertThat(foundComponent).isEqualTo(aerodynamic);
    }

    @Test
    public void addComponentTest() {
        Component breaks = new Component();
        breaks.setName("Breaks");
        breaks.setType(EComponentType.BREAKS);
        breaks.setIsAvailable(true);

        componentManager.addComponent(breaks);
        assertThat(em.find(Component.class, breaks.getId())).isEqualTo(breaks);
    }

    public void updateComponent() {
        assertThat(em.find(Component.class, engine.getId())).isEqualTo(engine)

        engine.setName("Engine with edited name");
        engine.setIsAvailable(true);
        componentManager.updateComponent(engine);

        assertThat(em.find(Component.class, engine.getId())).isEqualTo(engine);
    }

    @Test
    public void deleteComponentTest() {
        assertThat(em.find(Component.class, engine.getId())).isEqualTo(engine);
        componentManager.deleteComponent(engine);
        assertThat(em.find(Component.class, engine.getId())).isNull();
    }

    @AfterMethod
    public void tearDown() {
        em.getTransaction().begin();
        em.createQuery("delete from Component").executeUpdate();
        em.getTransaction().commit();
    }
}
