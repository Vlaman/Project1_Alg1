package SortAlgorithm;
import DataGenerator_DataMetrics.Metrics;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr, Metrics metrics) {
        mergeSort(arr, 0, arr.length - 1, metrics);
    }

    private void mergeSort(int[] arr, int left, int right, Metrics metrics) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, metrics);
        mergeSort(arr, mid + 1, right, metrics);

        merge(arr, left, mid, right, metrics);
    }

    private void merge(int[] arr, int left, int mid, int right, Metrics metrics) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // копируем
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // слияние
        while (i < n1 && j < n2) {
            metrics.comparisons++;

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }

            metrics.swaps++; // считаем как запись
            k++;
        }

        // остатки
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            metrics.swaps++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            metrics.swaps++;
        }
    }

    @Override
    public String getName() {
        return "MergeSort";
    }
}

