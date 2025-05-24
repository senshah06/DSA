public class FlattenArray {
    public static void main(String[] args) {
        int[][] array2D = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] array1D = flatten2DArray(array2D);

        // Print the flattened 1D array
        for (int num : array1D) {
            System.out.print(num + " ");
        }
    }

    public static int[] flatten2DArray(int[][] array2D) {
        int rows = array2D.length;
        int cols = array2D[0].length;
        int[] array1D = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array1D[index++] = array2D[i][j];
            }
        }

        return array1D;
    }
}
//-----------------------------------------------------------------------------------
//using stream api
import java.util.Arrays;

public class FlattenArray {
    public static void main(String[] args) {
        int[][] array2D = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] array1D = Arrays.stream(array2D)
                              .flatMapToInt(Arrays::stream)
                              .toArray();

        // Print the flattened 1D array
        for (int num : array1D) {
            System.out.print(num + " ");
        }
    }
}
