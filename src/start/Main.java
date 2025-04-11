package start;

import app.*;

public class Main {

    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testQueue();
        testStack();
        testMinHeap();
    }

    public static void testArrayList() {
        MyArrayList<String> list = new MyArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("Size: " + list.size()); // Output: 3
        System.out.println("First: " + list.getFirst()); // Output: a
        System.out.println("Last: " + list.getLast()); // Output: c

        list.addFirst("z");
        System.out.println("First after addFirst: " + list.getFirst()); // Output: z

        list.addLast("x");
        System.out.println("Last after addLast: " + list.getLast()); // Output: x

        list.remove(1);
        System.out.println("Size after remove: " + list.size()); // Output: 4

        list.clear();
        System.out.println("Size after clear: " + list.size()); // Output: 0

        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println("Index of 'e': " + list.indexOf("e")); // Output: 1
        System.out.println("Last index of 'e': " + list.lastIndexOf("e")); // Output: 1
        System.out.println("Exists 'e': " + list.exists("e")); // Output: true
    }

    public static void testLinkedList() {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("Size: " + list.size()); // Output: 3
        System.out.println("First: " + list.getFirst()); // Output: a
        System.out.println("Last: " + list.getLast()); // Output: c

        list.addFirst("z");
        System.out.println("First after addFirst: " + list.getFirst()); // Output: z

        list.addLast("x");
        System.out.println("Last after addLast: " + list.getLast()); // Output: x

        list.remove(1);
        System.out.println("Size after remove: " + list.size()); // Output: 4

        list.clear();
        System.out.println("Size after clear: " + list.size()); // Output: 0

        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println("Index of 'e': " + list.indexOf("e")); // Output: 1
        System.out.println("Last index of 'e': " + list.lastIndexOf("e")); // Output: 1
        System.out.println("Exists 'e': " + list.exists("e")); // Output: true
    }

    public static void testStack() {
        MyStack<String> stack = new MyStack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");

        System.out.println("Size: " + stack.size()); // Output: 3
        System.out.println("Peek: " + stack.peek()); // Output: c

        System.out.println("Pop: " + stack.pop()); // Output: c
        System.out.println("Size after pop: " + stack.size()); // Output: 2

        System.out.println("Peek: " + stack.peek()); // Output: b
        stack.pop();
        stack.pop();
        System.out.println("Is empty: " + stack.isEmpty()); // Output: true
    }

    public static void testQueue() {
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        System.out.println("Size: " + queue.size()); // Output: 3
        System.out.println("Peek: " + queue.peek()); // Output: a

        System.out.println("Dequeue: " + queue.dequeue()); // Output: a
        System.out.println("Size after dequeue: " + queue.size()); // Output: 2

        System.out.println("Peek: " + queue.peek()); // Output: b
        queue.dequeue();
        queue.dequeue();
        System.out.println("Is empty: " + queue.isEmpty()); // Output: true
    }

    public static void testMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();

        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);

        System.out.println("Peek min: " + minHeap.peekMin()); // Output: 1
        System.out.println("Remove min: " + minHeap.removeMin()); // Output: 1
        System.out.println("Peek min after remove: " + minHeap.peekMin()); // Output: 2
        System.out.println("Size: " + minHeap.size()); // Output: 5
    }

}