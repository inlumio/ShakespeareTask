package org.example.helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DocumentReadHelper {
    public static Document documentReader(String url){
        Document sonnet = null;
        try {
            sonnet = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sonnet;
    }
}
