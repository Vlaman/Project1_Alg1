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

    public void run(List<SortAlgorithm> algorithms, int[] sizes, String[] types) {

        for (String type : types) {
            System.out.println("\n===== DATA TYPE: " + type.toUpperCase() + " =====");

            for (int size : sizes) {
                System.out.println("\n--- SIZE: " + size + " ---");

                for (SortAlgorithm algorithm : algorithms) {

                    int[] data = DataGenerator.generate(type, size);
                    int[] copy = data.clone();

                    Metrics metrics = new Metrics();

                    long start = System.nanoTime();
                    algorithm.sort(copy, metrics);
                    long end = System.nanoTime();

                    System.out.println(
                            algorithm.getName() +
                                    " | time=" + (end - start) +
                                    " | comp=" + metrics.comparisons +
                                    " | swaps=" + metrics.swaps
                    );
                }
            }
        }
    }
}