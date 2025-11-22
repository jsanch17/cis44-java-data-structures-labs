
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AdvancedSortDriver {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        int N = 100; // Large array
        Random rand = new Random();

        Integer[] arr1 = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = rand.nextInt(1000); // Random numbers
        }
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        System.out.println("--- Test: Random Array (N=" + N + ") ---");
        System.out.println("Original (first 20): " + Arrays.toString(Arrays.copyOf(arr1, 20)));

        AdvancedSorters.mergeSort(arr1, comp);
        System.out.println("Merge Sort (first 20): " + Arrays.toString(Arrays.copyOf(arr1, 20)));

        AdvancedSorters.quickSort(arr2, comp);
        System.out.println("Quick Sort (first 20): " + Arrays.toString(Arrays.copyOf(arr2, 20)));
    }
}
