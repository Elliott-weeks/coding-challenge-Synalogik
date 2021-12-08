package file;

import lombok.*;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileStats {
    private int wordCount;
    private double avgWordLength;
    private HashMap<Integer, Integer> wordsLengths;
    private FrequentWordLength frequentWordLength;


}
