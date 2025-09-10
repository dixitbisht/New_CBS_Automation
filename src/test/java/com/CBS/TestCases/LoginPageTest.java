package com.CBS.TestCases;

import com.CBS.Base.TestBase;
import com.CBS.pages.HomePage;
import com.CBS.pages.LoginPage;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    //private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    LoginPage loginpage;
    HomePage home;


    public LoginPageTest(){
        super();
    }

@BeforeMethod
    public void init() throws InterruptedException{
   intitlisation();
   loginpage  = new LoginPage();
}
@Test(priority = 1)
public void SignIn()  {

        loginpage.ClickSignIn();
}
@Test(priority = 2)
public void Login(){
        SignIn();
        home = loginpage.AcountSelect(prop.getProperty("username"), prop.getProperty("Password"));
}

@AfterMethod
    public void tearDown(){
        driver.quit();
}
}
