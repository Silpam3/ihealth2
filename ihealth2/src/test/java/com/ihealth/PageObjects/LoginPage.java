package com.ihealth.PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
    @FindBy (xpath="//h3[@class=\"card-title\"]")
    public WebElement Loginpage;


    @FindBy (id="Email")
    public WebElement Email;

    @FindBy (id="Password")
    public WebElement password;

    @FindBy(xpath=("//button[@class='btn btn-primary']"))
    public WebElement LoginButton;

    @FindBy(xpath=("//li[text()='Invalid login attempt.']"))
    public WebElement Errormsg;

    public void loginwithcreds(String EmailID, String Password)
    {
        Email.sendKeys(EmailID);
        password.sendKeys(Password);
        LoginButton.click();

    }
    public void loginwithinvalidcreds(String EmailID,String Password)
    {
        Email.sendKeys(EmailID);
        password.sendKeys(Password);
        LoginButton.click();
        String errormsg=Errormsg.getText();
        System.out.println(errormsg);
        Assertions.assertEquals("Invalid login attempt.",errormsg);


    }
    public void checkloginpagetitle()
    {

        Assertions.assertEquals("Login",Loginpage.getText());
    }
}
