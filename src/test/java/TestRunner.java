import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by udit on 11/09/18.
 */
@CucumberOptions(
        glue = {"dummy.restapiexample.com.steps"},
        plugin = { "pretty","json:build/cucumber-reports/Cucumber.json",
                "junit:build/cucumber-reports/Cucumber.xml",
                "html:build/cucumber-reports" },
        features = "Features"
)
@RunWith(Cucumber.class)
public class TestRunner {
}
