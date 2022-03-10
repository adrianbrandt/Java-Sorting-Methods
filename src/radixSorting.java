import java.util.Arrays;
import java.util.Random;

public class radixSorting {

    // Radix Sort
    static int radixsort(int[] A, int ma)
    {
        int m = getMax(A, ma);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(A, ma, exp);


        return m;
    }


    // Count sorting for radix
    static void countSort(int[] A, int ma, int exp)
    {
        int[] output = new int[ma];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < ma; i++)
            count[(A[i] / exp) % 10]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];


        for (i = ma - 1; i >= 0; i--) {
            output[count[(A[i] / exp) % 10] - 1] = A[i];
            count[(A[i] / exp) % 10]--;
        }

        for (i = 0; i < ma; i++)
            A[i] = output[i];
    }

    // Get max for radix sort
    static int getMax(int[] A, int ma)
    {
        int max = A[0];
        for (int i = 1; i < ma; i++)
            if (A[i] > max)
                max = A[i];
        return max;
    }



}
