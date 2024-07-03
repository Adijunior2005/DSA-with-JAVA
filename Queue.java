class Queue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueArray;
    private int currentSize;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Enqueue an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
    }

    // Dequeue an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue");
            return -1; // Return an error value or handle appropriately
        }
        int value = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return value;
    }

    // Peek the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek");
            return -1; // Return an error value or handle appropriately
        }
        return queueArray[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Print the queue elements
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements are:");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[(front + i) % maxSize] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printQueue();

        System.out.println("Front element is: " + queue.peek());

        queue.dequeue();
        queue.printQueue();

        System.out.println("Queue is empty: " + queue.isEmpty());
        System.out.println("Queue is full: " + queue.isFull());
    }
}
