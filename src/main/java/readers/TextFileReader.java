package readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFileReader implements Reader {

    private static final Logger log = LoggerFactory.getLogger(TextFileReader.class);

    @Override
    public String readFile(String filePath) {
        String text = "";
        try {
            text = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            log.error("Error reading file - " +  e.getMessage());
        }
        return text;
    }
}
