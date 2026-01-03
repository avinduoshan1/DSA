public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    // Insert at Head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;

        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at Tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        Node current = head;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
        newNode.prev = current;
    }

    // Display list forward
    public void displayForward() {
        Node current = head;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Display list backward
    public void displayBackward() {
        Node current = head;
        if (current == null) return;

        // Go to last node
        while (current.next != null) {
            current = current.next;
        }

        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtTail(10);
        dll.insertAtTail(20);
        dll.insertAtHead(5);
        
        dll.displayForward();  // 5 <-> 10 <-> 20 <-> null
        dll.displayBackward(); // 20 <-> 10 <-> 5 <-> null
    }
}