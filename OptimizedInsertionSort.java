import java.util.Arrays;

public class OptimizedInsertionSort {

    // Helper method: Binary Search to find the position
    // where the item should be inserted
    private static int binarySearch(int[] a, int item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item == a[mid])
                return mid + 1;
            else if (item > a[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void binaryInsertionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Find location to insert using Binary Search
            // We search in the sorted portion of the array (0 to j)
            int loc = binarySearch(arr, key, 0, j);

            // Shift elements to the right to make space
            while (j >= loc) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {37, 23, 0, 17, 12, 72, 31, 46, 100, 88, 54};
        
        System.out.println("Unsorted: " + Arrays.toString(data));
        binaryInsertionSort(data);
        System.out.println("Sorted:   " + Arrays.toString(data));
    }
}