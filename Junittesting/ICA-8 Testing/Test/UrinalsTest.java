import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void goodStringTest() {
        String input = "veda";
        assertEquals(false, Urinals.goodString(input));
    }

    @org.junit.jupiter.api.Test
    void countUrinalsTest() {
        assertEquals( 1 , Urinals.countUrinals("10001"));
        assertEquals( 0 , Urinals.countUrinals("1001"));
        assertEquals( 3 , Urinals.countUrinals("00000"));
        assertEquals( 2 , Urinals.countUrinals("0000"));
        assertEquals( 1 , Urinals.countUrinals("01000"));
    }

    @org.junit.jupiter.api.Test
    void checkFileTermination() throws IOException {
        //Emptied the urinal.dat and placed only -1
        String output = Urinals.availabilityFromFileData();
        assertEquals("", output);
    }


}