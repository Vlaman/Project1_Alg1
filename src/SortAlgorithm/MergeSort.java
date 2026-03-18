package SortAlgorithm;
import DataGenerator_DataMetrics.Metrics;

public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, Metrics metrics) {
        mergeSort(array, 0, array.length - 1, metrics);
    }

    private void mergeSort(int[] arr, int left, int right, Metrics metrics) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid, metrics);
        mergeSort(arr, mid + 1, right, metrics);

        merge(arr, left, mid, right, metrics);
    }

    private void merge(int[] arr, int left, int mid, int right, Metrics metrics) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            metrics.comparisons++;

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            metrics.swaps++;
            k++;
        }

        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
            metrics.swaps++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
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

