package steps;

import org.junit.Test;
import support.Hooks;

import static org.junit.Assert.assertEquals;

public class MyApplicationTest extends Hooks {

    @Test
    public void test() throws Exception {

        homePage.fillName();
        homePage.fillSurname();
        homePage.clickOnDoNotthingButton();

        String myName = homePage.nameField.getText();

        assertEquals("Simao", myName);
    }
}

