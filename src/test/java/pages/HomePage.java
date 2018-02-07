package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "nome")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MySecondiOSApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField[1]")
    public MobileElement nameField;

    @AndroidFindBy(id = "sobrenome")
    @iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"MySecondiOSApp\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField[2]")
    public MobileElement surnameField;

    @AndroidFindBy(id = "fazNada")
    @iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"Faz Nada!\"]")
    public MobileElement fazNadaButton;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    public void fillName(){
        nameField.clear();
        nameField.sendKeys("Simao");
    }

    public void fillSurname(){
        surnameField.clear();
        surnameField.sendKeys("Pedro");
    }

    public void clickOnDoNotthingButton(){
        fazNadaButton.click();
    }

}
