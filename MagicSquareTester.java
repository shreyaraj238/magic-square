import java.util.Arrays;
import java.util.Scanner;
/**
 * A Java tester program for MagicSquare.
 */
public class MagicSquareTester
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the matrix size: ");
        int size = in.nextInt();

        int[][] matrix = MagicSquare.magicSquare(size);
        
        System.out.println(MagicSquare.isMagicSquare(matrix));
        System.out.println("Expected: true");
        
        for (int[] row: matrix)
            System.out.println(Arrays.toString(row));
            
        int temp = matrix[0][0];
        matrix[0][0] = matrix[matrix.length - 1][matrix[0].length - 1];
        matrix[matrix.length - 1][matrix[0].length - 1] = temp;
                   
        System.out.println(MagicSquare.isMagicSquare(matrix));
        System.out.println("Expected: false");
    }
}
