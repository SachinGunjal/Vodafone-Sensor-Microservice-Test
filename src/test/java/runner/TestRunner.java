package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"steps"},
        plugin = {"json:target/cucumber-reports/CucumberTestReport.json"},
        monochrome = true,
        publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Execution Started " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

    }
}
