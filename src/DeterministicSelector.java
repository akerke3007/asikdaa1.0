import java.util.Arrays;

public class DeterministicSelector {

    public static int select(int[] a, int k) {
        return select(a, 0, a.length - 1, k);
    }

    private static int select(int[] a, int left, int right, int k) {
        if (left == right) return a[left];

        int pivotIndex = medianOfMedians(a, left, right);
        pivotIndex = partition(a, left, right, pivotIndex);

        if (k == pivotIndex) {
            return a[k];
        } else if (k < pivotIndex) {
            return select(a, left, pivotIndex - 1, k);
        } else {
            return select(a, pivotIndex + 1, right, k);
        }
    }

    private static int medianOfMedians(int[] a, int left, int right) {
        int numElements = right - left + 1;
        if (numElements <= 5) {
            Arrays.sort(a, left, right + 1);
            return left + numElements / 2;
        }

        int numOfGroups = (numElements + 4) / 5;
        for (int i = 0; i < numOfGroups; i++) {
            int subLeft = left + i * 5;
            int subRight = Math.min(subLeft + 4, right);
            Arrays.sort(a, subLeft, subRight + 1);
            int medianIndex = subLeft + (subRight - subLeft) / 2;
            int temp = a[medianIndex];
            a[medianIndex] = a[left + i];
            a[left + i] = temp;
        }

        return select(a, left, left + numOfGroups - 1, left + numOfGroups / 2);
    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        int temp = a[pivotIndex]; a[pivotIndex] = a[right]; a[right] = temp;

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (a[i] < pivotValue) {
                temp = a[storeIndex]; a[storeIndex] = a[i]; a[i] = temp;
                storeIndex++;
            }
        }
        temp = a[storeIndex]; a[storeIndex] = a[right]; a[right] = temp;
        return storeIndex;
    }
}