package com.hrms.testBase;

import com.hrms.pages.*;

public class PageInitilizer extends BaseClass{
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static AddEmployeePage addEmployeePage;
    public static EmployeeListPage employeeListPage;
    public static PersonalDetailsPage personalDetailsPage;





    public static void initilizeAllPages(){
         loginPage=new LoginPage();
         dashboardPage= new DashboardPage();
         addEmployeePage= new AddEmployeePage();
         employeeListPage=new EmployeeListPage();
         personalDetailsPage=new PersonalDetailsPage();

    }
}
