package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import generic_utility.JavaUtility;
import org.testng.annotations.BeforeSuite;

public class AdvanceReport {
    ExtentReports extentReports;
   // @BeforeSuite
    public void reportConfig(){

        ExtentSparkReporter spark = new ExtentSparkReporter("./reports/"+ JavaUtility.getCurrentDateTime()+".html");
        ExtentSparkReporterConfig config = spark.config();
        config.setReportName("Vtiger Report");
        config.setDocumentTitle("Vtiger");
        config.setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(spark);
        //extentReports.createTest()
    }
}
