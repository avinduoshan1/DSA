public class UnboundedArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2; // Initial small capacity
        stack = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        // If full, double the size (Grow)
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int data = stack[top--];

        // If 1/4th full, shrink to 1/2 size to save memory
        if (top < capacity / 4 && capacity > 2) {
            resize(capacity / 2);
        }
        return data;
    }

    private void resize(int newCapacity) {
        int[] newStack = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        s.push(10);
        s.push(20);
        System.out.println(s.pop()); // Output: 20
    }
}