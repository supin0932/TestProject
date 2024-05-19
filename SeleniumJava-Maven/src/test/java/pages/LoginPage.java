package pages;
import commons.Validate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    private Validate validate;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        validate = new Validate(this.driver);
    }


    // Element at Login
    private By PostBtn = By.xpath("//a[contains(text(),'ĐĂNG TIN')]");
    private By phoneInput = By.xpath("//input[@name='phone']");
    private By passInput = By.xpath("//input[@name='password']");
    private By LoginBtn = By.xpath("//button[contains(text(),'Đăng nhập')]");


    public void LogIn(String phoneValue, String passValue)
    {
        System.out.println("Click on Post button");
        validate.clickBtn(PostBtn);
        System.out.println("Input numberphone");
        validate.setText(phoneInput, phoneValue);
        System.out.println("Input password");
        validate.setText(passInput, passValue);
        System.out.println("Click on Login button");
        validate.clickBtn(LoginBtn);

    }
}

