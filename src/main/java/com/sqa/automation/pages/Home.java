/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.pages;

import com.sqa.automation.util.functions.ActionDesktop;
import com.sqa.automation.util.functions.ActionGui;
import com.sqa.automation.util.functions.LogInfo;
import static com.sqa.automation.util.functions.LogInfo.*;

/**
 *
 * @author SQA
 */
public class Home {

    public ActionDesktop actionDesktop;
    public ActionGui act;

    public Home() {
    }

    public Home(ActionDesktop actionDesktop, ActionGui actionGui) {
        this.actionDesktop = actionDesktop;
        this.act = actionGui;

    }

    public void login() {
        try {
            actionDesktop.clickId("button_real_trial");
            act.alt();
            act.fechaAbajo();
            act.enter();
            act.escape();
            act.escape();
            act.waitSeconds(6);
            act.escribirRobot("USER0022");
            act.waitSeconds(1);
            act.tab();
            act.escribirRobot("user0022");
            act.enter();
            clearVar();
            setDescripcionPaso("Ingreso exitoso, ususario:USER0022 Password:user0022");

        } catch (Exception e) {

            System.out.println("error" + e);
        }
    }

    public void menu() {

        act.waitSeconds(5);
        act.escribirRobot("WRKSPLF");
        act.enter();
        act.waitSeconds(3);
        act.escribirRobot("5");
        act.enter();
        act.waitSeconds(3);
        clearVar();
        setDescripcionPaso("Ingreso al menu 'WRKSPLF' exitoso.");

    }

    public String validacionCampos() {

        act.selectAllA();

        String texto = act.copiAllRobot();
        if (texto.contains("send_C2M1212__FPvUi")) {
            clearVar();
            setDescripcionPaso("El procedimiento <b>send_C2M1212__FPvUi</b> se encuntra en la lista</h5>");

            return texto;
        } else {
            clearVar();
            setDescripcionPaso("No se encontrò el procedimeinto <b>send_C2M1212__FPvUi</b>");
            return "";
        }

    }

    public void clouseApp() {
        try {
            act.waitSeconds(2);
            act.imprimirFuncion(12);
            act.waitSeconds(2);
            act.imprimirFuncion(12);
            act.waitSeconds(2);
            act.imprimirFuncion(12);
            actionDesktop.clickName("Cerrar");
            clearVar();
            setDescripcionPaso("Aplicacion cerrada exitosamente.");

        } catch (Exception e) {

        }

    }
  

}
