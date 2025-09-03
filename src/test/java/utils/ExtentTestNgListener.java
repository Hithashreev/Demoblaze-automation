package utils;
import com.aventstack.extentreports.Status;
import org.testng.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import base.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
public class ExtentTestNgListener extends BaseTest implements ITestListener  {
	
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
	    private static ExtentReports extent = ExtentManager.getInstance();

	    @Override
	    public void onTestStart(ITestResult result) {
	    	 log.info("Starting test: " + result.getMethod().getMethodName());
	        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
	        testThread.set(test);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	log.info("Test PASSED: " + result.getMethod().getMethodName());
	        testThread.get().log(Status.PASS, "Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	log.error("Test FAILED: " + result.getMethod().getMethodName(), result.getThrowable());
	        testThread.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

	        // Capture screenshot
	        String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
	        testThread.get().addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	log.warn("Test SKIPPED: " + result.getMethod().getMethodName());
	        testThread.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }

	    private String takeScreenshot(String methodName) {
	        //String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    	String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
	    	
	    	String path = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + timestamp + ".png";

	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File(path);
	        try {
	            Files.createDirectories(destFile.getParentFile().toPath());
	            Files.copy(srcFile.toPath(), destFile.toPath());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return path;
	    }
}
