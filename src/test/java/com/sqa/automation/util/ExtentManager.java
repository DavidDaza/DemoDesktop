/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.util;

import com.relevantcodes.extentreports.ExtentReports;

/**
 *
 * @author SQA David Daza
 */
public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir + "\\Reoport\\ReportAS400.html", false);
        }
        return extent;
    }

}
