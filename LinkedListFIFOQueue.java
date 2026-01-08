public class LinkedListFIFOQueue {
    
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    // Enqueue (Insert at Rear)
    public void enqueue(int data) {
        Node newNode = new Node(data);

        // If queue is empty
        if (rear == null) {
            front = rear = newNode;
            System.out.println(data + " enqueued.");
            return;
        }

        // Add to the end
        rear.next = newNode;
        rear = newNode;
        System.out.println(data + " enqueued.");
    }

    // Dequeue (Remove from Front)
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int value = front.data;
        front = front.next;

        // If front becomes null, rear must also be null
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public static void main(String[] args) {
        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue()); // 10
        System.out.println("Dequeued: " + queue.dequeue()); // 20
    }
}