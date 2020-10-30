package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    private Queue<PrintJob> queue;

    @BeforeEach
    void setUp() { queue = new PriorityQueue();
    }

    @Test
    void enqueue() {
        queue.enqueue(new PrintJob("nome1", PrintJob.Priority.LOW, 3));
        queue.enqueue(new PrintJob("nome2", PrintJob.Priority.HIGH, 3));
        int result = 2;
        assertEquals(result, queue.size());
    }

    @Test
    void dequeue() {
        queue.enqueue(new PrintJob("nome1", PrintJob.Priority.LOW, 3));
        queue.enqueue(new PrintJob("nome2", PrintJob.Priority.HIGH, 3));
        queue.enqueue(new PrintJob("nome3", PrintJob.Priority.NORMAL, 3));
        queue.enqueue(new PrintJob("nome4", PrintJob.Priority.HIGH, 3));
        /*String result = "nome2";
        assertEquals(result, queue.dequeue().getName());
        result = "nome4";
        assertEquals(result, queue.dequeue().getName());*/
        String result = "nome3";
        assertEquals(result, queue.dequeue().getName());
    }

    @Test
    void front() {
        queue.enqueue(new PrintJob("nome1", PrintJob.Priority.LOW, 3));
        String result = "nome1";
        assertEquals(result, queue.dequeue().getName());

        queue.enqueue(new PrintJob("nome2", PrintJob.Priority.HIGH, 3));
        result = "nome2";
        assertEquals(result, queue.dequeue().getName());

        queue.enqueue(new PrintJob("nome3", PrintJob.Priority.NORMAL, 3));
        result = "nome2";
        assertEquals(result, queue.dequeue().getName());

        queue.enqueue(new PrintJob("nome4", PrintJob.Priority.HIGH, 3));
        queue.enqueue(new PrintJob("nome5", PrintJob.Priority.HIGH, 3));
        result = "nome2";
        assertEquals(result, queue.dequeue().getName());

    }

    @Test
    void size() {
        Integer result = 0;
        assertEquals(result, (Integer) queue.size());
        queue.enqueue(new PrintJob("nome1", PrintJob.Priority.LOW, 3));
        result = 1;
        assertEquals(result, (Integer) queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty(), "stack is not empty");
        queue.enqueue(new PrintJob("nome5", PrintJob.Priority.HIGH, 3));
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() {
        queue.enqueue(new PrintJob("nome5", PrintJob.Priority.HIGH, 3));
        queue.enqueue(new PrintJob("nome3", PrintJob.Priority.NORMAL, 3));
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueThrow() {
        assertThrows(EmptyQueueException.class, () -> queue.dequeue(), "The queue is empty.");
    }

    @Test
    void testFrontThrow() {

        assertThrows(EmptyQueueException.class, () -> queue.front(), "The queue is empty.");
    }
}