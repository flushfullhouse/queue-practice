public class QueueADT {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int itemCount;

    public QueueADT(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        itemCount = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queueArray[++rear] = item;
        itemCount++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int data = queueArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        itemCount--;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public boolean isFull() {
        return itemCount == maxSize;
    }

    public int size() {
        return itemCount;
    }

    //Added display
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < itemCount; i++) {
            System.out.print(queueArray[(front + i) % maxSize] + " ");
        }
        System.out.println();
    }

    //testing
    public static void main(String[] args) {
        QueueADT queue = new QueueADT(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        queue.display();
    }
}