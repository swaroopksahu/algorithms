/**
 *
 In quick sort, we pick a random element and partition the array, such that all numbers that are less than the partitioning element come before all elements that are greater than it. The partitioning can be performed efficiently through a series of swaps (see below).
 If we repeatedly partition the array (and its sub-arrays) around an element, the array will eventually become sorted. However, as the partitioned element is not guaranteed to be the median (or anywhere near the median), our sorting could be very slow.This is the reason for the 0 (n2) worst case runtime.
 *
 * Runtime: 0 (n log (n)) average, 0 (n2) worst case.
 * Memory: 0 (log (n) )
 */

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};

        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        int index = partition(arr, left, right);

        if(left < index-1){ // Sort the left half
            quickSort(arr, left, index-1);
        }
        if(index < right){  // Sort right half
            quickSort(arr, index, right);
        }
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[(left + right) / 2];    // Pick pivot point

        while (left <= right) {
            // Find element on left that should be on right
            while (arr[left] < pivot)
                left ++;
            // Find element on right that should be on left
            while (arr[right] > pivot)
                right --;

            // Swap elements, and move left and right indices
            if  (left <= right) {
                swap(arr, left, right); // swaps elements
                left++;
                right--;
            }
        }
        return left;
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}