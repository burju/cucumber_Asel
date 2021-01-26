package com.hrms.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ="src/test/resources/features" ,
        glue= "com/hrms/stepDefinitions",
        dryRun= false,
        plugin = {"pretty", "html:target/html.cucumber-default-report.html", "json:target/cucumber-sprint1.json"}
        ,tags= "@sprint1"

)
public class Sprint1Runner {
}
