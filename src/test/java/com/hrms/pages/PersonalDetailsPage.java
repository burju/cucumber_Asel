package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage {
    @FindBy(xpath = "//h1[text() = 'Personal Details']")
    public WebElement personalDetail;

    @FindBy (id = "personal_txtEmployeeId")
    public WebElement employeeIDtxt;

    @FindBy (id = "personal_txtEmpFirstName")
    public WebElement firstNameText;

    @FindBy (id = "personal_txtEmpMiddleName")
    public WebElement middleNameText;

    @FindBy (id = "personal_txtEmpLastName")
    public WebElement lastNameText;

    @FindBy(xpath = "//div[@id='profile-pic']/h1")
    public WebElement nameAboveThePic;

    @FindBy(id="btnSave")
    public WebElement editSaveBtn;

    @FindBy(id="personal_txtLicenNo")
    public WebElement driversLicenceNo;

    @FindBy(id="personal_DOB")
    public WebElement dob;

    @FindBy(id="personal_txtNICNo")
    public WebElement ssn;

    @FindBy(id="personal_txtSINNo")
    public WebElement sin;


    @FindBy(id="personal_optGender_2")
    public WebElement femaleRadio;


    @FindBy(id="personal_optGender_1")
    public WebElement maleRadio;


    @FindBy(id="personal_cmbMarital")
    public WebElement maritalSelect;

    @FindBy(id="personal_cmbNation")
    public WebElement nationalitySelect;

//    @FindBy(xpath="//input[@name='personal[optGender]']")
//    public List<WebElement> gender;



    public PersonalDetailsPage() {
        PageFactory.initElements(CommonMethods.driver, this);
    }

}
