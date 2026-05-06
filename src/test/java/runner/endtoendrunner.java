package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
    features = "src/test/resources/featuresFiles/EndtoEnd.feature",
    glue = {"StepDefinitions", "Hooks"},
    dryRun = false,
    tags = "@endtoend",
    plugin = {
        "pretty",
        "html:target/endtoend-report.html"
    },
    snippets = SnippetType.CAMELCASE,
    monochrome = true
)
public class endtoendrunner extends AbstractTestNGCucumberTests {
}