package pt.pa.adts;

/**
 * TODO: Fornecer documentação da classe.
 *
 * @param <T>
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header; //início da fila
    private Node trailer; //fim da fila
    private int size; //Quantidade de elementos na fila

    public QueueLinkedList(){
        this.header = new Node(null, null, null);
        this.trailer = new Node(null, null, null);
        this.size = 0;
    }
    @Override
    public void enqueue(T element) throws FullQueueException {
        try {
            Node newNode = new Node(element, null, null);
            if (size == 0) {
                this.header.next = newNode;
                newNode.rear = header;
            } else {
                Node temp = this.trailer.rear;
                temp.next = newNode;
                newNode.rear = temp;
                /*Node node = header;
            while(node.next != null){
                node = node.next;
            }*/
            }
            this.trailer.rear = newNode;
            newNode.next = trailer;
            size++;
        }catch (OutOfMemoryError e){
            throw new FullQueueException("no memory for more elements");
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(this.size == 0) throw new EmptyQueueException("no elements");
        T elem2Return = header.next.element;
        header.next = header.next.next;
        header.next.rear = header.next;
        size--;
        return elem2Return;
    }

    @Override
    public T front() throws EmptyQueueException {
        if(this.size == 0) throw new EmptyQueueException("no elements");
        return header.next.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        this.header.next = null;
        this.trailer.rear = null;
        size = 0;
    }

    /**
     * Inner class representing a linked list node.
     * Only recognized in the context of this class (private).
     */
    private class Node {
        private T element;
        private Node next;
        private Node rear;

        public Node(T element, Node next, Node rear) {
            this.element = element;
            this.next = next;
            this.rear = rear;
        }
    }
}
