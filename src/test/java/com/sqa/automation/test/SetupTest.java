package com.sqa.automation.test;

import com.sqa.automation.util.functions.ActionDesktop;
import com.sqa.automation.util.functions.ActionGui;
import com.sqa.automation.util.functions.FunctionsSelenium;
import com.sqa.automation.util.functions.Util;
import static com.sqa.automation.util.functions.Util.killProcess;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 *
 * @author SQA
 */
public class SetupTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public ActionDesktop actionDesktop;
    public ActionGui actionGui;
    public boolean isOpen;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() {
        String[] service = {"Winium.Desktop.Driver.exe", "tn5250.exe"};
        killProcess(service);
        actionDesktop = new ActionDesktop();
        actionGui = new ActionGui();
        actionDesktop.iniciarApp("C:\\Program Files (x86)\\MochaSoft\\Mocha TN5250 for Vistass\\tn5250.exe", System.getProperty("user.dir") + "\\Winium.Desktop.Driver.exe");
        actionDesktop.espera(2);
//        util.frontApp("tn5250");
    }

    @AfterClass
    public void teardown() {
//        driver.quit();

    }
}
