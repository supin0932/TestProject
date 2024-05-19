package testcase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import commons.BaseSetup;
import commons.Validate;
import ultilities.PropertiesFile;
import pages.LoginPage;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseSetup {
    private static WebDriver driver;
    private Validate validate;
    private LoginPage loginPage;
    static ExtentReports reports;
    static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    @BeforeClass
    public void setup()
    {
        PropertiesFile.setPropertiesFile();
        driver = new BaseSetup().setDriver(PropertiesFile.getPropValue("browser"), PropertiesFile.getPropValue("url"));
        LoginPage loginPage = new LoginPage(driver);
        validate = new Validate(driver);
        ExtentSparkReporter spark = new ExtentSparkReporter("targer/report.html");
        extent.attachReporter(spark);
    }
    @Test
    public void loginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        test = extent.createTest("Login page","This test login with user name and password");
        loginPage.LogIn(PropertiesFile.getPropValue("phone"),PropertiesFile.getPropValue("password"));
        extent.flush();
    }
    @AfterClass
    public static void cleanup()
    {
        extent.flush();
    }
    }

