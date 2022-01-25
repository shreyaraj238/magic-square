/**
 * A utility class providing some methods to generate and check magic squares.
 *
 * @author  Shreya Raj
 * @version 46AisDone!
 */
public class MagicSquare
{
    // Step 2: Write a static method magicSquare() to generate a
    //         matrix representing a magic square of a gievn size.
    // 
    /**
     * Generates a matrix representing a magic square of a given size.
     *
     * @param  size the size of the matrix
     * @return a 2-D array of integers representing a magic square 
     *         of the given size
     */
    public static int[][] magicSquare(int size)
    {
        int[][] matrix = new int[size][size];
        int row = size - 1;
        int col = size / 2;
        for(int k = 1; k <= (size * size); k++)
        {
            matrix[row][col] = k;
            row++;
            col++;
            if(row == size)
            {
                row = 0;
            }
            if(col == size)
            {
                col = 0;
            }
            /*if(matrix[row][col] != 0)
            {
                row = previous row;
                col = previous col;
            }*/
        }
        
        return matrix;
    }

    // Step 3: Write a static method isMagicSquare() to
    //         determine if a 2-D array of integers is
    //         a magic square or not.
    //         A n by n array of integers is a magic 
    //         square if the sum of all elements in each
    //         row, in each column, and in the two diagonals
    //         is the same value.
    // 
    /**
     * Determines if a given n by n matrix is a magic square.
     * 
     * @param  matrix a 2-D array of integers
     * @return true if the 2-D array represents a magic square
     *         false otherwise
     */
    public static boolean isMagicSquare(int[][] matrix)
    {
        int size = matrix.length;
        
        // to calculate rows and cols
        int rowSum = 0;
        int colSum = 0;
        for(int r = 0; r < size; r++)
        {
            rowSum = 0;
            colSum = 0;
            // to reset for each row and column calculation
            for(int c = 0; c < size; c++)
            {
                colSum += matrix[r][c];
                rowSum += matrix[c][r];
                //need to cross check before incrementing i
            }
            
            
            if(rowSum != colSum)
            {
                return false;
            }
        }
        
        
        // to calculate diagonals
        int diagDown = 0;
        int diagUp = 0;
        for(int i = 0; i < size; i++)
        {
            diagDown += matrix[i][i];
            diagUp += matrix[i][(size - 1) - i];
                //same x value but adding upward
        }
        
        if(diagDown != diagUp)
        {
            return false;
        }
        
        //how to check if diagonal and row are the same
        if(diagDown != rowSum)
        {
            return false;
        }
        
        return true;
    }
}
