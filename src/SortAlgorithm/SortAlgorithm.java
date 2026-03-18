package SortAlgorithm;

import DataGenerator_DataMetrics.Metrics;


public interface SortAlgorithm
{
    void sort(int[] array, Metrics metrics);
    String getName();
}
