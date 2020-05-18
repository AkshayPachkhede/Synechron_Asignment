package stepDefinations;

import cucumber.api.Scenario;
import extentReporter.CustomExtentReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class GeneralHooks {
	
	private static CustomExtentReporter customextentreporter;
	private static boolean isReportRunning;
	
	@Before
	public void beforeScenario(Scenario scenario) {
		if(!isReportRunning) {
			customextentreporter = new CustomExtentReporter("src/test/resources/Report.html");
			isReportRunning = true;
		}
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		customextentreporter.createTest(scenario);
		customextentreporter.writeToReport();
	}
	
	
}
