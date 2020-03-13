package org.example.data;

import java.util.*;
import java.util.stream.Stream;

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

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue( Map<K, V> map )
    {
        Map<K,V> result = new LinkedHashMap<>();
        Stream<Map.Entry<K,V>> st = map.entrySet().stream();

        st.sorted(Comparator.comparing(e -> e.getValue()))
                .forEach(e ->result.put(e.getKey(),e.getValue()));

        return result;
    }
}
