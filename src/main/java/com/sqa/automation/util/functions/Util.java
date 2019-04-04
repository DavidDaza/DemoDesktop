/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqa.automation.util.functions;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author SQA
 */
public class Util {

    private static final String KILL = "taskkill /F /IM ";
    private static final String TASKLIST = "tasklist";
//tn5250

//    public boolean frontApp(String nameWindows) {
//        HWND hwnd = User32.INSTANCE.FindWindow(null, nameWindows);
//        // window title
//        if (hwnd == null) {
//            System.out.println("La aplicacion con el nombre: " + nameWindows + " no se encuentra.");
//            return false;
//        } else {
//            User32.INSTANCE.ShowWindow(hwnd, 9);        // SW_RESTORE
//            User32.INSTANCE.SetForegroundWindow(hwnd);   // Front app
//            return true;
//        }
//    }
     public static boolean isProcessRunning(String serviceName) throws Exception {

        Process p = Runtime.getRuntime().exec(TASKLIST);
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {

            if (line.contains(serviceName)) {
                return true;
            }
        }

        return false;

    }
    
    public static void killProcess(String[] serviceName) {

        try {
            for (int i = 0; i < serviceName.length; i++) {

                if (isProcessRunning(serviceName[i])) {
                    Runtime.getRuntime().exec(KILL + serviceName[i]);

                }
            }
        } catch (Exception e) {
        }

    }
}
