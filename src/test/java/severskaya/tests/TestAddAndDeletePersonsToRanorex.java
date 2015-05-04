package severskaya.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.WebDriver;
import severskaya.steps.RanorexAddingIT;

@RunWith(SerenityRunner.class)
public class TestAddAndDeletePersonsToRanorex {

    private String expectedFirstName = "Cat";
    private String expectedLastName = "Catsvill";
    private String Gender1 = "male";
    private String Gender2 = "female";
    private String expectedGender1 = "Male";
    private String expectedGender2 = "Female";
    private String expectedCategory = "Music";
    private String expectedCategory2 = "Sport";
    private String expectedFirstName2 = "Dog";
    private String expectedLastName2 = "Doggy";

    private int numberOfFirstRow = 1;
    private int numberOfSecondRow = 2;
    private int expectedCountOfRowsAfterFirstDelete = 2;
    private int expectedCountOfRowsAfterSecondDelete = 1;

    @BeforeClass
    public static void setIp(){
        String pathToChromeDriver = "/home/gatto/Desktop/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
    }

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public RanorexAddingIT steps;

    @Test
    public void addTwoPersonsTest(){
        steps.openPage();
        steps.enterFirstName(expectedFirstName);
        steps.enterLastName(expectedLastName);
        steps.selectCategory(expectedCategory);
        steps.selectGender(Gender1);
        steps.clickAddButton();

        steps.checkTablesRow(numberOfFirstRow, expectedFirstName, expectedLastName, expectedGender1, expectedCategory);

        steps.enterFirstName(expectedFirstName2);
        steps.enterLastName(expectedLastName2);
        steps.selectCategory(expectedCategory2);
        steps.selectGender(Gender2);
        steps.clickAddButton();

        steps.checkTablesRow(numberOfSecondRow, expectedFirstName2, expectedLastName2, expectedGender2, expectedCategory2);
    }

    @Test
    public void deleteTwoPersonsTest(){
        steps.openPage();
        steps.enterFirstName(expectedFirstName);
        steps.enterLastName(expectedLastName);
        steps.selectCategory(expectedCategory);
        steps.selectGender(Gender1);
        steps.clickAddButton();

        steps.enterFirstName(expectedFirstName2);
        steps.enterLastName(expectedLastName2);
        steps.selectCategory(expectedCategory2);
        steps.selectGender(Gender2);
        steps.clickAddButton();

        steps.selectRadioButtonForRow(numberOfSecondRow);
        steps.deleteRow();
        steps.checkIfRowsDeleted(expectedCountOfRowsAfterFirstDelete);

        steps.selectRadioButtonForRow(numberOfFirstRow);
        steps.deleteRow();
        steps.checkIfRowsDeleted(expectedCountOfRowsAfterSecondDelete);
    }
} 