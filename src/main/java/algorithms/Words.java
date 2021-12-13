package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    private List<String> words = new ArrayList<>();

    public void addWord(String word){
        if (word.indexOf(' ')>=0) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!(word.equals(word.toLowerCase()))){
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public List<String> getWords() {
        return words;
    }

    public boolean isThereAWordTwice(){
        List<WordCounter> wordCounters = new ArrayList<>();
        for (String element: words){
            boolean found = false;
            for (WordCounter oneWord: wordCounters){
                if (oneWord.getWord().equals(element)){
                    oneWord.setNumber(oneWord.getNumber()+1);
                    found = true;
                }
            }
            if (!(found)){
                wordCounters.add(new WordCounter(element,1));
            }
        }

        for (WordCounter element: wordCounters){
            if (element.getNumber()>1) {
                return true;
            }
        }
        return false;
    }


}
