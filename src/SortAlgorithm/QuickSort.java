package SortAlgorithm;

import DataGenerator_DataMetrics.Metrics;


public class QuickSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, Metrics metrics) {
        quickSort(array, 0, array.length - 1, metrics);
    }

    private void quickSort(int[] arr, int low, int high, Metrics metrics) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, metrics);

            quickSort(arr, low, pivotIndex - 1, metrics);
            quickSort(arr, pivotIndex + 1, high, metrics);
        }
    }

    private int partition(int[] arr, int low, int high, Metrics metrics) {

        int pivot = arr[high]; // берём последний элемент
        int i = low - 1;

        for (int j = low; j < high; j++) {

            metrics.comparisons++;

            if (arr[j] < pivot) {
                i++;

                swap(arr, i, j, metrics);
            }
        }

        swap(arr, i + 1, high, metrics);

        return i + 1;
    }

    private void swap(int[] arr, int i, int j, Metrics metrics) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        metrics.swaps++;
    }

    @Override
    public String getName() {
        return "QuickSort";
    }
}
