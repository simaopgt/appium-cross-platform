package steps;

import org.junit.Test;
import support.Hooks;

import static org.junit.Assert.assertEquals;

public class MyApplicationTest extends Hooks {

    static final String name = "Simao";
    static final String surname = "Pedro";
    static final String expectedResult = "Simao";

    @Test
    public void test() throws Exception {

        homePage.fill(homePage.nameField, name);
        homePage.fill(homePage.surnameField, surname);
        homePage.clickOn(homePage.fazNadaButton);

        assertEquals(expectedResult, homePage.getSomethingOnTheScreen(homePage.nameField));
    }
}

