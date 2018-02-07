package support;

import org.junit.After;
import org.junit.Before;

public class Hooks extends Brain{

    public Brain brain = new Brain();

    @Before
    public void setUp() throws Exception {
        brain.startAppiumServer();
        brain.startEmulator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Tearing Down Driver.");
        brain.stopEmulator();
        System.out.println("Closing the Appium Server");
        brain.stopAppiumService();
    }

}
