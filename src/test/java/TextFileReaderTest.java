import file.FileStats;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import readers.TextFileReader;

import java.io.File;

@DisplayName("Unit :: Reader :: Text File Reader")
public class TextFileReaderTest {


    @Test
    @DisplayName("Read in standard test file")
    public void processStandardString() throws Exception {
        TextFileReader reader = new TextFileReader();
        String contents = reader.readFile(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "example.txt" );
        Assertions.assertThat(contents).isNotNull();


    }
}

