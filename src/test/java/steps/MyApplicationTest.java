package steps;

import org.junit.Test;
import pages.HomePage;
import support.Hooks;

import static org.junit.Assert.assertEquals;

public class MyApplicationTest extends Hooks{

    private HomePage obj;

    @Test
    public void test() throws Exception {
        obj.fillName();
        obj.fillSurname();
        obj.clickOnDoNotthingButton();

        String myName = obj.nameField.getText();

        assertEquals("Simao", myName);
    }
}

