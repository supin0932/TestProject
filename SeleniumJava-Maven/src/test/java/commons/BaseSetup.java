package commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class BaseSetup {
    static String driverPath = "resources\\drivers\\";
    protected WebDriver setDriver;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public WebDriver setDriver(String browser, String url) {
        switch (browser.trim().toLowerCase()) {
            case "chrome" -> driver = initChromeDriver(url);
            case "firefox" -> driver = initFirefoxDriver(url);
            default -> {
                System.out.println("Browser: " + browser + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(url);
            }
        }
        return driver;
    }

    private WebDriver initChromeDriver(String url) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    private WebDriver initFirefoxDriver(String url) {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


