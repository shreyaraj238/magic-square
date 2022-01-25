/**
 * A utility class providing some methods to generate and check magic squares.
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Shreya Raj
 * @version 46AisDone!
 */
public class MagicSquare
{
    // Step 2: Write a static method magicSquare() to generate a
    //         matrix representing a magic square of a gievn size.
    // You MUST follow the following pseudocode to write the code.
    // No credit otherwise.
    // Write the method below the method comment block.
    // Do not mix your code with the pseudocode.
    //
    // Create a 2-D array of type integers of 'size' rows and 'size' columns
    // Set 2 variables row, col where row = size - 1, col = size / 2
    // For k = 1, 2, ..., (size * size)
    //     Set matrix[row][col] to k
    //     Increment both row and col by one
    //     if row equals size, replace it with 0
    //     if col equals size, replace it with 0
    //     If matrix[row][col] is not zero
    //        Set row and col to their values before increment
    //Hint:   (you may need additional variables to store these "previous"
    //        values before you increment)
    //        Decrement row by one
    // Return matrix
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
    // Hint:   For all elements in the main diagonal, 
    //         the row index is the same as the column index.
    // Hint:   For all elements in the counter diagonal, 
    //         the sum of the row index and the column index is
    //         size - 1, assuming both indexes start with 0.
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
