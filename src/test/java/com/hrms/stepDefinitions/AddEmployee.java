package com.hrms.stepDefinitions;

import com.hrms.pages.*;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sk.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Map;

public class AddEmployee extends CommonMethods {

    String displayedID;
    String employeeId;
    String currentID;
    String currentName;

    @Given("I logged into HRMS")
    public void I_logged_into_HRMS(){


        loginPage.login(ConfigsReader.getPropertyValue("username"), ConfigsReader.getPropertyValue("password"));
    }
      @When("I naviate to AddEmployee Page")
    public void i_naviate_to_add_employee_page() {

        jsClick(dashboardPage.PIMButton);
        jsClick(dashboardPage.addEmployeeBtn);
    }

    @Then("I add first {string}, middle {string}, and {string}")
    public void  i_add_first_middle_and(String string, String string2, String string3) {

        sendText(addEmployeePage.firstNameTextBox, string);
        sendText(addEmployeePage.middleNameTextbox, string2);
        sendText(addEmployeePage.lastNameTextbox, string3);
        employeeId= addEmployeePage.empIDTextbox.getText();
    }


    @Then("I click save btn")
    public void i_click_save_btn() {

        click(addEmployeePage.saveButton);
    }

    @Then("I verify I sucessfully added the employee")
    public void i_verify_i_sucessfully_added_the_employee() {

         displayedID= personalDetailsPage.employeeIDtxt.getText();
        Assert.assertEquals("employee is not being added" , employeeId, displayedID);
    }

@Then("I delete employeeID")
public void I_delete_employeeID(){
        addEmployeePage.empIDTextbox.clear();

        }
@Then("I see employee without id is being added")
    public void I_see_employee_without_id_is_being_added(){

        String firstNameDisplayed= personalDetailsPage.firstNameText.getAttribute("value");
        Assert.assertEquals("The employee is not added", "Bourrraa", firstNameDisplayed );
    }

    @Then("I see required error message")
    public void I_see_required_error_message(){

        Assert.assertTrue("Error message is NOT displayed", addEmployeePage.errorMessage.isDisplayed());
    }

    @When("I add first {string} middle {string} and {string}")
    public void I_add_first___middle__and_(String fName, String mName, String lName){

        sendText(addEmployeePage.firstNameTextBox,fName);
        sendText(addEmployeePage.middleNameTextbox, mName);
        sendText(addEmployeePage.lastNameTextbox, lName);
        click(addEmployeePage.saveButton);
    }

    @Then("I see Employee with {string} {string} and {string} is displayed")
    public void I_see_Employee_with___and__is_displayed(String fName, String mName, String lName){

    String actualText= personalDetailsPage.nameAboveThePic.getText();
    String expected=fName+" "+mName+" "+lName;
    Assert.assertEquals("Excepted name doesn't match with the actual name displayed",expected,actualText );
    }

    @When("I navigate to EmployeeList")
    public void I_navigate_to_EmployeeList(){

        jsClick(addEmployeePage.empListBtn);
           }
     @Then("I enter  employee {string}")
     public void I_enter_employee_(String ID){
        sendText(employeeListPage.idBox, ID);
        currentID=ID;
             }
      @And("I click search button")
      public void I_click_search_button() throws InterruptedException {
          Thread.sleep(500);
        click(employeeListPage.searchBtn);
        Thread.sleep(1000);
    }

    @Then("I should be able to see {string} on the table")
    public void I_should_be_able_to_see__on_table(String ID){
        String idTextOnTable= employeeListPage.idOnTable.getText();
        Assert.assertTrue("ID number you searched is not on the list", idTextOnTable.equals(currentID));
    }
    @Then("I enter  employee name {string}")
    public void I_enter_employee_name(String name) throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='ac_input inputFormatHint']")));
        employeeListPage.employeeNameTextBox.click();
        sendText(employeeListPage.employeeNameTextBox, name);
        currentName=name;
        Thread.sleep(2000);
    }

    @Then("I should be able to see the {string} on the table")
    public void I_should_be_able_to_see_name_on_table(String name) throws InterruptedException {
        Thread.sleep(1000);
        String nameTextOnTable= employeeListPage.nameOnTable.getText();
        Assert.assertTrue("The name you searched is not on the list", nameTextOnTable.contains(currentName));

     }


              @When("I add employee")
    public void I_add_employee(DataTable employeeDetails){


        List<Map<String, String>> listOfEmployee= employeeDetails.asMaps();
        for(Map<String, String> employeeDetail: listOfEmployee){

            sendText (addEmployeePage.firstNameTextBox, employeeDetail.get("FirstName"));
            sendText(addEmployeePage.middleNameTextbox, employeeDetail.get("MiddleName"));
            sendText(addEmployeePage.lastNameTextbox, employeeDetail.get("LastName"));
        }
  //bu senario 3 kez loop olacak save e absmadan degisecek.
    }

    @And ("I click on Edit")
    public void I_click_on_Edit(){

        click(personalDetailsPage.editSaveBtn);
    }

    @Then ("I am able to modify Employee details")
    public void I_am_able_to_modify_Employee_details(DataTable detailsOfEmps){

        List<Map<String,String>> listDetailsOfEmps=  detailsOfEmps.asMaps();
        for (Map<String,String> empDetail:listDetailsOfEmps) {
            sendText(personalDetailsPage.driversLicenceNo,empDetail.get("DriversLicence"));
            sendText(personalDetailsPage.dob,  empDetail.get("DOB"));
            sendText(personalDetailsPage.ssn, empDetail.get("SSN"));
            sendText(personalDetailsPage.sin, empDetail.get("SIN"));

//            em
//            switch ()

            String maritalStatus= empDetail.get("MaritalStatus");
            selectFromDropDown(personalDetailsPage.maritalSelect, maritalStatus);

            String nationality= empDetail.get("Nationality");
            personalDetailsPage.nationalitySelect.sendKeys(nationality);
        }
    }

    @And("I click editSave btn")
    public void I_click_editSave_btn(){
        click(personalDetailsPage.editSaveBtn);
    }


}