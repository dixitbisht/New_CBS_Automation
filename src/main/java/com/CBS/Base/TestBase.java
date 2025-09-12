package com.CBS.Base;

import com.CBS.Util.TestUtil;
import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.http.Route;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
   public static WebDriver driver;
   public static Properties prop;
   public static ChromeOptions options;

    public TestBase() {
try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/home/appinventiv/Desktop/CBS_Automation/New_CBS_Automation/src/main/java/com/CBS/config/config.properties");
            prop.load(ip);
        }
catch (Exception e) {
    e.printStackTrace();
}
    }

    public static void intitlisation() {
        String BrowserName = prop.getProperty("Browser");
        if (BrowserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Desktop/CBS_Automation/chromedriver-linux64/chromedriver");
            //driver = new ChromeDriver();
            options = new ChromeOptions();

//            else if(BrowserName.equals("firefox")){
//                System.setProperty("webdriver.gecko.driver", "/home/appinventiv/Desktop/CBS_Automation/geckodriver-v0.36.0-linux64/geckodriver");
//              driver  = new FirefoxDriver();
//
//            }

        try {
            Path tempProfileDir = Files.createTempDirectory("chrome-profile");
            options.addArguments("--user-data-dir=" + tempProfileDir.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Recommended for Jenkins/Linux
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        ///options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));



    }
}
