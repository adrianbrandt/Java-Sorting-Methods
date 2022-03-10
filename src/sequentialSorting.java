public class sequentialSorting {


    // Insertion sort
    public static void insertionSort(int[] A)
    {
        int k = A.length;
        int key;

        for (int i = 1; i < k; i++)
        {
            key = A[i];
            int j = i;
            while (j > 0 && A[j-1] > key)
            {
                A[j] = A[j-1];
                j--;
            }
            A[j] = key;
        }
    }
}
