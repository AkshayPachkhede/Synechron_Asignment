package extentReporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.Scenario;

public class CustomExtentReporter {
	
	private ExtentHtmlReporter extentHtmlReporter;
	private ExtentReports extentReports;
	
	
	public CustomExtentReporter(String reportLocation) {
		
		extentHtmlReporter = new ExtentHtmlReporter(reportLocation);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);	
	}
	
	public void createTest(Scenario scenario) {
		
		if(scenario != null) {
			String testName = getScenarioTitle(scenario);
			
			switch(scenario.getStatus()) {
			case PASSED:
				extentReports.createTest(testName).pass("Passed");
				break;
			
			case FAILED:
				extentReports.createTest(testName).fail("Failed");
				break;
			
			case SKIPPED:
				extentReports.createTest(testName).skip("Skipped");
				break;
			
			}
		}
	}
	
	public void writeToReport() {
		if(extentReports != null)
			extentReports.flush();
	}
	
	private String getScenarioTitle(Scenario scenario) {
		return scenario.getName();
	}
	
	

}
