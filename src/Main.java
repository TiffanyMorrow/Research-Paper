import java.util.HashMap;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/*
 * The sorts have been taken from various sources online. I am not claiming credit for writing them.
 * Bubble Sort - https://www.geeksforgeeks.org/bubble-sort/
 * Selection Sort - https://www.geeksforgeeks.org/selection-sort/
 * Merge Sort - ChatGPT
 * Quick Sort - ChatGPT
 * */

class Main {
    public static void main(String[] args) throws IOException {

        // CONFIGURE THIS STRING FOR YOUR MACHINE OR IT WON'T WORK
        final String filePath = "C:\\Users\\Tiffany\\Downloads\\src\\src\\random-numbers.txt";

        int[] primitiveInts = new int[100000];
        fetchData(primitiveInts, filePath);

        Integer[] boxedInts = generateIntegerBoxed(primitiveInts);
        long[] primitiveLongs = generateLongPrimitive(primitiveInts);
        Long[] boxedLongs = generateLongBoxed(primitiveInts);


        // hashmaps record the number of elements tested and the RESULT ing runtimes

        // PRIMITIVE INTS
        HashMap<String, Long> intPrimitive = new HashMap<>();

        // bubble sort
        intPrimitive.put("bubble-100", bubbleSort(Arrays.copyOfRange(primitiveInts, 0, 100)));
        intPrimitive.put("bubble-1000", bubbleSort(Arrays.copyOfRange(primitiveInts, 0, 1000)));
        intPrimitive.put("bubble-10000", bubbleSort(Arrays.copyOfRange(primitiveInts, 0, 10000)));
        intPrimitive.put("bubble-100000", bubbleSort(Arrays.copyOfRange(primitiveInts, 0, 100000)));
        // selection sort
        intPrimitive.put("selection-100", selectionSort(Arrays.copyOfRange(primitiveInts, 0, 100)));
        intPrimitive.put("selection-1000", selectionSort(Arrays.copyOfRange(primitiveInts, 0, 1000)));
        intPrimitive.put("selection-10000", selectionSort(Arrays.copyOfRange(primitiveInts, 0, 10000)));
        intPrimitive.put("selection-100000", selectionSort(Arrays.copyOfRange(primitiveInts, 0, 100000)));

        // merge sort
        int[] mstemp = Arrays.copyOfRange(primitiveInts, 0, 100);
        intPrimitive.put("merge-100", mergeSortHandler(mstemp));
        mstemp = Arrays.copyOfRange(primitiveInts, 0, 1000);
        intPrimitive.put("merge-1000", mergeSortHandler(mstemp));
        mstemp = Arrays.copyOfRange(primitiveInts, 0, 10000);
        intPrimitive.put("merge-10000", mergeSortHandler(mstemp));
        mstemp = Arrays.copyOfRange(primitiveInts, 0, 100000);
        intPrimitive.put("merge-100000", mergeSortHandler(mstemp));

        // quick sort
        int[] temp = Arrays.copyOfRange(primitiveInts, 0, 100);
        intPrimitive.put("quick-100", quickSortHandler(temp, 0, temp.length - 1));
        temp = Arrays.copyOfRange(primitiveInts, 0, 1000);
        intPrimitive.put("quick-1000", quickSortHandler(temp, 0, temp.length - 1));
        temp = Arrays.copyOfRange(primitiveInts, 0, 10000);
        intPrimitive.put("quick-10000", quickSortHandler(temp, 0, temp.length - 1));
        temp = Arrays.copyOfRange(primitiveInts, 0, 100000);
        intPrimitive.put("quick-100000", quickSortHandler(temp, 0, temp.length - 1));
        // END PRIMITIVE INTS

        // BOXED INTS
        HashMap<String, Long> intBoxed = new HashMap<>();

        // bubble sort
        intBoxed.put("bubble-100", bubbleSort(Arrays.copyOfRange(boxedInts, 0, 100)));
        intBoxed.put("bubble-1000", bubbleSort(Arrays.copyOfRange(boxedInts, 0, 1000)));
        intBoxed.put("bubble-10000", bubbleSort(Arrays.copyOfRange(boxedInts, 0, 10000)));
        intBoxed.put("bubble-100000", bubbleSort(Arrays.copyOfRange(boxedInts, 0, 100000)));

        // selection sort
        intBoxed.put("selection-100", selectionSort(Arrays.copyOfRange(boxedInts, 0, 100)));
        intBoxed.put("selection-1000", selectionSort(Arrays.copyOfRange(boxedInts, 0, 1000)));
        intBoxed.put("selection-10000", selectionSort(Arrays.copyOfRange(boxedInts, 0, 10000)));
        intBoxed.put("selection-100000", selectionSort(Arrays.copyOfRange(boxedInts, 0, 100000)));

        // merge sort
        int[] mstemp2 = Arrays.copyOfRange(primitiveInts, 0, 100);
        intBoxed.put("merge-100", mergeSortHandler(mstemp2));
        mstemp2 = Arrays.copyOfRange(primitiveInts, 0, 1000);
        intBoxed.put("merge-1000", mergeSortHandler(mstemp2));
        mstemp2 = Arrays.copyOfRange(primitiveInts, 0, 10000);
        intBoxed.put("merge-10000", mergeSortHandler(mstemp2));
        mstemp2 = Arrays.copyOfRange(primitiveInts, 0, 100000);
        intBoxed.put("merge-100000", mergeSortHandler(mstemp2));

        // quick sort
        Integer[] temp2 = Arrays.copyOfRange(boxedInts, 0, 100);
        intBoxed.put("quick-100", quickSortHandler(temp2, 0, temp2.length - 1));
        temp2 = Arrays.copyOfRange(boxedInts, 0, 1000);
        intBoxed.put("quick-1000", quickSortHandler(temp2, 0, temp2.length - 1));
        temp2 = Arrays.copyOfRange(boxedInts, 0, 10000);
        intBoxed.put("quick-10000", quickSortHandler(temp2, 0, temp2.length - 1));
        temp2 = Arrays.copyOfRange(boxedInts, 0, 100000);
        intBoxed.put("quick-100000", quickSortHandler(temp2, 0, temp2.length - 1));
        // END BOXED INTS

        // START LONG PRIMITIVE
        HashMap<String, Long> longPrimitive = new HashMap<>();

        // bubble sort
        longPrimitive.put("bubble-100", bubbleSort(Arrays.copyOfRange(primitiveLongs, 0, 100)));
        longPrimitive.put("bubble-1000", bubbleSort(Arrays.copyOfRange(primitiveLongs, 0, 1000)));
        longPrimitive.put("bubble-10000", bubbleSort(Arrays.copyOfRange(primitiveLongs, 0, 10000)));
        longPrimitive.put("bubble-100000", bubbleSort(Arrays.copyOfRange(primitiveLongs, 0, 100000)));

        // selection sort
        longPrimitive.put("selection-100", selectionSort(Arrays.copyOfRange(primitiveLongs, 0, 100)));
        longPrimitive.put("selection-1000", selectionSort(Arrays.copyOfRange(primitiveLongs, 0, 1000)));
        longPrimitive.put("selection-10000", selectionSort(Arrays.copyOfRange(primitiveLongs, 0, 10000)));
        longPrimitive.put("selection-100000", selectionSort(Arrays.copyOfRange(primitiveLongs, 0, 100000)));

        // merge sort
        long[] mstemp3 = Arrays.copyOfRange(primitiveLongs, 0, 100);
        longPrimitive.put("merge-100", mergeSortHandler(mstemp3));
        mstemp3 = Arrays.copyOfRange(primitiveLongs, 0, 1000);
        longPrimitive.put("merge-1000", mergeSortHandler(mstemp3));
        mstemp3 = Arrays.copyOfRange(primitiveLongs, 0, 10000);
        longPrimitive.put("merge-10000", mergeSortHandler(mstemp3));
        mstemp3 = Arrays.copyOfRange(primitiveLongs, 0, 100000);
        longPrimitive.put("merge-100000", mergeSortHandler(mstemp3));

        // quick sort
        long[] temp3 = Arrays.copyOfRange(primitiveLongs, 0, 100);
        longPrimitive.put("quick-100", quickSortHandler(temp3, 0, temp3.length - 1));
        temp3 = Arrays.copyOfRange(primitiveLongs, 0, 1000);
        longPrimitive.put("quick-1000", quickSortHandler(temp3, 0, temp3.length - 1));
        temp3 = Arrays.copyOfRange(primitiveLongs, 0, 10000);
        longPrimitive.put("quick-10000", quickSortHandler(temp3, 0, temp3.length - 1));
        temp3 = Arrays.copyOfRange(primitiveLongs, 0, 100000);
        longPrimitive.put("quick-100000", quickSortHandler(temp3, 0, temp3.length - 1));
        // END LONG PRIMITIVE

        // START LONG BOXED
        HashMap<String, Long> longBoxed = new HashMap<>();

        // bubble sort
        longBoxed.put("bubble-100", bubbleSort(Arrays.copyOfRange(boxedLongs, 0, 100)));
        longBoxed.put("bubble-1000", bubbleSort(Arrays.copyOfRange(boxedLongs, 0, 1000)));
        longBoxed.put("bubble-10000", bubbleSort(Arrays.copyOfRange(boxedLongs, 0, 10000)));
        longBoxed.put("bubble-100000", bubbleSort(Arrays.copyOfRange(boxedLongs, 0, 100000)));

        // selection sort
        longBoxed.put("selection-100", selectionSort(Arrays.copyOfRange(boxedLongs, 0, 100)));
        longBoxed.put("selection-1000", selectionSort(Arrays.copyOfRange(boxedLongs, 0, 1000)));
        longBoxed.put("selection-10000", selectionSort(Arrays.copyOfRange(boxedLongs, 0, 10000)));
        longBoxed.put("selection-100000", selectionSort(Arrays.copyOfRange(boxedLongs, 0, 100000)));

        // merge sort
        Long[] mstemp4 = Arrays.copyOfRange(boxedLongs, 0, 100);
        longBoxed.put("merge-100", mergeSortHandler(mstemp4));
        mstemp4 = Arrays.copyOfRange(boxedLongs, 0, 1000);
        longBoxed.put("merge-1000", mergeSortHandler(mstemp4));
        mstemp4 = Arrays.copyOfRange(boxedLongs, 0, 10000);
        longBoxed.put("merge-10000", mergeSortHandler(mstemp4));
        mstemp4 = Arrays.copyOfRange(boxedLongs, 0, 100000);
        longBoxed.put("merge-100000", mergeSortHandler(mstemp4));

        // quick sort
        Long[] temp4 = Arrays.copyOfRange(boxedLongs, 0, 100);
        longBoxed.put("quick-100", quickSortHandler(temp4, 0, temp4.length - 1));
        temp4 = Arrays.copyOfRange(boxedLongs, 0, 1000);
        longBoxed.put("quick-1000", quickSortHandler(temp4, 0, temp4.length - 1));
        temp4 = Arrays.copyOfRange(boxedLongs, 0, 10000);
        longBoxed.put("quick-10000", quickSortHandler(temp4, 0, temp4.length - 1));
        temp4 = Arrays.copyOfRange(boxedLongs, 0, 100000);
        longBoxed.put("quick-100000", quickSortHandler(temp4, 0, temp4.length - 1));
        // END LONG BOXED

        // OUTPUT
        System.out.println("RESULTS - BUBBLE SORT");
        System.out.println("INTEGERS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + intPrimitive.get("bubble-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intPrimitive.get("bubble-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intPrimitive.get("bubble-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intPrimitive.get("bubble-100000") + " milliseconds");
        System.out.println("INTEGERS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + intBoxed.get("bubble-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intBoxed.get("bubble-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intBoxed.get("bubble-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intBoxed.get("bubble-100000") + " milliseconds");
        System.out.println("LONGS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + longPrimitive.get("bubble-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longPrimitive.get("bubble-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longPrimitive.get("bubble-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longPrimitive.get("bubble-100000") + " milliseconds");
        System.out.println("LONGS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + longBoxed.get("bubble-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longBoxed.get("bubble-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longBoxed.get("bubble-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longBoxed.get("bubble-100000") + " milliseconds");

        System.out.println("\n\nRESULTS - SELECTION SORT");
        System.out.println("INTEGERS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + intPrimitive.get("selection-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intPrimitive.get("selection-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intPrimitive.get("selection-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intPrimitive.get("selection-100000") + " milliseconds");
        System.out.println("INTEGERS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + intBoxed.get("selection-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intBoxed.get("selection-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intBoxed.get("selection-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intBoxed.get("selection-100000") + " milliseconds");
        System.out.println("LONGS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + longPrimitive.get("selection-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longPrimitive.get("selection-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longPrimitive.get("selection-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longPrimitive.get("selection-100000") + " milliseconds");
        System.out.println("LONGS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + longBoxed.get("selection-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longBoxed.get("selection-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longBoxed.get("selection-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longBoxed.get("selection-100000") + " milliseconds");

        System.out.println("\n\nRESULTS - MERGE SORT");
        System.out.println("INTEGERS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + intPrimitive.get("merge-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intPrimitive.get("merge-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intPrimitive.get("merge-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intPrimitive.get("merge-100000") + " milliseconds");
        System.out.println("INTEGERS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + intBoxed.get("merge-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intBoxed.get("merge-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intBoxed.get("merge-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intBoxed.get("merge-100000") + " milliseconds");
        System.out.println("LONGS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + longPrimitive.get("merge-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longPrimitive.get("merge-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longPrimitive.get("merge-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longPrimitive.get("merge-100000") + " milliseconds");
        System.out.println("LONGS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + longBoxed.get("merge-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longBoxed.get("merge-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longBoxed.get("merge-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100000, RESULT " + longBoxed.get("merge-100000") + " milliseconds");

        System.out.println("\n\nRESULTS - QUICK SORT");
        System.out.println("INTEGERS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + intPrimitive.get("quick-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intPrimitive.get("quick-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intPrimitive.get("quick-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intPrimitive.get("quick-100000") + " milliseconds");
        System.out.println("INTEGERS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + intBoxed.get("quick-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + intBoxed.get("quick-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + intBoxed.get("quick-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + intBoxed.get("quick-100000") + " milliseconds");
        System.out.println("LONGS PRIMITIVE");
        System.out.println("TEST SIZE - 100, RESULT " + longPrimitive.get("quick-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longPrimitive.get("quick-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longPrimitive.get("quick-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longPrimitive.get("quick-100000") + " milliseconds");
        System.out.println("LONGS BOXED");
        System.out.println("TEST SIZE - 100, RESULT " + longBoxed.get("quick-100") + " milliseconds");
        System.out.println("TEST SIZE - 1,000, RESULT " + longBoxed.get("quick-1000") + " milliseconds");
        System.out.println("TEST SIZE - 10,000, RESULT " + longBoxed.get("quick-10000") + " milliseconds");
        System.out.println("TEST SIZE - 100,000, RESULT " + longBoxed.get("quick-100000") + " milliseconds");

        // END OUTPUT
    }

    // Bubble sort, int primitive
    public static long bubbleSort(int[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    // Bubble sort, Integer boxed
    public static long bubbleSort(Integer[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    // Bubble sort, long primitive
    public static long bubbleSort(long[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    // Bubble sort, Long boxed
    public static long bubbleSort(Long[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    long temp = new Long(arr[j]);
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static long selectionSort(int[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static long selectionSort(Integer[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static long selectionSort(long[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            long temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static long selectionSort(Long[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            Long temp = new Long(arr[min_idx]);
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void mergeSort(int[] arr) {

        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[n - mid];

        // Copy elements to left and right subarrays
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }

        // Recursively sort left and right subarrays
        mergeSort(leftArr);
        mergeSort(rightArr);

        // Merge the sorted subarrays
        merge(arr, leftArr, rightArr);
    }
    public static long mergeSortHandler(int[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        mergeSort(arr);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int i = 0, j = 0, k = 0;
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        // Merge left and right subarrays
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of left subarray
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of right subarray
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void mergeSort(Integer[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Integer[] leftArr = new Integer[mid];
        Integer[] rightArr = new Integer[n - mid];

        // Copy elements to left and right subarrays
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }

        // Recursively sort left and right subarrays
        mergeSort(leftArr);
        mergeSort(rightArr);

        // Merge the sorted subarrays
        merge(arr, leftArr, rightArr);
    }

    public static long mergeSortHandler(Integer[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        mergeSort(arr);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void merge(Integer[] arr, Integer[] leftArr, Integer[] rightArr) {
        int i = 0, j = 0, k = 0;
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        // Merge left and right subarrays
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of left subarray
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of right subarray
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void mergeSort(long[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        long[] leftArr = new long[mid];
        long[] rightArr = new long[n - mid];

        // Copy elements to left and right subarrays
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }

        // Recursively sort left and right subarrays
        mergeSort(leftArr);
        mergeSort(rightArr);

        // Merge the sorted subarrays
        merge(arr, leftArr, rightArr);
    }
    public static long mergeSortHandler(long[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        mergeSort(arr);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void merge(long[] arr, long[] leftArr, long[] rightArr) {
        int i = 0, j = 0, k = 0;
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        // Merge left and right subarrays
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of left subarray
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of right subarray
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    public static void mergeSort(Long[] arr) {
        int n = arr.length;
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Long[] leftArr = new Long[mid];
        Long[] rightArr = new Long[n - mid];

        // Copy elements to left and right subarrays
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            rightArr[i - mid] = arr[i];
        }

        // Recursively sort left and right subarrays
        mergeSort(leftArr);
        mergeSort(rightArr);

        // Merge the sorted subarrays
        merge(arr, leftArr, rightArr);
    }
    public static long mergeSortHandler(Long[] arr) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        mergeSort(arr);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    public static void merge(Long[] arr, Long[] leftArr, Long[] rightArr) {
        int i = 0, j = 0, k = 0;
        int leftSize = leftArr.length;
        int rightSize = rightArr.length;

        // Merge left and right subarrays
        while (i < leftSize && j < rightSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements of left subarray
        while (i < leftSize) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements of right subarray
        while (j < rightSize) {
            arr[k++] = rightArr[j++];
        }
    }

    // 4 quick sorts go here

    // INT PRIMITIVE
    public static void quickSort(int[] arr, int begin, int end) {

        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    public static long quickSortHandler(int[] arr, int begin, int end) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        quickSort(arr, begin, end);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private static int partition(int[] arr, int begin, int end) {

        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    // END INT PRIMITIVE

    // INT BOXED
    public static void quickSort(Integer[] arr, int begin, int end) {


        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    public static long quickSortHandler(Integer[] arr, int begin, int end) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        quickSort(arr, begin, end);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private static int partition(Integer[] arr, int begin, int end) {
        Integer pivot = new Integer(arr[end]);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                Integer swapTemp = new Integer(arr[i]);
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Integer swapTemp = new Integer(arr[i + 1]);
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
    // END INT BOXED

    // LONG PRIMITIVE
    public static void quickSort(long[] arr, int begin, int end) {


        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    public static long quickSortHandler(long[] arr, int begin, int end) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        quickSort(arr, begin, end);

        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private static int partition(long[] arr, int begin, int end) {
        long pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                long swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        long swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
    // END LONG PRIMITIVE

    // LONG BOXED
    public static void quickSort(Long[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    public static long quickSortHandler(Long[] arr, int begin, int end) {
        long startTime = 0, endTime = 0;
        startTime = System.currentTimeMillis();

        quickSort(arr, begin, end);


        endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }

    private static int partition(Long[] arr, int begin, int end) {
        Long pivot = new Long(arr[end]);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                Long swapTemp = new Long(arr[i]);
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        Long swapTemp = new Long(arr[i + 1]);
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
    // END LONG BOXED

    public static void fetchData(int[] arr, String path) throws IOException {
        File file = new File(path);
        Scanner sc = new Scanner(file);

        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        sc.close();
    }

    public static Integer[] generateIntegerBoxed(int[] arr) {
        Integer[] boxed = new Integer[arr.length];
        for (int i = 0; i < boxed.length; i++)
            boxed[i] = Integer.valueOf(arr[i]);
        return boxed;
    }

    public static long[] generateLongPrimitive(int[] arr) {
        long[] longPrim = new long[arr.length];
        for (int i = 0; i < longPrim.length; i++)
            longPrim[i] = Integer.toUnsignedLong(arr[i]);
        return longPrim;
    }

    public static Long[] generateLongBoxed(int[] arr) {
        Long[] boxed = new Long[arr.length];
        for (int i = 0; i < boxed.length; i++)
            boxed[i] = Integer.toUnsignedLong(arr[i]);
        return boxed;
    }
}