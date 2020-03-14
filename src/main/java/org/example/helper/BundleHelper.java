package org.example.helper;

import java.util.Locale;
import java.util.ResourceBundle;

public class BundleHelper {
    private static ResourceBundle bundle = ResourceBundle.getBundle("messages");

    private BundleHelper(){}

    public static ResourceBundle getBundle(){
        return bundle;
    }

    public static ResourceBundle setEnBundle(){
        bundle = ResourceBundle.getBundle("messages", new Locale("en"));
        return bundle;
    }
    public static ResourceBundle setUaBundle(){
        bundle = ResourceBundle.getBundle("messages", new Locale("ua"));
        return bundle;
    }
}
