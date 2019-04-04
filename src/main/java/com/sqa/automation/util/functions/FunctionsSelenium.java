/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.util.functions;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

/**
 *
 * @author SQA
 */
public class FunctionsSelenium {

    WebDriver driver;

    public FunctionsSelenium(WebDriver driver) {
        this.driver = driver;

    }

    public void takeScreenshot(WebDriver driver) {

        
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
// Now you can do whatever you need to do with it, for example copy somewhere
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshot.png"));

        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }

    }

}
