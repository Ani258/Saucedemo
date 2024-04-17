package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	    features={"resources\\Features\\SauceLab.feature"},
	        glue={"stepdefinition"}
	   // ,plugin= {"pretty","html:target/Saucedemo_report.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
		)

public class Run_Saucedemo {

}
