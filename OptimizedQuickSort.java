import java.util.Arrays;

public class OptimizedQuickSort {

    private static final int CUTOFF = 10; // Threshold to switch to Insertion Sort

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low + CUTOFF > high) {
            insertionSort(arr, low, high);
        } else {
            // Median of three partitioning
            int pivot = medianOfThree(arr, low, high);

            // Begin partitioning
            int i = low, j = high - 1;
            for (;;) { 
                while (arr[++i] < pivot) {}
                while (arr[--j] > pivot) {}
                if (i < j)
                    swap(arr, i, j);
                else
                    break;
            }

            // Restore pivot
            swap(arr, i, high - 1);

            quickSort(arr, low, i - 1);
            quickSort(arr, i + 1, high);
        }
    }

    // Helper to find median of low, center, and high to use as pivot
    private static int medianOfThree(int[] arr, int low, int high) {
        int center = (low + high) / 2;
        
        if (arr[center] < arr[low]) swap(arr, low, center);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[high] < arr[center]) swap(arr, center, high);

        // Place pivot at position high-1
        swap(arr, center, high - 1);
        return arr[high - 1];
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard insertion sort for small subarrays
    private static void insertionSort(int[] arr, int low, int high) {
        for (int p = low + 1; p <= high; p++) {
            int tmp = arr[p];
            int j;
            for (j = p; j > low && tmp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] data = {8, 1, 4, 9, 0, 3, 5, 2, 7, 6, 15, 12};
        
        System.out.println("Unsorted: " + Arrays.toString(data));
        sort(data);
        System.out.println("Sorted:   " + Arrays.toString(data));
    }
}