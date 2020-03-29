package org.example.helper;

import org.example.view.SonnetsTaskView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class InputHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputWord() {
        while (true) {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static int inputNumber(SonnetsTaskView view, ResourceBundle bundle){
        while (true) {
            try {
                return Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                view.printlnMessage(bundle.getString("incorrectInput"));
            } catch (NumberFormatException e) {
                view.printlnMessage(bundle.getString("incorrectInputFormat"));
            }
        }
    }
}
