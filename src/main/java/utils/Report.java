package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import constants.FilePathConstants;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.lang.reflect.Method;

public class Report {
    public static ExtentReports extent;
    public static ExtentTest test;
    @BeforeSuite
    public void beforeSuite() {
        extent = new ExtentReports(FilePathConstants.REPORT_FILE_PATH);
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        test = extent.startTest((this.getClass().getSimpleName()+"::"+method.getName()),method.getName());
    }

    @AfterMethod
    public void afterMethod() {
        extent.endTest(test);
    }

    @AfterSuite
    public void afterSuite(){
        extent.flush();
        extent.close();
    }
}
