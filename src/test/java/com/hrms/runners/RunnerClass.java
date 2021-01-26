package com.hrms.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
        glue = "com/hrms/stepDefinitions",
        dryRun = false
        ,plugin = {"pretty", "html:target/html/cucumberHtmlReport.html", "json:target/cucumber.json"}  ,
        monochrome = false
        ,tags= "@dataTable"
)
        //feature is theoutline, glue tells me the path to the implementation file(step definitions)
//dryRun tells me which steps are implemented
public class RunnerClass {
}
