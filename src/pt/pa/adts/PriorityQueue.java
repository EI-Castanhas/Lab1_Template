package pt.pa.adts;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {
    private Node header; //início da fila
    private Node trailer; //fim da fila
    private int size; //Quantidade de elementos na fila

    public PriorityQueue() {
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
            }
            this.trailer.rear = newNode;
            newNode.next = trailer;
            size++;
        } catch (OutOfMemoryError e) {
            throw new FullQueueException("no memory for more elements");
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.size == 0) throw new EmptyQueueException("no elements");
        Node node, aux;
        node = aux = this.trailer.rear;

        while(aux.rear.rear != null){
            aux = aux.rear;
            if(node.element.compareTo(aux.element) > 0) node = aux;
        }

        node.rear.next = node.next;
        node.next.rear = node.rear;
        this.size--;

        return (T)node.element;
    }

    @Override
    public T front() throws EmptyQueueException {
        if (this.size == 0) throw new EmptyQueueException("no elements");
        Node node, aux;
        node = aux = this.trailer.rear;

        while(aux.rear.rear != null){
            aux = aux.rear;
            if(node.element.compareTo(aux.element) > 0) node = aux;
        }
        return (T)node.element;
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
