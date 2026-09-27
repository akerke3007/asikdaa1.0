import java.util.Random;

public class QuickSorter {
    private static final Random RAND = new Random();

    public static void sort(int[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j - lo < hi - j) {
                sort(a, lo, j - 1);
                lo = j + 1;
            } else {
                sort(a, j + 1, hi);
                hi = j - 1;
            }
        }
    }

    private static int partition(int[] a, int lo, int hi) {
        int pivotIndex = lo + RAND.nextInt(hi - lo + 1);
        int pivot = a[pivotIndex];
        int temp = a[pivotIndex]; a[pivotIndex] = a[hi]; a[hi] = temp;

        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] <= pivot) {
                temp = a[i]; a[i] = a[j]; a[j] = temp;
                i++;
            }
        }
        temp = a[i]; a[i] = a[hi]; a[hi] = temp;
        return i;
    }

    private static void shuffle(int[] a) {
        for (int i = a.length; i > 1; i--) {
            int j = RAND.nextInt(i);
            int temp = a[i - 1]; a[i - 1] = a[j]; a[j] = temp;
        }
    }
}
