package com.ihealth;

import com.ihealth.PageObjects.Addanewdoctor;
import com.ihealth.PageObjects.Appointmentspage;
import com.ihealth.PageObjects.DashboardPage;
import com.ihealth.PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class stepdefinitions {
    LoginPage login = new LoginPage();
    DashboardPage dashboard = new DashboardPage();
    Addanewdoctor addanewdoctor = new Addanewdoctor();
    Appointmentspage appointmentspage = new Appointmentspage();


    WebDriver driver;

    @Before
    public void startBrowser() {
        driver = TestRunner.getdriver();
    }

    @After
    public void stopBrowser() {
        TestRunner.stopDriver();
    }


    @Given("A user goes to login page by clicking URL")
    public void aUserGoesToLoginPageByClickingURL() {
        System.out.println("login page");
    }


    @When("A {string} gives valid credentials as EmailID {string} and Password {string}")
    public void aGivesValidCredentialsAsEmailIDAndPassword(String User, String EmailID, String Password) {
        login.loginwithcreds(EmailID, Password);
        System.out.println("successful login as    " + User);
    }

    @Then("{string} should login successfully and dashboard page should be displayed")
    public void should_login_successfully_and_dashboard_page_should_be_displayed(String user) {
        String calanderdetails = driver.findElement(By.xpath("//th//span[text()=\"Tue\"]")).getText();
        String expectedmsg = "Tue";
        Assert.assertEquals(expectedmsg, calanderdetails);
        System.out.println("log in successful as     " + user);

    }


    @Given("An Admin is in login page")
    public void anAdminIsInLoginPage() {
        login.checkloginpagetitle();
    }

    @When("Admin enters login credentials as EmailId {string} and Password{string}")
    public void adminEntersLoginCredentialsAsEmailIdAndPassword(String EmailId, String Password) {
        login.loginwithcreds(EmailId, Password);
    }


    @Then("Admin should be able to access dashboard")
    public void adminShouldBeAbleToAccessDashboard() {
        dashboard.getheader();

    }
    @When("Admin click on create new patients link")
    public void adminClickOnCreateNewPatientsLink()
    {
        dashboard.clickpatientslink();
    }
    @Then("Admin will go to create new patient page")
    public void adminWillGoToCreateNewPatientPage()
    {
        dashboard.getpatienttitle();
        dashboard.setAddnewpatient();
    }


    @Then("Admin should be able to create new patients as <{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>")
    public void adminShouldBeAbleToCreateNewPatientsAs(String patientname, String Age, String Gender, String Email, String Contact, String Address, String Note)
    {
      // dashboard.enternewpatientdetails(patientname,Age,Gender,Email,Contact,Address,Note);
      dashboard.Patientname.sendKeys(patientname);

    }





    @When("A {string} gives credentials as EmailID {string} and Password {string}")
    public void aGivesCredentialsAsEmailIDAndPassword(String User, String EmailId, String Password
    ) {
        login.loginwithcreds(EmailId, Password);
        System.out.println("login successful as  " + User);

    }


    @Then("{string} should n't  login successfully with invalid credentials and an  error message should be displayed")
    public void shouldNTLoginSuccessfullyWithInvalidCredentialsAndAnErrorMessageShouldBeDisplayed(String user) {
        System.out.println("invalid login attempt, please retry");

    }

    @When("A {string} gives in valid credentials as EmailID {string} and Password {string}")
    public void aGivesInValidCredentialsAsEmailIDAndPassword(String user, String EmailID, String Password) {
        login.loginwithinvalidcreds(EmailID, Password);
    }

    @Then("Admin should be able to see booked appointments")
    public void adminShouldBeAbleToSeeBookedAppointments() {
        dashboard.iscalendervisible();
        dashboard.isappointmentbooked();
    }

    @Then("Admin should be able to click on create new doctors link")
    public void adminShouldBeAbleToClickOnCreateNewDoctorsLink() throws InterruptedException {
        dashboard.wheniclickoncreatenewdoctor();
    }

    @When("Admin gives all valid details in the fields as  <{string}>,<{string}>,<{string}>,<{string}>,<{string}>,<{string}>")
    public void adminGivesAllValidDetailsInTheFieldsAs(String Doctorname, String Qulification, String Note, String Email, String Contact, String Address) {


        addanewdoctor.Qualification.sendKeys(Qulification);
        addanewdoctor.Note.sendKeys(Note);
        addanewdoctor.Email.sendKeys(Email);
        addanewdoctor.Contact.sendKeys(Contact);
        addanewdoctor.Address.sendKeys(Address);
        addanewdoctor.clickonstatus();

    }

    @And("click on submit form button")
    public void clickOnSubmitFormButton() {
        addanewdoctor.clickonsubmitbutton();
    }

    @When("Admin clicks on Appointments link")
    public void adminClicksOnDepartmentsLink() {
        dashboard.wheniclickonappointmentslink();
    }

    @Then("Admin should be able to see booked appointment")
    public void adminShouldBeAbleToSeeBookedAppointment() {
        appointmentspage.getheadermsg();
        appointmentspage.checkpatientdetailsdisplayed();


    }

    /**
     * doctors features  test cases starts here
     **/

    @Then("Doctor should be able to see calender")
    public void doctorShouldBeAbleToSeeCalender() {
        dashboard.iscalendervisible();
    }

    @Then("doctor should be able to see appointments title")
    public void doctorShouldBeAbleToSeeAppointmentsTitle() {
        dashboard.checkdoctordashboardmsg();
    }

    @When("doctor clicked on Appointments link")
    public void doctorClickedOnAppointmentsLink() {
        dashboard.wheniclickonappointmentslink();
    }

    @Then("doctor should be able to see booked appointments")
    public void doctorShouldBeAbleToSeeBookedAppointments() {
        dashboard.isappointmentbooked();
    }


    @Then("doctor should be navigated to appointments page")
    public void doctorShouldBeNavigatedToAppointmentsPage() {
        dashboard.checkdoctordashboardmsg();
    }

    @When("doctor filters with a disease {string}")
    public void doctorFiltersWithADisease(String diseasename) {
        appointmentspage.Filter.sendKeys(diseasename);
        appointmentspage.Filter.click();
        appointmentspage.checkfiltermsg(diseasename);
    }

    @Then("only details about that disease should be displayed")
    public void onlyDetailsAboutThatDiseaseShouldBeDisplayed() {

    }


    /**
     * patients page features displayed here
     **/


    @Given("A Patient is in login page")
    public void aPatientIsInLoginPage() {
        login.checkloginpagetitle();
    }

    @When("a Patient should login with valid credentials as {string} and {string}")
    public void aPatientShouldLoginWithValidCredentialsAsAnd(String Email, String Password) {
        login.loginwithcreds(Email, Password);
    }

    @Then("Patient should goto patient dashboard")
    public void patientShouldGotoPatientDashboard() {
        dashboard.checkpatientdashboardmsg();
    }

    @When("Patient clicks on Prescription link")
    public void patientClicksOnPrescriptionLink() {
        dashboard.wheniclickonprescriptionslink();
    }

    @Then("Patient should goto Prescription page")
    public void patientShouldGotoPrescriptionPage() {
        dashboard.checkprescriptionpagetitle();
    }

    @Then("Patient should see the message {string}")
    public void patientShouldSeeTheMessage(String prescriptionmsg) {
        dashboard.checkprescriptionpagemsg(prescriptionmsg);
    }

    @When("Patient clicks on Appointments link")
    public void patientClicksOnAppointmentsLink() {
        dashboard.clickonpatientappointmentslink();
    }

    @Then("Patient should goto Appointments page")
    public void patientShouldGotoAppointmentsPage() {
        dashboard.checkpatientappointmentstitle();
    }

    @Then("patient should see the message as {string}")
    public void patientShouldSeeTheMessageAs(String patientappointmentmsg) {
        dashboard.checkprescriptionpagemsg(patientappointmentmsg);
    }

    @When("patient clicks on book an appointment link")
    public void patientClicksOnBookAnAppointmentLink() {
        dashboard.clickonpatientbookappointmentlink();
    }


    @Then("Patient book new appointments page will display")
    public void patientBookNewAppointmentsPageWillDisplay() {
        dashboard.checkpatientbookappointmentformtitle();
        dashboard.checkpatientbookappointmentpagetitle();
    }

    @When("Patient enters new appointment details  and clicks on the submitbutton")
    public void patientEntersNewAppointmentDetailsAndClicksOnTheSubmitbutton() {
        dashboard.clickpatientbookappointmentsubmit();
    }

    @Then("Patient details should be submitted")
    public void patientDetailsShouldBeSubmitted() {
        dashboard.patientsubmitformpagetitle();
    }



}