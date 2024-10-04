package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(features = {"classpath:features"},
                 glue = {"stepDefinitions"},
                monochrome = true, dryRun = false,
                tags = "",
                plugin =  {"pretty", "html:target/cucumber_reports.html", "json:target/cucumber_reports3.json"})
public class MainRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
