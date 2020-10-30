package pt.pa.adts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueLinkedListTest {
    private Queue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueLinkedList();
    }

    @Test
    void enqueue() {
        queue.enqueue(5);
        queue.enqueue(6);
        Integer result = 5;
        assertEquals(result, (Integer) queue.front());
        result = 5;
        assertEquals(result, (Integer) queue.front());
    }

    @Test
    void dequeue() {
        queue.enqueue(5);
        queue.enqueue(6);
        Integer result = 5;
        assertEquals(result, (Integer) queue.dequeue());
        result = 6;
        assertEquals(result, (Integer) queue.dequeue());
    }

    @Test
    void front() {
        queue.enqueue(5);
        Integer result = 5;
        assertEquals(result, (Integer) queue.front());
    }

    @Test
    void size() {
        Integer result = 0;
        assertEquals(result, (Integer) queue.size());
        queue.enqueue(5);
        result = 1;
        assertEquals(result, (Integer) queue.size());
    }

    @Test
    void isEmpty() {
        assertTrue(queue.isEmpty(), "stack is not empty");
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
    }

    @Test
    void clear() {
        queue.enqueue(5);
        queue.enqueue(6);
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