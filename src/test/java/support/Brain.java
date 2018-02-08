package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Brain {
    public static AppiumDriver driver;
    public static OS executionOS;
    AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();

    public static void setExecutionOSVariable() {
        if (System.getProperty("OperationalSystem").equals("ANDROID")) {
            executionOS = OS.ANDROID;
        } else if (System.getProperty("OperationalSystem").equals("IOS")) {
            executionOS = OS.IOS;
        } else {
            System.out.println("Invalid Operational System");
        }
    }

    public void startEmulator() throws Exception {
        setExecutionOSVariable();
        switch (executionOS) {
            case ANDROID:
                File currentDirectory = new File(System.getProperty("user.dir"));
                File appDirectory = new File(currentDirectory, "/Apps/Android");
                File app = new File(appDirectory, "app-debug.apk");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "8.1.0");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("deviceName", "Nexus 6 API 27");
                capabilities.setCapability("avd", "Nexus_6_API_27");
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

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Running tests on: " + executionOS);
    }

    public void stopEmulator() {
        if (executionOS.equals("ANDROID")) {
            driver.quit();
            // Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
        } else {
            driver.quit();
            // String kill[] = {"killall","Simulator"};
            // Runtime.getRuntime().exec(kill);
        }
    }

    public void startAppiumServer() {
        System.out.println("Setting up the Appium Server");
        service.start();
    }

    public void stopAppiumService() {
        service.stop();
    }

    public enum OS {
        ANDROID,
        IOS
    }

}
