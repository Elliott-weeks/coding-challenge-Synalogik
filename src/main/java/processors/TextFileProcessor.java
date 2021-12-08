package processors;

import file.FileStats;
import file.FrequentWordLength;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import readers.TextFileReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextFileProcessor {

    private TextFileReader reader = new TextFileReader();


    public FileStats processContent(String content) {
        FileStats fs = new FileStats();
        String[] words = content.split("\\s+");
        fs.setWordCount(words.length);
        fs.setWordsLengths(countWordsInString(words));
        fs.setAvgWordLength(getAverageWordLength(fs.getWordsLengths(), fs.getWordCount()));
        fs.setFrequentWordLength(getMostFrq(fs.getWordsLengths()));
        return fs;
    }

    private String processWord(String word) {
        String[] punctuation = {"!", ",", ".", "?", ":", ";", "(", ")", "'", "*"}; // assumption made dash counts as a word length
        for (String punc : punctuation
        ) {
            word = word.replace(punc, "");

        }
        return word;
    }

    private HashMap<Integer, Integer> countWordsInString(String[] words) {
        HashMap<Integer, Integer> map = new HashMap();

        for (String word :
                words) {
            int wordLength = processWord(word).length();

            if (map.containsKey(wordLength)) {
                map.put(wordLength, map.get(wordLength) + 1);
            } else {
                map.put(wordLength, 1);
            }

        }
        return map;


    }

    private double getAverageWordLength(HashMap<Integer, Integer> map, int wordCount) {
        double average = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            average = average + (key * value);
        }

        return average / wordCount;


    }

    private FrequentWordLength getMostFrq(HashMap<Integer, Integer> map) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxValue = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value == maxValue) {
                list.add(key);
            }
        }
        return new FrequentWordLength(maxValue, list);

    }


}
