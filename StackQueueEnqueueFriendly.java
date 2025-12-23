import java.util.LinkedList;
import java.util.Queue;

public class StackQueueEnqueueFriendly {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Enqueue friendly: O(1)
    public void push(int x) {
        q1.add(x);
    }

    // Pop is costly: O(n)
    public int pop() {
        if (q1.isEmpty()) return -1;

        // Leave one element in q1 and move rest to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        int poppedValue = q1.remove();

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedValue;
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly s = new StackQueueEnqueueFriendly();
        s.push(10);
        s.push(20);
        System.out.println(s.pop()); // Output: 20
    }
}