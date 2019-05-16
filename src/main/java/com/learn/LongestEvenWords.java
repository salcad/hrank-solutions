package com.learn;

import java.util.Arrays;

public class LongestEvenWords {


    private static String longestEvenWords(String sentence)
    {

        String[] words = sentence.split(" ");
        final int[] i = {0};
        final int[] len = {-1};

        final String[] longestWord = {""};

        /*

        for (String word:words)
        {
            if (word.length()%2==0)
            {
                i[0] = word.length();
                if (len[0] < i[0]) {
                    len[0] = i[0];
                    longestWord[0] = word;
                }
            }
        }

        */

        Arrays.stream(words)
                .forEach(word -> {
                    if (word.length()%2==0)
                    {
                        i[0] = word.length();
                        if (len[0] < i[0]) {
                            len[0] = i[0];
                            longestWord[0] = word;
                        }
                    }});

        if (longestWord[0].length()==0)
        {
            return "00";
        }

        return longestWord[0];
    }

    public static void main(String[] args)
    {
        System.out.println(longestEvenWords("Write code for a great time"));
    }


}
