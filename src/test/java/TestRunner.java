import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json", "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, features = "src/test/resources/features/DemoAPIAutomation.feature",glue = "steps")
public class TestRunner {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("C:/Projects/RestAssured+Cucumber+Azure/extent-config.xml"));

    }
}
