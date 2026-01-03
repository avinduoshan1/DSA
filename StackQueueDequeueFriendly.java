import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Enqueue operation (Costly: O(n))
    // To make dequeue O(1), we ensure the oldest element is always at the top of s1.
    public void enqueue(int x) {
        // Move all elements from s1 to s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // Push item into s1
        s1.push(x);

        // Push everything back to s1
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Dequeue operation (Friendly/Efficient: O(1))
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.pop();
    }

    // Peek operation
    public int peek() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        StackQueue q = new StackQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Dequeued: " + q.dequeue()); // Should print 10
        System.out.println("Peek: " + q.peek());       // Should print 20
        System.out.println("Dequeued: " + q.dequeue()); // Should print 20
    }
}