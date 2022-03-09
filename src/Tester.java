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
        double c,avgC = 0,avgCT = 0,av = 0;
        long t[] = new long[15];
        int clock = 0;

        sequentialSorting sS = new sequentialSorting();

        while (true) {




            System.out.println("Welcome to the sorter, which sorter would you like to use?"
                    +"\nQuicksort: 1"
                    +"\nInsertion sort: 2"
                    +"\nMerge sort: 3"
                    +"\nRadix sort: 4");
            answer = scan.nextInt();

            System.out.println("Amount of numbers to sort (n): ");
            n = scan.nextInt();

            if (n < 0 || n > MAX_N)
            {
                System.out.println("Use  1 <= n <= " + MAX_N);
                System.exit(1);
            }


            A = new int[n];

            switch (answer) {
                case 1:
                    System.out.println("\nQuicksort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)      T/(nlog(n)) |");
                    System.out.println("|------------------------------------|");

                    randomize(A);
                    time = System.currentTimeMillis();
                    quickSort(A, 0, n-1);
                    time = System.currentTimeMillis() - time;

                    c = time/(n*Math.log(n));

                    for (int i = 10000; i<150001;i+=10000){

                        randomize(A);
                        time = System.currentTimeMillis();
                        quickSort(A, 0, n-1);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %9.4e |\n",n,time,((float)time/((float)n*Math.log(n))));

                        av += time;
                        clock += 1;
                    }

                    avgCT = (av/((float)n*Math.log(n)));
                    avgC = ((avgCT/clock));

                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is  : " + avgC);
                    System.out.println("Complexity for n= "+n+": " + c);
                    System.out.println("Quicksort completed in : "+ time +"ms");

                    return;

                case 2:
                    System.out.println("\nInsertion sort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)       t/n^n      |");
                    System.out.println("|------------------------------------|");

                    randomize(A);
                    time = System.currentTimeMillis();
                    insertionSort(A);
                    time = System.currentTimeMillis() - time;

                    c = (float)time/((float)(n*n));

                    for (int i = 10000; i<100001;i+=10000){
                        randomize(A);
                        time = System.currentTimeMillis();
                        insertionSort(A);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %9.4e |\n",n,time,(float)time/((float)(n*n)));
                        av += time;
                        clock += 1;
                    }
                    avgCT = (float)av/((float)(n*n));
                    avgC = ((avgCT/clock));

                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is       : " + avgC);
                    System.out.println("Complexity for n= "+n+"     : " + c);
                    System.out.println("Insertion sort completed in : "+ time +"ms");

                    return;

                case 3:
                    System.out.println("\nMerge sort for n= " + n);
                    System.out.println("--------------------------------------");
                    System.out.println("|   n         t(ms)      T/(nlog(n)) |");
                    System.out.println("|------------------------------------|");

                    randomize(A);
                    time = System.currentTimeMillis();
                    mergeSort(A, 0, n-1);
                    time = System.currentTimeMillis() - time;

                    c = time/(n*Math.log(n));

                    for (int i = 10000; i<150001;i+=10000){

                        randomize(A);
                        time = System.currentTimeMillis();
                        mergeSort(A, 0, n-1);
                        time = System.currentTimeMillis() - time;

                        System.out.printf("|%6d     %6d        %9.4e |\n",n,time,((float)time/((float)n*Math.log(n))));

                        av += time;
                        clock += 1;
                    }

                    avgCT = (av/((float)n*Math.log(n)));
                    avgC = ((avgCT/clock));

                    System.out.println("|------------------------------------|");
                    System.out.println("Average complexity is   : " + avgC);
                    System.out.println("Complexity for n= "+n+" : " + c);
                    System.out.println("Merge sort completed in : "+ time +"ms");

                    return;
                case 4:
                    System.out.println("Radix-sort");
                    return;

                default:
                    System.out.println("Not a valid option! Please select another");
            }
        }

    }

    public static void insertionSort(int A[])
    {
        // Innstikksortering av array med heltall

        int k = A.length;
        int key;

        for (int i = 1; i < k; i++)
        {
            // A er sortert t.o.m. indeks i-1
            key = A[i];
            int j = i;
            // Setter element nummer i pÃ¥ riktig plass
            // blant de i-1 fÃ¸rste elementene
            while (j > 0 && A[j-1] > key)
            {
                A[j] = A[j-1];
                j--;
            }
            A[j] = key;
        }
    }


    public static void quickSort(int A[], int min, int max)
    {
        // Quicksort av array med heltall

        int indexofpartition;

        if (max - min  > 0)
        {
            // Partisjonerer array
            indexofpartition = findPartition(A, min, max);

            // Sorterer venstre del
            quickSort(A, min, indexofpartition - 1);

            // Sorterer høyre del
            quickSort(A, indexofpartition + 1, max);
        }
    }

    private static int findPartition (int[] A, int min, int max)
    {
        int left, right;
        int temp, partitionelement;

        // Bruker *fÃ¸rste* element til Ã¥ dele opp
        partitionelement = A[min];

        left = min;
        right = max;

        // GjÃ¸r selve partisjoneringen
        while (left < right)
        {
            // Finn et element som er stÃ¸rre enn part.elementet
            while (A[left] <= partitionelement && left < right)
                left++;

            // Finn et element som er mindre enn part.elementet
            while (A[right] > partitionelement)
                right--;

            // Bytt om de to hvis ikke ferdig
            if (left < right)
            {
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }

        // Sett part.elementet mellom partisjoneringene
        temp = A[min];
        A[min] = A[right];
        A[right] = temp;

        // Returner indeksen til part.elementet
        return right;
    }

    public static void mergeSort (int[] A, int min, int max)
    {

        // Flettesortering av array med heltall

        if (min==max)
            return;

        int[] temp;
        int index1, left, right;
        int size = max - min + 1;
        int mid = (min + max) / 2;

        temp = new int[size];

        // Flettesorterer de to halvdelene av arrayen
        mergeSort(A, min, mid);
        mergeSort(A, mid + 1,max);

        // Kopierer array over i temp.array
        for (index1 = 0; index1 < size; index1++)
            temp[index1] = A[min + index1];

        // Fletter sammen de to sorterte halvdelene over i A
        left = 0;
        right = mid - min + 1;
        for (index1 = 0; index1 < size; index1++)
        {
            if (right <= max - min)
                if (left <= mid - min)
                    if (temp[left] > temp[right])
                        A[index1 + min] = temp[right++];
                    else
                        A[index1 + min] = temp[left++];
                else
                    A[index1 + min] = temp[right++];
            else
                A[index1 + min] = temp[left++];
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
