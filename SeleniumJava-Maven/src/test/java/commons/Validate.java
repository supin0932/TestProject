package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Validate {
    private WebDriver driver;

    public Validate(WebDriver _driver){
        driver = _driver;
    }

    public void clickBtn(By element){
        driver.findElement(element).click();
    }
    public void setText(By element, String value){
        driver.findElement(element).sendKeys(value);
    }
}
