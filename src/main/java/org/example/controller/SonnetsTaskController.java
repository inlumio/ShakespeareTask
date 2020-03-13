package org.example.controller;

import org.example.data.WordsFromSonnetReader;
import org.example.data.WordsHandler;
import org.example.view.SonnetsTaskView;

public class SonnetsTaskController {
    private WordsFromSonnetReader wordsFromSonnetReader;
    private SonnetsTaskView sonnetsTaskView;
    private WordsHandler wordsHandler;

    public SonnetsTaskController(){
        wordsHandler = new WordsHandler();
        wordsFromSonnetReader = new WordsFromSonnetReader(wordsHandler);
        sonnetsTaskView = new SonnetsTaskView();
    }

    public void launch(){
        wordsFromSonnetReader.execute();
        //wordsHandler.getNumberOfUniqueWords();


    }
}
