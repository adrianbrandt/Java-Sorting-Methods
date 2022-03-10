import java.util.*;

public class Tester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int MAX_S = 100000, MAX_L = 100000000, MAX_R = 1000000;
        int[] A;
        int n,w,answer;
        long time;
        double c,avgC = 0,avgCT,av = 0;
        int clock = 0;

        while (true) {

            System.out.println("""
                    \n
                    Welcome to the sorter, which sorter would you like to use?
                    Quicksort: 1
                    Insertion sort: 2
                    Merge sort: 3
                    Radix sort: 4
                    
                    EXIT: 5""");

            answer = scan.nextInt();

            System.out.println("Amount of numbers to sort (n): ");
            n = scan.nextInt();


            A = new int[n];
            w = String.valueOf(n).length();

            switch (answer) {
                case 1 -> {
                    if (n >MAX_L)
                    {
                        System.out.println("Enter number between 1 and " +MAX_L);
                    }
                    else if (n > 0 && n <MAX_L)
                    {
                        System.out.println("\nQuicksort for n= " + n);
                        System.out.println("--------------------------------------");
                        System.out.println("|   n         t(ms)      T/(nlog(n)) |");
                        System.out.println("|------------------------------------|");

                        randomize(A);
                        time = System.currentTimeMillis();
                        logarithmicSorting.quickSort(A, 0, n - 1);
                        time = System.currentTimeMillis() - time;
                        c = time / (n * Math.log(n));
                        for (int i = 0; i < 15; i ++) {

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
                    }
                }
                case 2 -> {

                    if (n >MAX_S){
                        System.out.println("Please enter number between 1 and " + MAX_S);
                    }
                    else if (n > 0 && n < MAX_S) {
                        System.out.println("\nInsertion sort for n= " + n);
                        System.out.println("--------------------------------------");
                        System.out.println("|   n         t(ms)       t/n^n      |");
                        System.out.println("|------------------------------------|");

                        randomize(A);
                        time = System.currentTimeMillis();
                        sequentialSorting.insertionSort(A);
                        time = System.currentTimeMillis() - time;
                        c = time / ((double) (n * n));
                        for (int i = 0; i < 15; i ++) {
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
                    }
                }
                case 3 -> {
                    if (n >MAX_L)
                    {
                        System.out.println("Enter number between 1 and " +MAX_L);
                    }
                    else if (n > 0 && n <MAX_L) {

                        System.out.println("\nMerge sort for n= " + n);
                        System.out.println("--------------------------------------");
                        System.out.println("|   n         t(ms)      T/(nlog(n)) |");
                        System.out.println("|------------------------------------|");

                        randomize(A);
                        time = System.currentTimeMillis();
                        logarithmicSorting.mergeSort(A, 0, n - 1);
                        time = System.currentTimeMillis() - time;
                        c = time / (n * Math.log(n));

                        for (int i = 0; i < 15; i ++) {

                            randomize(A);
                            time = System.currentTimeMillis();
                            logarithmicSorting.mergeSort(A, 0, n - 1);
                            time = System.currentTimeMillis() - time;

                            System.out.printf("|%6d     %6d        %9.4e |\n", n, time, (time / ((double) n * Math.log(n))));

                            av += time;
                            clock += 1;
                        }
                        avgCT = (av / ((float) n * Math.log(n)));
                        avgC = ((avgCT / clock));

                        System.out.println("|------------------------------------|");
                        System.out.println("Average complexity is   : " + avgC);
                        System.out.println("Complexity for n= " + n + " : " + c);
                        System.out.println("Merge sort completed in : " + time + "ms");
                    }
                }
                case 4 -> {
                    if (n >MAX_R){
                        System.out.println("Please enter number between 1 and " + MAX_R);
                    }
                    else if (n > 0 && n < MAX_R) {
                        System.out.println("\nRadix sort for n= " + n);
                        System.out.println("--------------------------------------");
                        System.out.println("|   n         t(ms)         O(w*n)   |");
                        System.out.println("|------------------------------------|");

                        randomize(A);
                        time = System.currentTimeMillis();
                        radixSorting.radixSort(A, w);
                        time = System.currentTimeMillis() - time;

                        c = ((time/(double)(n)));

                        int i;
                        for (i = 0; i < 15; i ++) {

                            randomize(A);
                            time = System.currentTimeMillis();
                            radixSorting.radixSort(A, w);
                            time = System.currentTimeMillis() - time;


                            System.out.printf("|%6d     %6d        %6f    |\n", n, time, ((time)/(double)(n)));

                            avgC += ((time)/(double)n);
                        }
                        avgC = (avgC/i);
                        System.out.println("|------------------------------------|");
                        System.out.println("Average complexity is   : " + avgC);
                        System.out.println("Complexity for n= " + n + " : " + c);
                        System.out.println("Radix sort completed in : " + time + "ms");
                    }
                }
                case 5 -> {
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
