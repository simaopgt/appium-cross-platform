package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomePage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class MyApplicationTest{

    private HomePage obj;
    private static AppiumDriver driver;

    public static OS executionOS;

    public enum OS {
        ANDROID,
        IOS
    }

    public static void setExecutionOSVariable (){
        if (System.getProperty("OperationalSystem").equals("ANDROID")){
            executionOS = OS.ANDROID;
        } else if (System.getProperty("OperationalSystem").equals("IOS")){
            executionOS = OS.IOS;
        } else{
            System.out.println("Invalid Operational System");
        }
    }

    @Before
    public void setUp() throws Exception {
        setExecutionOSVariable();
        switch (executionOS) {
            case ANDROID:
                File currentDirectory = new File(System.getProperty("user.dir"));
                File appDirectory = new File(currentDirectory, "/Apps/Android");
                File app = new File (appDirectory, "app-debug.apk");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "8.1.0");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("deviceName", "Nexus 5X");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
                currentDirectory = new File(System.getProperty("user.dir"));
                appDirectory = new File(currentDirectory, "/Apps/iOS/");
                app = new File(appDirectory, "MySecondiOSApp.app");
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 8 Plus");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("automationName", "XCUITest");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        obj = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Running tests on: " + executionOS);
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("\nTearing Down Driver.");
        if (executionOS.equals("ANDROID")) {
            driver.quit();
        } else {
            driver.quit();
            String kill[] = {"killall","Simulator"};
            Runtime.getRuntime().exec(kill);
        }
    }

    @Test
    public void test() throws Exception {

        obj.fillName();
        obj.fillSurname();
        obj.clickOnDoNotthingButton();

        String myName = obj.nameField.getText();

        assertEquals("Simao", myName);
    }
}

