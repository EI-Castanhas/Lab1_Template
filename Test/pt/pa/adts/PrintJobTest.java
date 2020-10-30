package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintJobTest {

    @Test
    void compareTo() {
        PrintJob pt1 = new PrintJob("1", PrintJob.Priority.LOW, 2);
        PrintJob pt2 = new PrintJob("2", PrintJob.Priority.HIGH, 2);
        Integer result = 1;
        assertEquals(result, pt1.compareTo(pt2));
    }
}