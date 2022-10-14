import java.util.LinkedList;
import java.util.Queue;

public class radixSorting {

    void sort(int[] a, int w) {
        int n = a.length;

        Queue[] Q = new Queue[10];

        for (int i = 0; i < 10; i++)
            Q[i] = new LinkedList<>();

        for (int m = 0; m < w; m++) {
            for (int k : a) {
                int dig = k % 10;
                Q[dig].add(k);
            }

            int j = 0;
            for (int i = 0; i < 10; i++)
                while (!Q[i].isEmpty())
                    a[j++] = (int) Q[i].remove();
        }
    }

    public static void radixSort(int[] a, int m) {
        radixSorting rS = new radixSorting();
        rS.sort(a, m);

    }

}