import java.util.NoSuchElementException;

public class MyLinkedList {
    public class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node first;
    private Node last;
    private int size;

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int data) {
        Node newnode = new Node(data);
        if (isEmpty()) {
            first = last = newnode;
        } else {
            newnode.next = first;
            first = newnode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newnode = new Node(data);
        if (isEmpty()) {
            first = last = newnode;
        } else {
            last.next = newnode;
            last = newnode;
        }
        size++;
    }

    public int indexOf(int data) {
        int count = 0;
        Node head = first;
        while (isEmpty()) {
            if (head.data == data) {
                return count;
            }
            head = head.next;
            count++;
        }
        return -1;
    }

    public boolean contains(int data) {
        return indexOf(data) != -1;
    }

    //deleteFirst
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;

        } else {
            Node second = first.next;
            first.next = null;
            first = second;

        }
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();
        if (first == last) {
            first = last = null;
        } else {

            Node curr = first;
            Node prev = curr;
            curr = curr.next;
            while (curr != null) {
                prev = prev.next;
                curr = curr.next;
            }
            prev = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    //contains
    //indexOf
    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;
        Node curr = first;
        while (curr != null) {
            array[index++] = curr.data;
            curr = curr.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        Node prev = first;
        Node curr = first.next;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        last = first;
        last.next = null;

        first = prev;
    }

    public int getKthNodeFromEnd(int k) {
        Node a = first;
        Node b = first;
        while (k-- > 0) {

            b = b.next;
            if (b == null) {
                throw new IllegalArgumentException();
            }
        }
        while (b != null) {
            a = a.next;
            b = b.next;
        }
        return a.data;
    }

    public int getmiddle() {
        Node slowp = first;
        Node fastp = first.next;
        if (isEmpty()) return -1;
        while (fastp != null && fastp.next != null) {
            fastp = fastp.next.next;
            slowp = slowp.next;
        }
        return slowp.data;
    }

    public boolean hasLoop() {
        Node fastp = first;
        Node slowp = first.next;
        while (slowp != null && slowp.next != null) {
            if (slowp == fastp) {
                return true;
            }
            fastp = fastp.next.next;
            slowp = slowp.next;
        }
        return false;
    }
}
