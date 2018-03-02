package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {

    @AndroidFindBy(id = "nome")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MySecondiOSApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    public MobileElement nameField;

    @AndroidFindBy(id = "sobrenome")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MySecondiOSApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
    public MobileElement surnameField;

    @AndroidFindBy(id = "fazNada")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Faz Nada!\"]")
    public MobileElement doNothingButton;

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void fillWith(MobileElement element, String string) {
        System.out.println("\n## Filling " + element + " with " + string + "\n");
        element.clear();
        element.sendKeys(string);
    }

    public void clickOn(MobileElement element) {
        System.out.println("\n## Clicking on " + element + "\n");
        element.click();
    }

    public String getSomethingOnTheScreen(MobileElement element) {
        return element.getText();
    }

}
