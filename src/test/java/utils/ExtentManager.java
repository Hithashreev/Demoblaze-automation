package utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {

	private static ExtentReports extent;

    /*public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("extent-report.html");
        }
        return extent;
    }*/

    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
        reporter.config().setReportName("DemoBlaze Automation Report");
        reporter.config().setDocumentTitle("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Hitha");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }

	public static ExtentReports getInstance() {
		// TODO Auto-generated method stub
	     if (extent == null) {
	            createInstance("extent-report.html");
	        }
	        return extent;
	    }
		
		//return null;
	}
	
