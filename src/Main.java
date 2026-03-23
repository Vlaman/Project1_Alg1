import DataGenerator_DataMetrics.DataGenerator;
import SortAlgorithm.BubbleSort;
import DataGenerator_DataMetrics.Metrics;
import SortAlgorithm.SortAlgorithm;
import SortAlgorithm.QuickSort;
import SortAlgorithm.MergeSort;
import SortAlgorithm.HeapSort;
import DataGenerator_DataMetrics.BenchmarkRunner;

import java.util.Arrays;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        List<SortAlgorithm> algorithms = Arrays.asList
                (
                new BubbleSort(),
                new QuickSort(),
                new MergeSort(),
                new HeapSort()
                );

        int[] sizes = {100, 1000, 5000, 10000, 50000, 100000};
        int[] sizes1 = {100, 1000, 5000, 10000};

        String[] types = {"random", "sorted", "reversed", "partial"};

        BenchmarkRunner runner = new BenchmarkRunner();


        System.out.println();

        runner.run(new QuickSort(), sizes1, types);
        runner.run(new BubbleSort(), sizes, types);
        runner.run(new HeapSort(), sizes, types);
        runner.run(new MergeSort(), sizes, types);
    }
}