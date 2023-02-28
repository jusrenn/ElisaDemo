package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver == null) {
            switch (ConfigReader.getProperty("browser")) {
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriverNoBrowser() {
        if(driver == null) {
            ChromeOptions chrome = new ChromeOptions();
            chrome.setHeadless(true);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chrome);
        }
        return driver;
    }

    public static void close() {
        if(driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quit() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
