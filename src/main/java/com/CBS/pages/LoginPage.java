package com.CBS.pages;

import com.CBS.Base.TestBase;
import com.CBS.Util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class LoginPage extends TestBase {

    WebDriverWait Ww;

    @FindBy(xpath = "//button[contains(text(), 'Login with Credentials')]")
    WebElement loginButton;

    @FindBy(xpath = "//input[contains(@type,'password')]")
    WebElement Password;

    @FindBy(xpath = "//input[contains(@id,'iusername')]")
    WebElement Username;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Login;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    public void ClickSignIn(){
   Ww = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.expliciyWait));
    Ww.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }
public HomePage AcountSelect(String username, String password){
        Username.sendKeys(username);
        Password.sendKeys(password);
        Login.click();
        return new HomePage();
}

}
