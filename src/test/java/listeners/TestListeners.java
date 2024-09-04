package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("""
                On test start: %s""", result.getName());
        FileManager.deletePreviousEvidence();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("""
                Test Passed""");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("""
                Test Failure""");
        FileManager.getScreenshot(result.getName());
        FileManager.getPageSource(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("""
                Test Skipped""");
    }
}
