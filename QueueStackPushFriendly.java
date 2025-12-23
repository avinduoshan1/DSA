import java.util.Stack;

public class QueueStackPushFriendly {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Push friendly: Just push to s1 (Cost: O(1))
    public void enqueue(int x) {
        s1.push(x);
    }

    // Pop operation (Cost: O(n) in worst case)
    public int dequeue() {
        if (s2.isEmpty()) {
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly q = new QueueStackPushFriendly();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue()); // Output: 1
    }
}