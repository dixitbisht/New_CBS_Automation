package com.CBS.Base;

import com.CBS.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
   public static WebDriver driver;
   public static Properties prop;

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
        if (BrowserName.equals("Chrome")){
       System.setProperty("webdriver.chrome.driver", "/home/appinventiv/Desktop/CBS_Automation/chromedriver-linux64/chromedriver");
       driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_timeout, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));



    }
}
