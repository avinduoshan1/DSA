public class SinglyLinkedList {
    
    // Node Class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert at the beginning
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Delete by value
    public void delete(int key) {
        Node current = head, prev = null;

        // If head holds the key
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        // Search for the key
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // Key not present
        if (current == null) return;

        // Unlink the node
        prev.next = current.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtTail(10);
        sll.insertAtTail(20);
        sll.insertAtHead(5);
        sll.display(); // 5 -> 10 -> 20 -> null
        
        sll.delete(10);
        sll.display(); // 5 -> 20 -> null
    }
}