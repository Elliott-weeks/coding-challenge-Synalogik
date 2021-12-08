import file.FileStats;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import processors.TextFileProcessor;
import readers.Reader;
import readers.TextFileReader;

@DisplayName("Unit :: Processor :: Text File Processor")
public class TextFileProcessorTests {

    private TextFileProcessor processor  = new TextFileProcessor();

    @Test
    @DisplayName("Process standard String")
    public void processStandardString() throws Exception {
        String content = "Hello world & good morning. The date is 18/05/2016";

        FileStats file = processor.processContent(content);
        // total word count check
        Assertions.assertThat(file.getWordCount()).isEqualTo(9);
        // number of words for each length
        Assertions.assertThat(file.getWordsLengths().get(1)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(2)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(3)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(4)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(5)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(7)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(10)).isEqualTo(1);
        // average word length
        Assertions.assertThat(file.getAvgWordLength()).isEqualTo(4.555555555555555);
        // most frequent
        Assertions.assertThat(file.getFrequentWordLength().getMostFreqWordLen()).isEqualTo(2);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(0)).isEqualTo(4);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(1)).isEqualTo(5);

    }
    @Test
    @DisplayName("Process String with Brackets")
    public void processStringWithBrackets() throws Exception {
        String content = "Hello world & good (morning). The date is 18/05/2016";

        FileStats file = processor.processContent(content);
        // total word count check
        Assertions.assertThat(file.getWordCount()).isEqualTo(9);
        // number of words for each length
        Assertions.assertThat(file.getWordsLengths().get(1)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(2)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(3)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(4)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(5)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(7)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(10)).isEqualTo(1);
        // average word length
        Assertions.assertThat(file.getAvgWordLength()).isEqualTo(4.555555555555555);
        // most frequent
        Assertions.assertThat(file.getFrequentWordLength().getMostFreqWordLen()).isEqualTo(2);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(0)).isEqualTo(4);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(1)).isEqualTo(5);
    }
    @Test
    @DisplayName("Process String with Questionmark")
    public void processStringWithQuestionMark() throws Exception {
        String content = "Hello world & good morning? The date is 18/05/2016";

        FileStats file = processor.processContent(content);
        // total word count check
        Assertions.assertThat(file.getWordCount()).isEqualTo(9);
        // number of words for each length
        Assertions.assertThat(file.getWordsLengths().get(1)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(2)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(3)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(4)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(5)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(7)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(10)).isEqualTo(1);
        // average word length
        Assertions.assertThat(file.getAvgWordLength()).isEqualTo(4.555555555555555);
        // most frequent
        Assertions.assertThat(file.getFrequentWordLength().getMostFreqWordLen()).isEqualTo(2);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(0)).isEqualTo(4);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(1)).isEqualTo(5);
    }
    @Test
    @DisplayName("Process String with ExMark")
    public void processStringWithExMark() throws Exception {
        String content = "Hello world & good morning! The date is 18/05/2016";

        FileStats file = processor.processContent(content);
        // total word count check
        Assertions.assertThat(file.getWordCount()).isEqualTo(9);
        // number of words for each length
        Assertions.assertThat(file.getWordsLengths().get(1)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(2)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(3)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(4)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(5)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(7)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(10)).isEqualTo(1);
        // average word length
        Assertions.assertThat(file.getAvgWordLength()).isEqualTo(4.555555555555555);
        // most frequent
        Assertions.assertThat(file.getFrequentWordLength().getMostFreqWordLen()).isEqualTo(2);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(0)).isEqualTo(4);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(1)).isEqualTo(5);
    }

    @Test
    @DisplayName("Process String with Elipse")
    public void processStringWithElipse() throws Exception {
        String content = "Hello world & good morning.... The date is 18/05/2016";

        FileStats file = processor.processContent(content);
        // total word count check
        Assertions.assertThat(file.getWordCount()).isEqualTo(9);
        // number of words for each length
        Assertions.assertThat(file.getWordsLengths().get(1)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(2)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(3)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(4)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(5)).isEqualTo(2);
        Assertions.assertThat(file.getWordsLengths().get(7)).isEqualTo(1);
        Assertions.assertThat(file.getWordsLengths().get(10)).isEqualTo(1);
        // average word length
        Assertions.assertThat(file.getAvgWordLength()).isEqualTo(4.555555555555555);
        // most frequent
        Assertions.assertThat(file.getFrequentWordLength().getMostFreqWordLen()).isEqualTo(2);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(0)).isEqualTo(4);
        Assertions.assertThat(file.getFrequentWordLength().getLocationOfWordLengths().get(1)).isEqualTo(5);
    }

}
