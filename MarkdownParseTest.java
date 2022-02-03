import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test 
    public void testFile() throws IOException {

        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from test-file.md",List.of("https://something.com", "some-page.html"), links);
    }
    @Test
    public void newOne() throws IOException {
        Path fileName = Path.of("new-one.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertNotEquals("Test the links from the new-one.md", List.of("google.com"), links);
    }
    @Test
    public void newTwo() throws IOException {
        Path fileName = Path.of("new-two.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> wrong = new ArrayList<>();
        assertEquals("Test the links from the new-two.md", wrong, links);
    }
    @Test
    public void imageFirst() throws IOException {
        Path fileName = Path.of("imageFirst.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from the imagefirst.md", links, links);
    }

}
