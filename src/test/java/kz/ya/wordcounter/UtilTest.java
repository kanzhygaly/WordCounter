package kz.ya.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author YERLAN
 */
public class UtilTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    
    private Util utilInstance;
    
    @Before
    public void setUp() {
        utilInstance = new Util();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFilePath method, of class Util.
     * 
     * @throws kz.ya.wordcounter.ArgsIsEmptyException
     */
    @Test
    public void testGetFilePath() throws ArgsIsEmptyException {
        System.out.println("getFilePath");
        
        String[] args = {"file.txt"};
        String expResult = "file.txt";
        String result = utilInstance.getFilePath(args);
        assertEquals(expResult, result);
        
        String[] args2 = {};
        thrown.expect(ArgsIsEmptyException.class); // test for exception
        utilInstance.getFilePath(args2);
    }

    /**
     * Test of getWordCount method, of class Util.
     * 
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testGetWordCount() throws FileNotFoundException, IOException {
        System.out.println("getWordCount");
        
        File file = tempFolder.newFile("temp.txt");
        List<String> lines = Arrays.asList("as opposed to using 'Content here, content here', making it look like",
                "readable English. Many desktop publishing packages and web page");
        Files.write(file.toPath(), lines, Charset.forName("UTF-8"));
        
        int expResult = 21;
        int result = utilInstance.getWordCount(file);
        assertEquals(expResult, result);
        
        file = new File("fakePath");
        thrown.expect(FileNotFoundException.class); // test for exception
        utilInstance.getWordCount(file);
    }
}
