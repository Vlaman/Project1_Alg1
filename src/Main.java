import DataGenerator_DataMetrics.DataGenerator;
import SortAlgorithm.BubbleSort;
import DataGenerator_DataMetrics.Metrics;
import SortAlgorithm.SortAlgorithm;
import SortAlgorithm.QuickSort;

import java.util.Arrays;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        List<SortAlgorithm> algorithms = Arrays.asList(
                new BubbleSort(),
                new QuickSort()
        );

        int[] sizes = {100, 1000, 5000};

        for (int size : sizes) {
            System.out.println("\n===== SIZE: " + size + " =====");

            for (SortAlgorithm algorithm : algorithms) {

                int[] data = DataGenerator.random(size);
                int[] copy = data.clone();

                runTest(copy, algorithm);
            }
        }
    }

    public static void runTest(int[] data, SortAlgorithm algorithm) {

        Metrics metrics = new Metrics();

        long start = System.nanoTime();
        algorithm.sort(data, metrics);
        long end = System.nanoTime();

        System.out.println(
                algorithm.getName() +
                        " | time=" + (end - start) +
                        " | comp=" + metrics.comparisons +
                        " | swaps=" + metrics.swaps
        );
    }
}