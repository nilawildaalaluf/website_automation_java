package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    WebDriver driver;
    public  homePage(WebDriver driver){
        this.driver=driver;
    }

    //locator dari register button
    By registerButton = By.xpath("//a[contains(@href, 'register')]");

    public void clickRegister(){
        driver.findElement(registerButton).click();
    }
}
