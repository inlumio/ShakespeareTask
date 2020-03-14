package org.example.data;

import java.util.*;

public class WordsHandler {

    private Map<String, Map<String, Integer>> uniqueWords;

    public WordsHandler(){
        uniqueWords = new HashMap<>();
    }

    public void makeMapFromUniqueWords(String[] sonnetWords, final String url){
        for(String word : sonnetWords){
            if(!uniqueWords.containsKey(word)){
                uniqueWords.put(word, new HashMap<String, Integer>(){{  put(url, 1);    }});
            }else{
                if(!uniqueWords.get(word).containsKey(url)) {
                    uniqueWords.get(word).put(url, 1);
                }else{
                    uniqueWords.get(word).put(url, uniqueWords.get(word).get(url)+1);
                }
            }
        }
    }

    public int getNumberOfUniqueWords(){
        return uniqueWords.size();
    }

    public boolean doesMapContainsWord(String word){
        return uniqueWords.containsKey(word);
    }

    public Map<String, Integer> returnParametersOfWord(String word){
        return uniqueWords.get(word);
    }

}
