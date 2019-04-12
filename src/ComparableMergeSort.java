/* ComparableMergeSort.java - Perform a merge sort on an array of Comparable Objects
 * Author:     Will Craycroft
 * Module:     8
 * Project:    Lab Project 2
 * Description: This class uses a merge-sort algorithm to sort and array of Comparable Objects
 *
 *    Instance Variables
 *       (none)
 *
 *    Methods:
 *       sort - performs a recursive sort using merge sort algorithm
 *       split - determines midpoints between two points
 *       join - joins two sorted arrays of doubles into a single array
 */

public class ComparableMergeSort {

    public static void sort(Comparable[] a, int begin, int end) {

        // If sorting more than one element, then perform a sort, otherwise
        // do nothing
        if ((end - begin) >= 1) {

            /*******************************************************************
             * Determine the midpoint between the part of the part of the array
             * to be sorted
             ******************************************************************/
            int splitPoint = split(a, begin, end) ;

            /*************************************************
             * Sort the left chunk, then sort the right chunk
             *************************************************/
            sort(a, begin, splitPoint) ;
            sort(a, splitPoint + 1, end) ;

            /*******************************************************
             * Merge the two chunks back into a single sorted array
             *******************************************************/
            join(a, begin, splitPoint, end) ;

        }
    }

    // Determine the midpoint between the beginning and ending indexes
    private static int split(Comparable[] a, int begin, int end) {
        return (begin + end) / 2 ;
    }

    // Join two sub arrays (assumed to be sorted) into a single sorted array
    // using a temporary array to hold the results, then copy back into the
    // original array
    private static void join(Comparable[] a, int begin, int splitPoint, int end) {

        // Create a temporary array to hold new sorted array resulting from
        // merging left and right chunks of array
        Comparable[] temp;
        int intervalSize = (end - begin + 1);
        temp = new Comparable[intervalSize];

        // Left chunk extends from a[index] to a[splitPoint]
        // Right chunk extends from a[splitPoint + 1] to a[end]
        int nextLeft = begin; //index for first chunk
        int nextRight = splitPoint + 1; //index for second chunk
        int i = 0; //index into temporary array

        // Merge until one side is exhausted, taking the next smallest element
        // from either the left or right chunk
        while ((nextLeft <= splitPoint) && (nextRight <= end)) {
            if (a[nextLeft].compareTo(a[nextRight]) < 0) {
                temp[i++] = a[nextLeft++];
            } else {
                temp[i++] = a[nextRight++];
            }
        }

        // Copy the rest of the left chunk, if any is left
        while (nextLeft <= splitPoint) {
            temp[i++] = a[nextLeft++];
        }

        // Copy the rest of the right chunk, if any if left
        while (nextRight <= end) {
            temp[i++] = a[nextRight++];
        }

        // Copy the sorted array (in temp) back to original array
        for (i = 0; i < intervalSize; i++) {
            a[begin + i] = temp[i];
        }
    }
}
