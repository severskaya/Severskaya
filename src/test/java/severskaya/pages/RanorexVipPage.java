package severskaya.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip/")
public class RanorexVipPage extends PageObject {

    public WebElement getFirstNameField(){
        return find(By.id("FirstName"));
    }

    public WebElement getLastNameField(){
        return find(By.id("LastName"));
    }

    public List<WebElement> getCategoryField(){
        return getDriver().findElements(By.xpath("//*[@id = 'Category']/*"));
    }

    public WebElement getGenderRadioBoxByName(String name){
        return find(By.xpath("//*[@id = 'Gender' and @value = " + "'" + name + "'" + "]"));
    }

    public WebElement getAddButton(){
        return find(By.id("Add"));
    }

    public WebElement getDeleteButton(){
        return find(By.id("Delete"));
    }

    public WebElement getCategoryFromList(List<WebElement> categoryList, String category){
        WebElement returnElement = null;
        for(WebElement element : categoryList) {
            if (element.getAttribute("value").equals(category)){
                returnElement = element;
            }
        }
        return returnElement;
    }

    public WebElement getFirstNameValueOfPerson(int numberOfLine){
        return getDriver().findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[2]"));
    }

    public WebElement getLastNameValueOfPerson(int numberOfLine){
        return getDriver().findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[3]"));
    }

    public WebElement getGenderValueOfPerson(int numberOfLine){
        return getDriver().findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[4]"));
    }

    public WebElement getCategoryValueOfPerson(int numberOfLine){
        return getDriver().findElement(By.xpath("//*[@id='VIPs']/tbody/tr["+ (numberOfLine + 1) +"]/td[5]"));
    }

    public WebElement getTableRadioButton(int numberOfLine){
        return getDriver().findElement(By.xpath("//*[@id='VIPs']/tbody/tr[" + (numberOfLine + 1) + "]/td[1]/*[@id = 'VIP']"));
    }

    public List<WebElement> getAllTableElements(){
        return getDriver().findElements(By.xpath("//*[@id='VIPs']/tbody/tr"));
    }
}