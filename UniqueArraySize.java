// without hashset - no optimised
// Time Complexity:
// Sorting: O(nlog⁡n)
// Iteration: O(n)
// Overall: O(nlogn)

import java.util.Arrays;


public class UniqueArraySize {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10};
        
        int uniqueSize = getUniqueArraySize(array);
        System.out.println("Size of array with unique values: " + uniqueSize);
        
        // Print the unique values using the returned size
        for (int i = 0; i < uniqueSize; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int getUniqueArraySize(int[] array) {
        // Sort the array to bring duplicates together
        Arrays.sort(array);
        
        // Initialize a variable to keep track of the unique elements' index
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            // If the current element is different from the previous one, it's unique
            if (i == 0 || array[i] != array[i - 1]) {
                array[index++] = array[i];
            }
        }
        
        // Return the size of the unique values
        return index;
    }
}
//-----------------------------------------------------------------------------------------------------------------
//using Hashset - optimised
// Time Complexity: O(n)
// Space Complexity: O(n) due to the HashSet storing unique elements.
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueArraySize {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10};
        
        int uniqueSize = getUniqueArraySize(array);
        System.out.println("Size of array with unique values: " + uniqueSize);
        
        // Print the unique values using the returned size
        for (int i = 0; i < uniqueSize; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int getUniqueArraySize(int[] array) {
        // Use a HashSet to store unique values
        Set<Integer> uniqueValues = new HashSet<>();
        int index = 0;

        for (int num : array) {
            if (uniqueValues.add(num)) {
                array[index++] = num;
            }
        }
        
        // Return the size of the unique values
        return index;
    }
}
