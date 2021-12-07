package com.ihealth;
import Config.SeleniumProperties;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


@CucumberOptions(
        plugin = {"pretty","html:target/report.html"},
        features = {"src/test/resources/com/ihealth/admin.feature"},
        tags = "@patients"








)
@RunWith(Cucumber.class)
public class TestRunner
{
    static WebDriver driver;

    public static WebDriver getdriver()
    {
        if (driver == null)
        {
           if(SeleniumProperties.BROSWER_NAME.equalsIgnoreCase("chrome"))
           {
             WebDriverManager.chromedriver().setup();
             driver=new ChromeDriver();
           }
           else
           {
               WebDriverManager.firefoxdriver().setup();
               driver=new FirefoxDriver();
           }
            driver.manage().timeouts().pageLoadTimeout(SeleniumProperties.SELENIUM_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(SeleniumProperties.TEST_URL);
            return driver;
        } else
        { return driver;
        }
    }

    public static void stopDriver() {
        driver.quit();
        driver = null;
    }
}
