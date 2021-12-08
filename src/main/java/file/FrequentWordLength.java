package file;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FrequentWordLength {
    private int mostFreqWordLen;
    private ArrayList<Integer> locationOfWordLengths;

}
