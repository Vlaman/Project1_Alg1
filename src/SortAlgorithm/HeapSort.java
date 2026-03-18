package SortAlgorithm;
import DataGenerator_DataMetrics.Metrics;

public class HeapSort implements SortAlgorithm
{

    @Override
    public void sort(int[] array, Metrics metrics) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, metrics);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i, metrics);
            heapify(array, i, 0, metrics);
        }
    }

    private void heapify(int[] arr, int heapSize, int rootIndex, Metrics metrics) {
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize) {
            metrics.comparisons++;
            if (arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }
        }

        if (rightChild < heapSize) {
            metrics.comparisons++;
            if (arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }
        }

        if (largest != rootIndex) {
            swap(arr, rootIndex, largest, metrics);
            heapify(arr, heapSize, largest, metrics);
        }
    }

    private void swap(int[] arr, int i, int j, Metrics metrics) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        metrics.swaps++;
    }

    @Override
    public String getName() {
        return "HeapSort";
    }
}
