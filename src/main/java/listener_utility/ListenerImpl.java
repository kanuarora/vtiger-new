package listener_utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import generic_utility.JavaUtility;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpl implements ITestListener {
    public ExtentReports report;
    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onStart(ITestContext context) {
        String time = JavaUtility.getCurrentDateTime();

        //configure Report
        ExtentSparkReporter spark = new ExtentSparkReporter("./reports/"+time+".html");
        spark.config().setDocumentTitle("Vtiger");
        spark.config().setReportName("Vtiger report");
        spark.config().setTheme(Theme.DARK);
        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("browse","chrome");

        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String methodname = result.getName();
        ExtentTest test = report.createTest(methodname);
        test.log(Status.PASS,methodname+"is passed");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String methodname = result.getName();
        ExtentTest test =report.createTest(methodname);
        test.log(Status.FAIL,methodname+"is failed");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = report.createTest(result.getName());
        test.log(Status.SKIP,result.getName()+" is skipped");
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        report.flush();
        ITestListener.super.onFinish(context);
    }
}
