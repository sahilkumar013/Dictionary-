package com.example.dictionary12nov;

import java.util.HashMap;
import java.util.Map;

public class DictionaryUsingHashMap {
    private HashMap<String,String>dictionary;
    public DictionaryUsingHashMap(){
        dictionary = new HashMap<String,String>();
        addListofWord();
    }

    public boolean addWord(String word,String meaning){
        dictionary.put(word,meaning);
        return true;
    }

    public  String[] getSuggestions(String word){
        String[] suggestions = new String[5];
        int i =0;
        for(Map.Entry<String,String>entry : dictionary.entrySet()){
            int lastIndex = Math.min(word.length(),entry.getKey().length());
            if(word.compareTo(entry.getKey().substring(0,lastIndex)) == 0){
                suggestions[i++] = entry.getKey();
            }
            if(i == 4)break;
        }
        return suggestions;
    }

    public  String findMeaning(String word){
        if(!dictionary.containsKey(word)){
            return "Given word not found";
        }
        else return  dictionary.get(word);
    }

    private  void addListofWord(){
        addWord("aaashubh","Auspicious");
        addWord("aaaPredicament","Situation");
        addWord("aaaweeping","crying");
        addWord("project","An application to do something");
    }
}



