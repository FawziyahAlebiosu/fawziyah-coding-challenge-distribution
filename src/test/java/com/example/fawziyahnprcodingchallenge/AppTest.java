package com.example.fawziyahnprcodingchallenge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * Unit test for emailValidator algorithm
 */
public class AppTest 
{
    
     // @throws IOException
     
    @Test
    public void happyCase() throws IOException
    {
        String pathtoInput = "/Users/mac001/Desktop/main/src/main/java/com/example/fawziyahnprcodingchallenge/input.txt";
        emailValidator sortingObject = new emailValidator(pathtoInput);
        emailValidator.run(sortingObject);
        String correctOutput = "/Users/mac001/Desktop/main/src/test/java/com/example/fawziyahnprcodingchallenge/happyCorrectFile.txt";
        assertLines(pathtoInput, correctOutput);
    }

    public static void assertLines(String pathExpected, String pathActual) throws IOException {
        String expectedLine ;
        BufferedReader expected = new BufferedReader(new FileReader(pathExpected));
          BufferedReader actual = new BufferedReader(new FileReader(pathActual));
      
          while ((expectedLine = expected.readLine()) != null) {
          String actualLine = actual.readLine();
          assertNotNull("Expected had more lines then the actual.", actualLine);
          assertEquals(expectedLine, actualLine);
        }
        assertNull("Actual had more lines then the expected.", actual.readLine());
        expected.close();
        actual.close();
}
@Test
    public void edgeCaseEmpty() throws IOException{
        String pathtoInput ="/Users/mac001/Desktop/main/src/test/java/com/example/fawziyahnprcodingchallenge/emptyInput.txt";
        emailValidator sortingObject = new emailValidator(pathtoInput);
        emailValidator.run(sortingObject);
        String correctOutput = "/Users/mac001/Desktop/main/src/test/java/com/example/fawziyahnprcodingchallenge/edgeCaseCorrectFile.txt";
        assertLines(pathtoInput, correctOutput);
    }

}
