import javax.swing.JOptionPane;

public class matrix_multiply {

    public static void main(String[] args) {
        // Input for Matrix A
        int rowsA = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows for Matrix A:"));
        int colsA = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns for Matrix A:"));
        int[][] matrixA = new int[rowsA][colsA];

        JOptionPane.showMessageDialog(null, "Enter the elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter element for Matrix A [" + (i + 1) + "][" + (j + 1) + "]:"));
            }
        }

        // Input for Matrix B
        int rowsB = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows for Matrix B:"));
        int colsB = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns for Matrix B:"));
        int[][] matrixB = new int[rowsB][colsB];

        JOptionPane.showMessageDialog(null, "Enter the elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = Integer.parseInt(
                        JOptionPane.showInputDialog("Enter element for Matrix B [" + (i + 1) + "][" + (j + 1) + "]:"));
            }
        }

        // Check if multiplication is possible
        if (colsA != rowsB) {
            JOptionPane.showMessageDialog(null, "Matrix multiplication is not possible with these dimensions.");
            return;
        }

        // Multiply matrices
        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB, rowsA, colsA, colsB);

        // Display the result
        StringBuilder result = new StringBuilder("Resulting Matrix:\n");
        for (int[] row : resultMatrix) {
            for (int element : row) {
                result.append(element).append(" ");
            }
            result.append("\n");
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB, int rowsA, int colsA, int colsB) {
        int[][] resultMatrix = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    resultMatrix[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return resultMatrix;
    }
}
