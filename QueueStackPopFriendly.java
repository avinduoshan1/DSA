import java.util.Stack;

public class QueueStackPopFriendly {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Pop friendly: Ensure oldest element is always at top of s1
    // Push operation is costly: O(n)
    public void enqueue(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Pop is O(1)
    public int dequeue() {
        if (s1.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return s1.pop();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly q = new QueueStackPopFriendly();
        q.enqueue(1);
        q.enqueue(2);
        System.out.println(q.dequeue()); // Output: 1
    }
}