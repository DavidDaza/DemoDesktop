/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.test;

import com.sqa.automation.pages.Home;

import com.sqa.automation.util.ExtentTestManager;
import com.sqa.automation.util.functions.FunctionsSelenium;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author SQA
 */
public class AdherenceTest extends SetupTest {

    Home home;

    @Test(priority = 0)
    public void loginTest() {

        home = new Home(actionDesktop, actionGui);
        home.login();

    }

    @Test(priority = 1)
    public void navegationTest() {

        home = new Home(actionDesktop, actionGui);

        home.menu();

    }

    @Test(priority = 2)
    public void ValidateProcedure() {

        home = new Home(actionDesktop, actionGui);

        Assert.assertNotEquals("", home.validacionCampos());
    }

    @Test(priority = 3)
    public void clouseAS400() {

        home = new Home(actionDesktop, actionGui);
        home.clouseApp();

    }

}
