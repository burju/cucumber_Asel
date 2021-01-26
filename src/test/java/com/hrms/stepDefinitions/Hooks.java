package com.hrms.stepDefinitions;

import com.hrms.testBase.PageInitilizer;
import com.hrms.utils.CommonMethods;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.After;


public class Hooks extends CommonMethods {

    @Before
    public void start(Scenario scenario){
        System.out.println("Scenario starting" + scenario.getName());
        setUp();
        PageInitilizer.initilizeAllPages();

    }

    @After
    public void end(Scenario scenario){
        System.out.println("Ending scenario"+ scenario.getName());
        if(scenario.isFailed())
        {
            byte[] picture= takeScreenshot("/failed/"+scenario.getName());
            scenario.attach(picture, "image/png", scenario.getName());
        }
        else{
            byte[] picture= takeScreenshot("/passed/"+scenario.getName());
            scenario.attach(picture, "image/png", scenario.getName());
        }
        tearDown();
        }


}
