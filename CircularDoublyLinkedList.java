public class CircularDoublyLinkedList {
    
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    // Insert at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;

            // Link tail and new node
            tail.next = newNode;
            newNode.prev = tail;

            // Link new node and head
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Display elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        System.out.print("Circular List: ");
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(Head)");
    }

    // Main for testing
    public static void main(String[] args) {
        CircularDoublyLinkedList cdl = new CircularDoublyLinkedList();
        cdl.insert(10);
        cdl.insert(20);
        cdl.insert(30);
        cdl.display(); // 10 <-> 20 <-> 30 <-> (Head)
    }
}