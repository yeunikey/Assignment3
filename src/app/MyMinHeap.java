package app;

public class MyMinHeap<T extends Comparable<T>> {

    private Object[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyMinHeap() {
        heap = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void ensureCapacity() {
        if (size == heap.length) {
            heap = java.util.Arrays.copyOf(heap, heap.length * 2);
        }
    }

    public void insert(T item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp(size - 1);
    }

    @SuppressWarnings("unchecked")
    public T removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T min = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        heapifyDown(0);
        return min;
    }

    @SuppressWarnings("unchecked")
    public T peekMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) heap[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (((T) heap[index]).compareTo((T) heap[parentIndex]) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        while (index < size / 2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallerChildIndex = leftChildIndex;

            if (rightChildIndex < size && ((T) heap[rightChildIndex]).compareTo((T) heap[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            if (((T) heap[index]).compareTo((T) heap[smallerChildIndex]) <= 0) {
                break;
            }

            swap(index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private void swap(int index1, int index2) {
        Object temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
