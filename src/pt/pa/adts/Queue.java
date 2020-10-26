package pt.pa.adts;

/**
 * This interface is intended to simulate a queue with the "First In First Out" (FIFO) policy
 * @param <T> type of elements to be inserted in the queue
 */
public interface Queue<T> {
    /**
     * Insert an elemnt in queue
     * @param element
     * @throws FullQueueException
     */
    public void enqueue(T element) throws FullQueueException;

    /**
     * Retira e devolve o  primeiro elemento da queue
     * @return T
     * @throws EmptyQueueException
     */
    public T dequeue() throws EmptyQueueException;

    /**
     * Retorna o primeiro elemento da queue
     * @return T
     * @throws EmptyQueueException
     */
    public T front() throws EmptyQueueException;

    /**
     * Retorna um int com a informação do tamanho da queue
     * @return int
     */
    public int size();

    /**
     * Retorna o valor verdadeiro se a queue estiver vazia e falso se tiver 1 ou mais elementos
     * @return boolean
     */
    public boolean isEmpty();

    /**
     * Elimina todos os elementos da queue.
     */
    public void clear();

}
