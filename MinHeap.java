import java.util.Scanner;
public class MinHeap {
    static int[] heap;
    static int size = 0;
    static int capacity;
    // Heapify up (for insertion)
    static void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        while (index > 0 && heap[parent] > heap[index]) {
            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;
            index = parent;
            parent = (index - 1) / 2;
        }
    }
    // Heapify down (for deletion)
    static void heapifyDown(int index) {
        int smallest = index;
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left < size && heap[left] < heap[smallest]){
                smallest = left;
            }
            if (right < size && heap[right] < heap[smallest]){
                smallest = right;
            }
            if (smallest != index) {
                int temp = heap[smallest];
                heap[smallest] = heap[index];
                heap[index] = temp;
                index = smallest;
            } else
                break;
        }
    }
    // Insert element
    static void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = val;
        heapifyUp(size);
        size++;
    }
    // Delete element at index
    static void delete(int val) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (heap[i] == val) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Element not found!");
            return;
        }
        heap[index] = heap[size - 1];
        size--;
        heapifyDown(index);
    }
    // Display heap
    static void display() {
        System.out.print("Heap elements: ");
        for (int i = 0; i < size; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter capacity of heap: ");
        capacity = sc.nextInt();
        heap = new int[capacity];
        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            insert(val);
        }
        display();
        System.out.print("Enter element to delete: ");
        int del = sc.nextInt();
        delete(del);
        display();
    }
}
