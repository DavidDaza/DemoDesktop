/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.util.functions;

/**
 *
 * @author SQA
 */
public class LogInfo {

    static String descripcionPaso="";
    static String conglomeradoInfo;

    public LogInfo() {
        descripcionPaso += "";

    }

    public static String getDescripcionPaso() {
        return descripcionPaso;
    }

    public static void clearVar(){
        descripcionPaso="";
    }
    public static void setDescripcionPaso(String descripcionPaso) {
        LogInfo.descripcionPaso += descripcionPaso;
    }

    public static String getConglomeradoInfo() {
        return conglomeradoInfo;
    }

    public static void setConglomeradoInfo(String conglomeradoInfo) {
        LogInfo.conglomeradoInfo += conglomeradoInfo;
    }
    
    
    public void contructor()
    {
        
    }

}
