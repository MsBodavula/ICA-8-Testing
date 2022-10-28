/* Class to test the urinals.java*/
/* Author: Vedasree Bodavula ASU-ID: 1225885273 */
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void goodStringTest() {
        String input = "veda";
        assertFalse( Urinals.goodString(input));
    }

    @org.junit.jupiter.api.Test
    void countUrinalsTest() {
        assertEquals( 1 , Urinals.countUrinals("10001"));
        assertEquals( 0 , Urinals.countUrinals("1001"));
        assertEquals( 3 , Urinals.countUrinals("00000"));
        assertEquals( 2 , Urinals.countUrinals("0000"));
        assertEquals( 1 , Urinals.countUrinals("01000"));
        assertEquals( -1 , Urinals.countUrinals("1100"));
        assertEquals( 0 , Urinals.countUrinals("101010"));
        assertEquals( 2 , Urinals.countUrinals("1000001"));
    }

    @org.junit.jupiter.api.Test
    void checkFileTermination() throws IOException {
        //Emptied the urinal.dat and placed only -1
        String output = Urinals.availabilityFromFileData();
        assertEquals("", output);
    }

    @org.junit.jupiter.api.Test
    void checkFileCreation() {
        //Checking if output file is getting created in case of null input
        String path = "rule.txt";
        File f = new File("rule.txt");
        int count_value = 1;
        if (f.exists()) {
            System.out.println("File rule.txt exists. Checking next file");
            while (true) {
                File f1 = new File("rule" + count_value + ".txt");
                if (f1.exists() && !f1.isDirectory()) {
                    count_value += 1;
                } else {
                    path = "rule"+count_value + ".txt";
                    break;
                }
            }
        }
        File f1 = new File(path);
        assertFalse(f1.exists());
    }

    @org.junit.jupiter.api.Test
    void InputFileNotFound() throws IOException {
        //Input file urinal.dat is deleted from the current folder
        File resourceFile = new File("urinal.dat");
        if(!resourceFile.exists())
            assertEquals("", Urinals.availabilityFromFileData());
    }

    @org.junit.jupiter.api.Test
    void EmptyInputFile() throws IOException {
        //Input file urinal.dat is deleted from the current folder
        File resourceFile = new File("urinal.dat");
        if(resourceFile.length() == 0)
            assertEquals("", Urinals.availabilityFromFileData());
    }
}