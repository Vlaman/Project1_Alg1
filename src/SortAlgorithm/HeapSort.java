package SortAlgorithm;
import DataGenerator_DataMetrics.Metrics;

public class HeapSort implements SortAlgorithm {

    @Override
    public void sort(int[] arr, Metrics metrics) {
        int n = arr.length;

        // Построение кучи (max heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i, metrics);
        }

        // Извлечение элементов из кучи
        for (int i = n - 1; i > 0; i--) {

            swap(arr, 0, i, metrics);

            heapify(arr, i, 0, metrics);
        }
    }

    private void heapify(int[] arr, int n, int i, Metrics metrics) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Левый ребёнок
        if (left < n) {
            metrics.comparisons++;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }

        // Правый ребёнок
        if (right < n) {
            metrics.comparisons++;
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }

        // Если не корень — меняем
        if (largest != i) {
            swap(arr, i, largest, metrics);

            // Рекурсия
            heapify(arr, n, largest, metrics);
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
