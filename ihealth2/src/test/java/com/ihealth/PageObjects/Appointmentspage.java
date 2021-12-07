package com.ihealth.PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Appointmentspage
{
   @FindBy(xpath="//div[@class=\"card\"]/div[2]")
    public WebElement Headermsg;
   @FindBy(xpath = "//tbody/tr[1]/td[2]")
   public WebElement Docname;
   @FindBy(xpath="//div[@class=\"dataTables_filter\"]/label/input")
   public WebElement Filter;
   @FindBy(xpath="//tr[@class=\"odd\"]/td[6]")
   public WebElement Filtermsg;

   public void getheadermsg()
   {
       Assertions.assertEquals("All active appointments are displayed here. Click here to create new appointments.",Headermsg.getText());

   }
   public void checkpatientdetailsdisplayed()
   {

      Assertions.assertEquals("Silpa Raju",Docname.getText());

   }
   public void checkfiltermsg(String diseasename)
   {
      Assertions.assertEquals(diseasename,Filtermsg.getText());
   }







}
