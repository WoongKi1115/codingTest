import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LookAndSayTest {

    @Test
    void findLn() {
        Map<Integer, String> map = new HashMap<>();

        String result1 = LookAndSay.findLn(5, map);
        assertEquals("111221", result1);

        String result2 = LookAndSay.findLn(8, map);
        assertEquals("1113213211", result2);
    }

    @Test
    void main() {
    }
}