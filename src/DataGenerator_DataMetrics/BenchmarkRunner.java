package DataGenerator_DataMetrics;

import DataGenerator_DataMetrics.DataGenerator;
import SortAlgorithm.BubbleSort;
import DataGenerator_DataMetrics.Metrics;
import SortAlgorithm.SortAlgorithm;
import SortAlgorithm.QuickSort;
import SortAlgorithm.MergeSort;
import SortAlgorithm.HeapSort;
import java.util.ArrayList;
import java.util.List;

public class BenchmarkRunner
{

    public void run(SortAlgorithm algorithm, int[] sizes, String[] types) {

        System.out.println("\n===== " + algorithm.getName() + " =====");

        for (String type : types) {
            System.out.println("\nDATA TYPE: " + type);

            for (int size : sizes) {

                int[] data = DataGenerator.generate(type, size);
                int[] copy = data.clone();

                Metrics metrics = new Metrics();

                long start = System.nanoTime();
                algorithm.sort(copy, metrics);
                long end = System.nanoTime();
                long timeMs = (end - start) / 1_000_000;

                System.out.println(
                        "size=" + size +
                                " | time=" + timeMs + " ms" +
                                " | comp=" + metrics.comparisons +
                                " | swaps=" + metrics.swaps
                );
            }
        }
    }
}