package SortAlgorithm;

import DataGenerator_DataMetrics.Metrics;

public class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] array, Metrics metrics)
    {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                metrics.comparisons++;

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    metrics.swaps++;
                }
            }
        }
    }

    @Override
    public String getName() {
        return "BubbleSort";
    }
}