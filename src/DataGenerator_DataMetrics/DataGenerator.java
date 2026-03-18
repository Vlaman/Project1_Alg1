package DataGenerator_DataMetrics;

import java.util.Random;


public class DataGenerator
{

    private static final Random random = new Random();

    public static int[] random(int size)
    {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
        {
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    public static int[] sorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] reversed(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static int[] partiallySorted(int size) {
        int[] arr = sorted(size);

        for (int i = 0; i < size / 10; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        return arr;
    }

    public static int[] generate(String type, int size) {
        switch (type) {
            case "random":
                return random(size);
            case "sorted":
                return sorted(size);
            case "reversed":
                return reversed(size);
            case "partial":
                return partiallySorted(size);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}