import cz.fi.muni.pa165.PersistenceSampleApplicationContext;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


/**
 * @author Lucie Kureckova, 445264
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
public class DriverDaoTest extends AbstractTestNGSpringContextTests {
    
    @PersistenceContext
    private EntityManager em;
    
    @PersistenceUnit
    private EntityManagerFactory emf;
    
    @Autowired
    private DriverDao driverManager = new DriverDaoImpl();
    
    private Driver mainDriver1 = new Driver();
    private Driver testDriver1 = new Driver();
    private Driver testDriver2 = new Driver();
    private Driver driver1 = new Driver();
    private Driver driver2 = new Driver();
    private Driver driver3 = new Driver();
    
    
    @BeforeClass
    public void init(){
        mainDriver1.setAsMainDriver();
        mainDriver1.setName("Michael");
        mainDriver1.setSurname("Schumacher");
        mainDriver1.setNationality("germany");
        
        testDriver1.setName("Alan");
        testDriver1.setSurname("Rickman");
        
        em.persist(mainDriver1);
        em.persist(testDriver1);
        em.persist(testDriver2);
        
        driver1.setName("Albus Percival Wulfric Brian");
        driver1.setSurname("Dumbledore");
    }
    
    @Test
    public void listDriversTest(){
        assertThat(driverManager.listDrivers()).isNotNull();
        assertThat(driverManager.listDrivers()).containsExactlyInAnyOrder(mainDriver1, testDriver1, testDriver2);
    }
    
    @Test
    public void listTestDriversTest(){
        assertThat(driverManager.listTestDrivers()).isNotNull();
        assertThat(driverManager.listTestDrivers()).containsExactlyInAnyOrder(testDriver1, testDriver2);
    }
    
    @Test
    public void findDriverByIdTest(){
        assertThat(driverManager.findDriverById(testDriver1.getId())).isEqualTo(testDriver1);
    }
    
    @Test
    public void findDriverByNameTest(){
        assertThat(driverManager.findDriverByName(mainDriver1.getName(), mainDriver1.getSurname())).isEqualTo(mainDriver1);
        assertThat(driverManager.findDriverByName("sasa", "sasula")).isNull();
    }
    
    @Test
    public void findDeveloperTest(){
        assertThat(driverManager.findDeveloper(mainDriver1.getName(), mainDriver1.getSurname())).isNull();
        assertThat(driverManager.findDeveloper(testDriver1.getName(), testDriver1.getSurname())).isEqualTo(testDriver1);
    }
    
    @Test
    public void addDriverTest(){
        driverManager.addDriver(driver1);
        assertThat(em.find(Driver.class, driver1.getId())).isEqualTo(driver1);
    }
    
    @Test
    public void updateDriverTest(){
        em.persist(driver2);
        driver2.setName("Harry");
        driver2.setSurname("Potter");
        driverManager.updateDriver(driver2);
        assertThat(em.find(Driver.class, driver2.getId())).isEqualTo(driver2);
    }
    
    @Test
    public void deleteDriverTest(){
        em.persist(driver3);
        driverManager.deleteDriver(driver3);
        assertThat(em.find(Driver.class, driver2.getId())).isNull();
    }
}
