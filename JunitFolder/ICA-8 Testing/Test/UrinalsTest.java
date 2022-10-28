import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    void goodString() {
        String input = "veda";
        assertEquals(false, Urinals.goodString(input));
    }
}