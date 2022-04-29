import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

import org.junit.*;

public class MarkdownParseTest {
    private Path fileName;
    private String content;
    private ArrayList<String> links;
    private ArrayList<String> result;
    private static final String FULL_DIRECTORY = "C:\\Users\\ebuen\\OneDrive\\Documents\\GitHub\\markdown-parser-clone\\";

    @Before
    public void setup(){
        try{
            fileName = Path.of("test-file.md");
            content = Files.readString(fileName);
            links = MarkdownParse.getLinks(content);
            result = new ArrayList<>(List.of("https://something.com", "some-page.html"));
        }
        catch(IOException e){

        }

        System.out.println(content);
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest(){
        assertEquals(result, links);
    }
}