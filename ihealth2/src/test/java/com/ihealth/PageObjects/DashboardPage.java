package com.ihealth.PageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage
{
  public WebElement calender;
  public WebElement headermsg;
  public WebElement meetingsbutton;
  String Exptext="August 2021";
  String Expmsg="Dental";
  @FindBy (xpath="//span[text()=\"Add New Doctor\"]")
  public  WebElement createadoctor;
  @FindBy(xpath="//span[text()=\"Appointments\"]")
  public WebElement appointments;

  @FindBy(xpath="//h5[@class='card-title']")
  public WebElement doctordashboard;
  @FindBy(xpath="//div[@class=\"page-title d-flex\"]/h4")
  public WebElement patientdashboardmsg;

  @FindBy(xpath="//span[text()=\"Prescriptions\"]")
  public WebElement prescriptionslink;

  @FindBy (xpath="//span[@class=\"font-weight-semibold\"]")
  public WebElement prescriptionpagetitle;

    //h5[@class="card-title"]
    @FindBy(xpath = "//div[@class=\"card\"]/div[2]")
  public WebElement prescriptionspagemsg;

    @FindBy(xpath = "//span[text()=\"Appointments\"]")
   public WebElement patientappointmentslink;

    @FindBy(xpath="//span[@class=\"font-weight-semibold\"]")
    public WebElement patientappointmentstitle;

    @FindBy(xpath = "//div[@class=\"card\"]/div[2]")
    public WebElement patientappointmentpagemsg;

    @FindBy(xpath = "//i[@class=\"icon-pencil3\"]")
    public WebElement patientbookappointmentlink;

    @FindBy(xpath = "//span[@class=\"font-weight-semibold\"]")
    public WebElement patientbookappointmentpagetitle;

    @FindBy(xpath = "//div[@class=\"card\"]/div/h5")
    public WebElement bookappointmentformtitle;

    @FindBy(xpath = "//h1[@class=\"text-danger\"]")
    public WebElement submitformtitle;

    @FindBy(xpath = "//div[@class=\"text-right\"]/div/button")
    public WebElement submitbutton;

    @FindBy(xpath = "//span[text()=\"Patients\"][1]")
    public WebElement Patientslink;
    @FindBy(xpath = "//div[@class=\"card\"]/div[2]")
    public WebElement patientstitle;
    @FindBy(xpath = "//div[@class=\"card\"]/div[2]/a")
    public WebElement addnewpatient;

    @FindBy(id = "Patient")
     public WebElement Patientname;
    @FindBy(xpath = "//input[@id='Age']")
    public WebElement age;
    @FindBy(xpath = "//input[@id=\"Gender\"]")
    public WebElement gender;
    @FindBy(xpath = "//input[@id=\"Email\"]")
    public WebElement email;
    @FindBy(xpath = "//input[@id=\"Contact\"]")
    public WebElement contact;
    @FindBy(xpath = "//input[@id=\"Address\"]")
    public WebElement address;
    @FindBy(xpath = "id=\"Note\"")
    public WebElement note;
    @FindBy(id="Status")
    public WebElement Status;
    @FindBy(xpath = "//div[@class=\"text-right\"]/div/button")
    public WebElement Submit;



   public boolean isMeetingsbuttonactive()
   {
     return true;
   }
   public String getheader()
   {
      String Headermsg= driver.findElement(By.xpath("//p[\"class=mb-3\"]")).getText();
      Assertions.assertEquals("The appointments of all doctors are displayed here....",Headermsg);
      return  Headermsg;

   }
   public void iscalendervisible()
   {
       String Actualtext=driver.findElement(By.xpath("//h2[text()='August 2021']")).getText();
       Assertions.assertEquals(Exptext,Actualtext);
       System.out.println("calender is visible");

   }
   public void isappointmentbooked()
   {
       String Actualmsg=driver.findElement(By.xpath("//td[@class='sorting_1']")).getText();
       Assertions.assertEquals(Expmsg,Actualmsg);
       System.out.println("booked appointment is visible");

   }
   public void wheniclickoncreatenewdoctor() throws InterruptedException {
       JavascriptExecutor js= (JavascriptExecutor)driver;
       js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[text()=\"Add New Doctor\"]")));

        Thread.sleep(2000);
       createadoctor.click();
   }
   public void wheniclickonappointmentslink()
   {
       appointments.click();

       Assertions.assertEquals("Appointments",doctordashboard.getText());
   }
   public void checkdoctordashboardmsg()
   {

       Assertions.assertEquals("Doctor Appoinments",doctordashboard.getText());

   }
   public void checkpatientdashboardmsg()
   {

       Assertions.assertEquals("Home - Patient Dashboard",patientdashboardmsg.getText());
   }
   public void wheniclickonprescriptionslink()
   {
       prescriptionslink.click();
   }
   public void checkprescriptionpagetitle()
   {

       Assertions.assertEquals("Prescriptions",prescriptionpagetitle.getText());
   }
   public void checkprescriptionpagemsg(String prescriptionmsg)
   {
       Assertions.assertEquals(prescriptionmsg,prescriptionspagemsg.getText());
   }
   public void clickonpatientappointmentslink()
   {
       patientappointmentslink.click();
   }
   public void checkpatientappointmentstitle()
   {
       Assertions.assertEquals("Appointments" ,patientappointmentstitle.getText());
   }
   public void checkpatientappointmentpagemsg()
   {
       Assertions.assertEquals("All active appointments are displayed here.",patientappointmentpagemsg.getText());
   }
  public void clickonpatientbookappointmentlink()
  {
      patientbookappointmentlink.click();
  }
  public void checkpatientbookappointmentpagetitle()
  {

      Assertions.assertEquals("Appointments",patientbookappointmentpagetitle.getText());
  }
  public void checkpatientbookappointmentformtitle()
  {
      Assertions.assertEquals("Create new Department",bookappointmentformtitle.getText());
  }

  public void clickpatientbookappointmentsubmit()
  {
      submitbutton.click();
  }

   public void patientsubmitformpagetitle()
   {
       Assertions.assertEquals("Error.",submitformtitle.getText());
   }
   public void clickpatientslink()
   {
       Patientslink.click();
   }
   public void getpatienttitle()
   {

       Assertions.assertEquals("All active patients are displayed here. Click here to create new patients.",patientstitle.getText());
   }
   public void setAddnewpatient()
   {
       addnewpatient.click();
   }
   public void enternewpatientdetails(String Name,String Age,String Gender,String Email,String Contact,String Address,String Note)
    {
      Patientname.sendKeys(Name);
      age.sendKeys(Age);
      gender.sendKeys(Gender);
      email.sendKeys(Email);
      contact.sendKeys(Contact);
      address.sendKeys(Address);
      note.sendKeys(Note);
      Status.click();
      Submit.click();

    }

}
