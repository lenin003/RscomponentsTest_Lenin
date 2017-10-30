import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:End2EndTests.feature","classpath:SearchTests.feature"}
)
public class rsTestRunner {
}
