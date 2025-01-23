
class Queue {
    private int data[];
    private int size;
    private int front;
    private int rear;

    Queue() {
        data = new int[5];
        size = 0;
        front = -1;
        rear = -1;
    }

    Queue(int capacity) {
        data = new int[capacity];
        size = 0;
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int elem) throws QueueFullException {
        if (size == data.length) {
            throw new QueueFullException();
        }
        if (size == 0) {
            front++;
            data[front] = elem;
        }

        rear++;
        data[rear] = elem;

        size++;
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int elem = data[front];
        front++;
        size--;
        return elem;
    }

}

class QueueUsingArray {
    public static void main(String[] args) throws QueueEmptyException, QueueFullException {
        Queue queue = new Queue();
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty:" + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty:" + queue.isEmpty());
        System.out.println("Element at front:" + queue.front());
        queue.dequeue();
        System.out.println("Size: " + queue.size());
        System.out.println("Is empty:" + queue.isEmpty());
        System.out.println("Element at front:" + queue.front());
    }

}

class QueueEmptyException extends Exception {

}

class QueueFullException extends Exception {

}
