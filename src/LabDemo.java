import java.util.Arrays;

public class LabDemo {

    public static void main(String[]args)
    {
        // Instantiate array of arrays with Comparable object values
        Comparable[][] comparableArrays = {new Character[] {'c', '6', 'h', 'a', '!', '<'},
                                 new Integer[] {5, -1, 2, 16, -12, 7},
                                 new Double[] {16.7, 12.0, 2.9, -10.7, 1.0, 6.43},
                                 new String[] {"world", "hello", "!", "123abc", "zebra", "a String"}};

        // Loop through arrays
        for (Comparable[] comparableArray : comparableArrays)
        {
            // Print before array
            System.out.println("Unsorted " + comparableArray.getClass().getSimpleName() + " array: " + Arrays.toString(comparableArray));
            // Sort arrays using ComparableMergeSort class
            ComparableMergeSort.sort(comparableArray, 0, comparableArray.length - 1);
            // Print sorted array
            System.out.println("  Sorted " + comparableArray.getClass().getSimpleName() + " array: " + Arrays.toString(comparableArray) + "\n");
        }
    }
}
