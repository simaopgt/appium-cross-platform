package support;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TheBrain {

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
        System.out.println("\n## Running tests on: " + executionOS + "\n");
        System.out.println("\n## Setting up the Emulator\n");
    }

    public void stopEmulator() throws IOException {
        System.out.println("\n## Tearing Down the Emulator\n");
        driver.quit();
    }

    public void startAppiumServer() {
        System.out.println("\n## Setting up the Appium Server\n");
        service.start();
    }

    public void stopAppiumService() {
        System.out.println("\n## Tearing Down the Appium Server\n");
        service.stop();
    }

    public enum OS {
        ANDROID,
        IOS
    }

}
