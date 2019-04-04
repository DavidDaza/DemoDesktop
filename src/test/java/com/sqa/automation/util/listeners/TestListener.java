package com.sqa.automation.util.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.sqa.automation.test.SetupTest;
import com.sqa.automation.util.ExtentManager;
import com.sqa.automation.util.ExtentTestManager;
import com.sqa.automation.util.functions.ActionGui;
import static com.sqa.automation.util.functions.LogInfo.getDescripcionPaso;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 * @author SQA
 */
public class TestListener extends SetupTest implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    private static String getTestStringDescriptions(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Before starting all tests, below method runs.
    @Override
    public void onStart(ITestContext iTestContext) {

        iTestContext.setAttribute("WebDriver", this.driver);

    }

    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {

        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

        //Extentreports log operation for passed tests.   
        ActionGui ac = new ActionGui();
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Caso exitoso.",
                ExtentTestManager.getTest().addBase64ScreenShot("data:image/png;base64," + ac.captureImageBase64()));
        //Take base64Screenshot screenshot.
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.INFO, "Caso exitoso.", getDescripcionPaso());
       
//        
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        ActionGui ac = new ActionGui();

        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Caso fallido.",
                ExtentTestManager.getTest().addBase64ScreenShot("data:image/png;base64," + ac.captureImageBase64()));
        //Take base64Screenshot screenshot.
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.INFO, "Caso fallido", getDescripcionPaso());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

}
