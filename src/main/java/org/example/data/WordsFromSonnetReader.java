package org.example.data;

import org.example.helper.DocumentReadHelper;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class WordsFromSonnetReader {

    private List<String> endOfUrls;

    private final String urlMainBody = "http://shakespeare.mit.edu/Poetry/";

    private WordsHandler wordsHandler;

    public WordsFromSonnetReader(WordsHandler wordsHandler){
        this.wordsHandler = wordsHandler;
    }

    public void execute(){
        endOfUrls = new ArrayList<>();
        readKeyAddressSonnet();
        for(String endOfUrl : endOfUrls)
            wordsHandler.makeMapFromUniqueWords(sonnetsReader(endOfUrl), urlMainBody + endOfUrl);
    }

    public void readKeyAddressSonnet(){
        String mainPageKey = "sonnets.html";
        Document sonnet = DocumentReadHelper.documentReader(urlMainBody + mainPageKey);
        Elements elements = sonnet.select("a[href]");
        for(Element element : elements) {
            String href = element.attributes().toString();
            endOfUrls.add(href.substring(href.indexOf('"')+1, href.length()-1));
        }
        endOfUrls.remove(0);
    }

    public String[] sonnetsReader(String urlEnd){
        Document sonnet =  DocumentReadHelper.documentReader(urlMainBody + urlEnd);
        String sonnetInString = sonnet.body().text();
       return makeArrayFromSonnetString(sonnetInString);
    }

    public String[] makeArrayFromSonnetString(String sonnet){
        sonnet = sonnet.replaceAll("[^A-Za-z']\\s", " ");
        for(int i = 0; i < 2; i++)
            sonnet = sonnet.substring(sonnet.indexOf(" ") + 1);
        sonnet = sonnet.replaceAll(".$","");
        sonnet = sonnet.toLowerCase();
        String[] words = sonnet.split(" ");
        return words;
    }
}
