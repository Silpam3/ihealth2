package com.ihealth.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Addanewdoctor extends BasePage
{
    @FindBy(id="select2-DepartmentID-container")
    public WebElement DepartmentId;
    @FindBy(id="Doctor")
    public WebElement Doctor;
    @FindBy(id="Qualification")
    public WebElement Qualification;
    @FindBy(id="Note")
    public WebElement Note;
    @FindBy(id="Email")
    public WebElement Email;
    @FindBy(id="Contact")
    public WebElement Contact;
    @FindBy(id="Address")
    public WebElement Address;
    @FindBy(id="Status")
    public WebElement Status;
    @FindBy(xpath="//button[@class=\"btn btn-primary\"]")
    public WebElement Submitbutton;


    public void selectDepartmentID()
    {
        Select departmentID= new Select(DepartmentId);
        departmentID.selectByIndex(3);
    }
    public void clickonstatus()
    {
      Status.click();
    }
    public void clickonsubmitbutton()
    {
        Submitbutton.click();
    }







}
