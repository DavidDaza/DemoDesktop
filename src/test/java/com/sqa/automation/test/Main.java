/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.test;

import java.util.ArrayList;
import java.util.List;
import org.testng.TestNG;

/**
 *
 * @author SQA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> file = new ArrayList<String>();
        file.add(System.getProperty("user.dir") + "\\TestNG.xml");
        TestNG testNG = new TestNG();
        testNG.setTestSuites(file);
        testNG.run();
    }

}
