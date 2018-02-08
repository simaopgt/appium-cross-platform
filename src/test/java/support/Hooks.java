package support;

import org.junit.After;
import org.junit.Before;
import pages.HomePage;


public class Hooks extends Brain {

    public Brain brain = new Brain();
    public HomePage homePage;

    @Before
    public void setUp() throws Exception {
        brain.startAppiumServer();
        brain.startEmulator();
        homePage = new HomePage(Brain.driver);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down Driver.");
        brain.stopEmulator();
        System.out.println("Closing the Appium Server");
        brain.stopAppiumService();
    }

}
