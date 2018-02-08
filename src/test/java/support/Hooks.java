package support;

import org.junit.After;
import org.junit.Before;
import pages.HomePage;


public class Hooks extends TheBrain {

    public HomePage homePage;

    @Before
    public void setUp() throws Exception {
        startAppiumServer();
        startEmulator();
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down the Emulator.");
        stopEmulator();
        System.out.println("Closing the Appium Server");
        stopAppiumService();
    }

}
