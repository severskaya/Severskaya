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
    public void selectRadioButtonForRow(int numberOfRow) {
        page.getTableRadioButton(numberOfRow).click();
    }

    @Step
    public void deleteRow(){
        page.getDeleteButton().click();
    }

    @Step
    public void isActualFirstNameEqualsWithExpected(int numberOfRow, String expectedFirstName){
        assertEquals("First Name не соответствуют", page.getFirstNameValueOfPerson(numberOfRow).getText(), expectedFirstName);
    }

    @Step
    public void isActualLastNameEqualsWithExpected(int numberOfRow, String expectedLastName){
        assertEquals("Last Name не соответствуют", page.getLastNameValueOfPerson(numberOfRow).getText(), expectedLastName);
    }

    @Step
    public void isActualGenderEqualsWithExpected(int numderOfRow, String expectedGender){
        assertEquals("Gender не соответствуют", page.getGenderValueOfPerson(numderOfRow).getText(), expectedGender);
    }

    @Step
    public void isActualCategoryEqualsWithExpected(int numberOfRow, String expectedCategory){
        assertEquals("Category не соответствуют", page.getCategoryValueOfPerson(numberOfRow).getText(), expectedCategory);
    }

    @Step
    public void checkIfRowsDeleted(int expectedCountOfRows){
        int actualCountOfRowsAfterDelete = page.getAllTableElements().size();
        assertEquals("Количество строк не совпадают", actualCountOfRowsAfterDelete, expectedCountOfRows);
    }
}


