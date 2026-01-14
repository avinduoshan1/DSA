import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Unsorted Array: " + Arrays.toString(data));
        
        bubbleSort(data);
        
        System.out.println("Sorted Array:   " + Arrays.toString(data));
    }
}