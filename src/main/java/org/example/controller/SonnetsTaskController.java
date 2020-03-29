package org.example.controller;

import org.example.data.WordsFromSonnetReader;
import org.example.data.WordsHandler;
import org.example.helper.BundleHelper;
import org.example.helper.InputHelper;
import org.example.helper.SortHelper;
import org.example.view.SonnetsTaskView;

import java.util.Map;
import java.util.ResourceBundle;


public class SonnetsTaskController {
    private WordsFromSonnetReader wordsFromSonnetReader;
    private SonnetsTaskView sonnetsTaskView;
    private WordsHandler wordsHandler;
    private ResourceBundle bundle;


    public SonnetsTaskController(){
        wordsHandler = new WordsHandler();
        wordsFromSonnetReader = new WordsFromSonnetReader(wordsHandler);
        sonnetsTaskView = new SonnetsTaskView();
        bundle = BundleHelper.getBundle();
    }

    public void launch(){
        wordsFromSonnetReader.execute();
        userSelectLanguage();
        sonnetsTaskView.printlnMessage(bundle.getString("info"));
        userInput();

    }

    public void userSelectLanguage(){
        sonnetsTaskView.printlnMessage(bundle.getString("selectLanguage"));
        switch (selectBetweenOneAndTwo()){
            case 1:
                bundle = BundleHelper.setEnBundle();
                break;
            case 2:
                bundle = BundleHelper.setUaBundle();
                break;
        }
    }

    public void userInput(){
        String input;
        boolean isEnd = false;
        while(!isEnd) {
            sonnetsTaskView.printlnMessage(bundle.getString("inputWord"));
            input = InputHelper.inputWord();
            if (wordsHandler.doesMapContainsWord(input)) {
                Map<String, Integer> parametersOfWord = wordsHandler.returnParametersOfWord(input);
                parametersOfWord = SortHelper.sortByValue(parametersOfWord);
                sonnetsTaskView.printlnMessage(bundle.getString("wordParameters") + input);
                for (Map.Entry<String, Integer> parametersEntry : parametersOfWord.entrySet()) {
                    sonnetsTaskView.printlnMessage(parametersEntry.getKey() + " : " + parametersEntry.getValue() + " " + bundle.getString("times"));
                }
            } else
                sonnetsTaskView.printlnMessage(bundle.getString("noSuchWord"));
            sonnetsTaskView.printlnMessage("");
            sonnetsTaskView.printlnMessage(bundle.getString("selectNextStep"));
            if(selectBetweenOneAndTwo() == 2){
                sonnetsTaskView.printlnMessage(bundle.getString("goodBye"));
                isEnd = true;
            }

        }
    }

    public int selectBetweenOneAndTwo(){
        while(true){
            int step = InputHelper.inputNumber(sonnetsTaskView, bundle);
            if(step == 1 || step == 2)
                return step;
            else {
                sonnetsTaskView.printlnMessage(bundle.getString("incorrectInput") + "\n" + bundle.getString("selectOneOrTwo"));

            }
        }
    }

}
