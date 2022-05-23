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

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
        assertEquals(5, 2 + 3);
    }

    @Test
    public void getLinksTest(){
        try{
            fileName = Path.of(FULL_DIRECTORY + "test-file.md");
            content = Files.readString(fileName);
            links = MarkdownParse.getLinks(content);
            result = new ArrayList<>(List.of("https://something.com", "some-thing.html"));
        }
        catch(IOException e){

        }
        assertEquals(result, links);
    }

    @Test
    public void testSnippet1(){
        try{
            fileName = Path.of(FULL_DIRECTORY + "snippet1.md");
            content = Files.readString(fileName);
            links = MarkdownParse.getLinks(content);
            result = new ArrayList<>(List.of("`google.com", "google.com", "ucsd.edu"));
        }
        catch(IOException e){

        }
        assertEquals(result, links);
    }

    @Test
    public void testSnippet2(){
        try{
            fileName = Path.of(FULL_DIRECTORY + "snippet2.md");
            content = Files.readString(fileName);
            links = MarkdownParse.getLinks(content);
            result = new ArrayList<>(List.of("a.com", "a.com(())", "example.com"));
        }
        catch(IOException e){

        }
        assertEquals(result, links);
    }

    @Test
    public void testSnippet3(){
        try{
            fileName = Path.of(FULL_DIRECTORY + "snippet3.md");
            content = Files.readString(fileName);
            links = MarkdownParse.getLinks(content);
            result = new ArrayList<>(List.of("https://www.twitter.com",
                "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", "https://cse.ucsd.edu/"));
        }
        catch(IOException e){

        }
        assertEquals(result, links);
    }
}