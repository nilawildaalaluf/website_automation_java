package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPages {
    WebDriver driver;
    public  registerPages(WebDriver driver){
        this.driver=driver;
    }

    //locator dari register button
    By firstNameField = By.id("customer.firstName");
    By lastNameField = By.name("customer.lastName");

    public void inputNameData(String firstName, String lastName){

        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
    }
}
