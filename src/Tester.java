import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int MAX_SEQUENTIAL = 100000, MAX_N = 100000000;
        int A[];
        int n,answer;
        long time = 0;
        long t[] = new long[15];
        double avg,tot;

        sequentialSorting sS = new sequentialSorting();
        logarithmicSorting lS = new logarithmicSorting();

        while (true) {

            System.out.println("Amount of numbers to sort (n): ");
            n = scan.nextInt();
            if (n < 0 || n > MAX_N)
            {
                System.out.println("Use  1 <= n <= " + MAX_N);
                System.exit(1);
            }
            A = new int[n];
            tot = 0;

            for (int i = 0; i<15; i++){
                randomize(A);
                time = System.currentTimeMillis();
                lS.quickSort(A, 0, n-1);
                time = System.currentTimeMillis() - time;
                t[i] = time;
            }
            for (int i = 0; i<t.length; i++){
                tot = tot + t[i];

            }
            avg = tot/t.length;


            System.out.println("Welcome to the sorter, which sorter would you like to use?" +
                    "\nQuicksort: 1\tEstimated time: "+ avg
                    +"\nInsertion sort: 2\t Estimated time: "
                    + "\nMerge sort: 3\nRadix sort: 4");
            answer = scan.nextInt();

            switch (answer) {
                case 1:
                    randomize(A);
                    time = System.currentTimeMillis();
                    lS.quickSort(A, 0, n-1);
                    time = System.currentTimeMillis() - time;
                    System.out.printf("Quicksort completed in: %6d ms\n", time);

                    return;

                case 2:
                    randomize(A);
                    time = System.currentTimeMillis();
                    sS.insertionSort(A);
                    time = System.currentTimeMillis() - time;
                    System.out.printf("Insertion sort\t: %6d ms\n", time);
                    return;

                case 3:
                    System.out.println("Merge sort");
                    return;

                case 4:
                    System.out.println("Radix-sort");
                    return;

                default:
                    System.out.println("Not a valid option! Please select another");
            }
        }

    }


    public static void init(int n, int MAX_N, int A[]){

        if (n < 0 || n > MAX_N)
        {
            System.out.println("Use  1 <= n <= " + MAX_N);
            System.exit(1);
        }

    }

    public static void randomize(int A[])
    {
        Random r = new Random();
        int n =  A.length;
        int n2 = 2 * n;
        for (int i = 0; i < n; i++)
            A[i] = r.nextInt(n2);
    }

}
