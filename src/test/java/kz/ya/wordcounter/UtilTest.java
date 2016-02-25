package kz.ya.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedHashMap;
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
        List<String> lines = Arrays.asList("using 'Content here, content here',", "making it look like");
        Files.write(file.toPath(), lines, Charset.forName("UTF-8"));
        
        LinkedHashMap<String, Integer> expResult = new LinkedHashMap<>();
        expResult.put("using", 1);
        expResult.put("content", 2);
        expResult.put("here", 2);
        expResult.put("making", 1);
        expResult.put("it", 1);
        expResult.put("look", 1);
        expResult.put("like", 1);
        
        LinkedHashMap<String, Integer> result = utilInstance.getWordCount(file);
        assertEquals(expResult.size(), result.size());
        assertTrue(expResult.equals(result));
        
        file = new File("fakePath");
        thrown.expect(FileNotFoundException.class); // test for exception
        utilInstance.getWordCount(file);
    }

    /**
     * Test of print method, of class Util.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("using", 1);
        map.put("content", 2);
        
        String expResult = "using: 1\ncontent: 2\n";
        StringBuilder result = utilInstance.format(map);
        assertEquals(expResult, result.toString());
    }
}
