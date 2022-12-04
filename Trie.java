package com.example.dictionary12nov;

public class Trie {
    static class TrieNode{
        boolean endOfWord;
        String meaning;
        TrieNode[] children;
        TrieNode(){
            endOfWord = false;
            meaning = "";
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    static TrieNode root;

    static void insert(String word, String meaning){
        TrieNode temp =root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i)-'a';
            if(temp.children[index]==null){
                temp.children[index] = new TrieNode();
            }
            temp = temp.children[index];
        }
        temp.endOfWord = true;
        temp.meaning = meaning;
    }

    static String search(String word){
        TrieNode temp = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i)-'a';
            if(temp.children[index]==null){
                return  "Word not found";

            }
            temp = temp.children[index];
        }
        // for that child find all the valid words
        //recursion to find all valid words.


        return  temp.meaning;
    }
    public static void main(String[] args){
        root = new TrieNode();
        insert("intellij","IDE to develop applications");
        insert("metal","a generally hard and shiny chemical");
        insert("car","vehicle used to travel");

        System.out.println(search("angad"));
        System.out.println(search("car"));
        System.out.println(search("metal"));
    }
    // suggestions

    // try finding the word with help of search
    //then find all valid words for children



}
