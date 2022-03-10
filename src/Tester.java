import java.util.*;

public class Tester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int MAX_SEQUENTIAL = 100000, MAX_N = 100000000;
        int[] A;
        int n,ma,answer;
        long time;
        double c,avgC,avgCT,av = 0;
        long[] t = new long[15];
        int clock = 0;



        while (true) {




            System.out.println("""
                    Welcome to the sorter, which sorter would you like to use?
                    Quicksort: 1
                    Insertion sort: 2
                    Merge sort: 3
                    Radix sort: 4""");
            answer = scan.nextInt();

            System.out.println("Amount of numbers to sort (n): ");
            n = scan.nextInt();

            if (n < 0 || n > MAX_N)
            {
                System.out.println("Use  1 <= n <= " + MAX_N);
                System.exit(1);
            }


            A = new int[n];
            ma = A.length;

            switch (answer) {
                case 1 -> {
                    System.out.println("\nQuicksort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)      T/(nlog(n)) |");
                    System.out.println("|------------------------------------|");
                    randomize(A);
                    time = System.currentTimeMillis();
                    logarithmicSorting.quickSort(A, 0, n - 1);
                    time = System.currentTimeMillis() - time;
                    c = time / (n * Math.log(n));
                    for (int i = 10000; i < 150001; i += 10000) {

                        randomize(A);
                        time = System.currentTimeMillis();
                        logarithmicSorting.quickSort(A, 0, n - 1);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %9.4e |\n", n, time, (time / ((double) n * Math.log(n))));

                        av += time;
                        clock += 1;
                    }
                    avgCT = (av / ((float) n * Math.log(n)));
                    avgC = ((avgCT / clock));
                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is  : " + avgC);
                    System.out.println("Complexity for n= " + n + ": " + c);
                    System.out.println("Quicksort completed in : " + time + "ms");
                    return;
                }
                case 2 -> {
                    System.out.println("\nInsertion sort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)       t/n^n      |");
                    System.out.println("|------------------------------------|");
                    randomize(A);
                    time = System.currentTimeMillis();
                    sequentialSorting.insertionSort(A);
                    time = System.currentTimeMillis() - time;
                    c = time / ((double) (n * n));
                    for (int i = 10000; i < 100001; i += 10000) {
                        randomize(A);
                        time = System.currentTimeMillis();
                        sequentialSorting.insertionSort(A);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %9.4e |\n", n, time, time / ((double) (n * n)));
                        av += time;
                        clock += 1;
                    }
                    avgCT = av / ((double) (n * n));
                    avgC = ((avgCT / clock));
                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is       : " + avgC);
                    System.out.println("Complexity for n= " + n + "     : " + c);
                    System.out.println("Insertion sort completed in : " + time + "ms");
                    return;
                }
                case 3 -> {
                    System.out.println("\nMerge sort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)      T/(nlog(n)) |");
                    System.out.println("|------------------------------------|");
                    randomize(A);
                    time = System.currentTimeMillis();
                    logarithmicSorting.mergeSort(A, 0, n - 1);
                    time = System.currentTimeMillis() - time;
                    c = time / (n * Math.log(n));
                    for (int i = 10000; i < 150001; i += 10000) {

                        randomize(A);
                        time = System.currentTimeMillis();
                        logarithmicSorting.mergeSort(A, 0, n - 1);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %f |\n", n, time, (time / ((double) n * Math.log(n))));

                        av += time;
                        clock += 1;
                    }
                    avgCT = (av / ((float) n * Math.log(n)));
                    avgC = ((avgCT / clock));
                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is   : " + avgC);
                    System.out.println("Complexity for n= " + n + " : " + c);
                    System.out.println("Merge sort completed in : " + time + "ms");
                    return;
                }
                case 4 -> {
                    System.out.println("\nRadix sort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)         O(w*n)   |");
                    System.out.println("|------------------------------------|");
                    randomize(A);
                    time = System.currentTimeMillis();
                    int m = radixSorting.radixsort(A, ma);
                    radixSorting.radixsort(A, ma);
                    time = System.currentTimeMillis() - time;
                    c = n * m;
                    for (int i = 10000; i < 150001; i += 10000) {

                        randomize(A);
                        time = System.currentTimeMillis();
                        radixSorting.radixsort(A, ma);
                        m = radixSorting.radixsort(A, ma);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %d |\n", n, time, m * n);

                        clock += 1;
                    }
                    avgC = (((double) m * n / clock));
                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is   : " + avgC);
                    System.out.println("Complexity for n= " + n + " : " + c);
                    System.out.println("Radix sort completed in : " + time + "ms");
                    return;
                }
                default -> System.out.println("Not a valid option! Please select another");
            }
        }

    }

    // Randomizer
    public static void randomize(int[] A)
    {
        Random r = new Random();
        int n =  A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++)
            A[i] = r.nextInt(n2);
    }


}
