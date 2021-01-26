package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage {

    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "middleName")
    public WebElement middleNameTextbox;

    @FindBy(id = "lastName")
    public WebElement lastNameTextbox;

    @FindBy(id = "employeeId")
    public WebElement empIDTextbox;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(id = "chkLogin")
    public WebElement createLoginCheckbox;

    @FindBy (id = "photofile")
    public WebElement photograph;

    @FindBy (id = "chkLogin")
    public WebElement createLoginDetails;

    @FindBy (id = "user_name")
    public WebElement usernameCreate;

    @FindBy (id = "user_password")
    public WebElement userPassword;

    @FindBy (id = "re_password")
    public WebElement rePassword;


    @FindBy(xpath="//span[@for='firstName']")
    public WebElement errorMessage;


    @FindBy (id = "menu_pim_viewEmployeeList")
    public WebElement empListBtn;




    public AddEmployeePage() {

        PageFactory.initElements(CommonMethods.driver, this);
    }
}
