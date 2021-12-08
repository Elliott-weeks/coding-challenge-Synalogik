import file.FileStats;
import processors.TextFileProcessor;
import readers.Reader;
import readers.TextFileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        TextFileProcessor tsp = new TextFileProcessor();
        if (args.length == 0) {
            System.out.println("Please provider the path to the file to process as an argument");
            System.exit(0);
        }
        String path = args[0];
        if (!new File(path).exists()) {
            throw new FileNotFoundException("Unable to locate file at the following path " + args[0]);
        }
        TextFileReader trf = new TextFileReader();

        FileStats fs = tsp.processContent(trf.readFile(path));
        System.out.println(String.format("Word count = %s", fs.getWordCount()));
        System.out.println(String.format("Average word length = %s", String.format("%.3f", fs.getAvgWordLength())));

        for (Map.Entry<Integer, Integer> entry : fs.getWordsLengths().entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(String.format("Number of words of length %s is %s", key, value));
        }

        String valuesAt = fs.getFrequentWordLength().getLocationOfWordLengths().toString().replace("[", "").replace("]", "").replace(",", " &");
        System.out.println(String.format("The most frequently occurring word length is %s, for word lengths of %s", fs.getFrequentWordLength().getMostFreqWordLen(), valuesAt));


    }
}
