package severskaya.steps;

import org.openqa.selenium.WebElement;
import severskaya.pages.RanorexVipPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class RanorexAddingIT extends ScenarioSteps {

    public RanorexVipPage page;

    @Step
    public void openPage(){
        page.open();
    }

    @Step
    public void enterFirstName(String firstName){
        page.getFirstNameField().sendKeys(firstName);
    }

    @Step
    public void enterLastName(String lastName){
        page.getLastNameField().sendKeys(lastName);
    }

    @Step
    public void selectCategory(String categoryName){
        List<WebElement> listOfElements = page.getCategoryField();
        page.getCategoryFromList(listOfElements, categoryName).click();
    }

    @Step
    public void selectGender(String genderName){
        page.getGenderRadioBoxByName(genderName).click();
    }

    @Step
    public void clickAddButton(){
        page.getAddButton().click();
    }

    @Step
    public void checkTablesRow(int numberOfRow, String expectedFirstName,
                               String expectedLastName, String expectedGender, String expectedCategory){
        assertEquals(page.getFirstNameValueOfPerson(numberOfRow).getText(), expectedFirstName);
        assertEquals(page.getLastNameValueOfPerson(numberOfRow).getText(), expectedLastName);
        assertEquals(page.getGenderValueOfPerson(numberOfRow).getText(), expectedGender);
        assertEquals(page.getCategoryValueOfPerson(numberOfRow).getText(), expectedCategory);
    }

    @Step
    public void selectRadioButtonForRow(int numberOfRow) {
        page.getTableRadioButton(numberOfRow).click();
    }

    @Step
    public void deleteRow(){
        page.getDeleteButton().click();
    }

    @Step
    public void checkIfRowsDeleted(int expectedCountOfRows){
        int actualCountOfRowsAfterDelete = page.getAllTableElements().size();
        assertEquals(actualCountOfRowsAfterDelete, expectedCountOfRows);
    }
}


