package app;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        Node node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == size) {
            add(item);
            return;
        }
        Node nextNode = getNode(index);
        Node prevNode = nextNode.prev;
        Node newNode = new Node(item);

        newNode.next = nextNode;
        newNode.prev = prevNode;

        if (prevNode == null) {
            head = newNode;
        } else {
            prevNode.next = newNode;
        }

        nextNode.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        return (T) getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        Node node = getNode(index);
        Node prevNode = node.prev;
        Node nextNode = node.next;

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
        }

        size--;
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new NoSuchElementException();
        remove(0);
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new NoSuchElementException();
        remove(size - 1);
    }

    @Override
    public void sort() {
        // Implement sorting logic, e.g., using a comparator
        throw new UnsupportedOperationException("Sort not implemented");
    }

    @Override
    public int indexOf(Object object) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        Node current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return i;
            }
            current = current.prev;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Node current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return new Spliterator<T>() {
            private Node current = head;
            private int estimatedSize = size;

            @Override
            public boolean tryAdvance(Consumer<? super T> action) {
                if (current == null) {
                    return false;
                }
                action.accept(current.data);
                current = current.next;
                estimatedSize--;
                return true;
            }

            @Override
            public Spliterator<T> trySplit() {
                return null;
            }

            @Override
            public long estimateSize() {
                return estimatedSize;
            }

            @Override
            public int characteristics() {
                return ORDERED | SIZED | SUBSIZED;
            }
        };
    }


}
