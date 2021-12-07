package com.ihealth.PageObjects;

import com.ihealth.TestRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage
{
   WebDriver driver;

   public BasePage()
   {
       driver= TestRunner.getdriver();
       PageFactory.initElements(driver,this);
   }
}
