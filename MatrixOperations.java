import javax.swing.JOptionPane;

public class MatrixOperations {

    public static void main(String[] args) {
        // Input for Matrix A
        int rowsA = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows for Matrix A:"));
        int colsA = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns for Matrix A:"));
        int[][] matrixA = new int[rowsA][colsA];

        JOptionPane.showMessageDialog(null, "Enter the elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter element for Matrix A [" + (i + 1) + "][" + (j + 1) + "]:"));
            }
        }

        // Input for Matrix B
        int rowsB = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows for Matrix B:"));
        int colsB = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns for Matrix B:"));
        int[][] matrixB = new int[rowsB][colsB];

        JOptionPane.showMessageDialog(null, "Enter the elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter element for Matrix B [" + (i + 1) + "][" + (j + 1) + "]:"));
            }
        }

        // Matrix Addition
        if (rowsA == rowsB && colsA == colsB) {
            int[][] sumMatrix = addMatrices(matrixA, matrixB, rowsA, colsA);
            JOptionPane.showMessageDialog(null, "Matrix Addition Result:\n" + matrixToString(sumMatrix));
        } else {
            JOptionPane.showMessageDialog(null, "Matrix addition is not possible with these dimensions.");
        }

        // Matrix Subtraction
        if (rowsA == rowsB && colsA == colsB) {
            int[][] diffMatrix = subtractMatrices(matrixA, matrixB, rowsA, colsA);
            JOptionPane.showMessageDialog(null, "Matrix Subtraction Result:\n" + matrixToString(diffMatrix));
        } else {
            JOptionPane.showMessageDialog(null, "Matrix subtraction is not possible with these dimensions.");
        }

        // Matrix Multiplication
        if (colsA == rowsB) {
            int[][] productMatrix = multiplyMatrices(matrixA, matrixB, rowsA, colsA, colsB);
            JOptionPane.showMessageDialog(null, "Matrix Multiplication Result:\n" + matrixToString(productMatrix));
        } else {
            JOptionPane.showMessageDialog(null, "Matrix multiplication is not possible with these dimensions.");
        }
    }

    public static int[][] addMatrices(int[][] matrixA, int[][] matrixB, int rows, int cols) {
        int[][] sumMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sumMatrix;
    }

    public static int[][] subtractMatrices(int[][] matrixA, int[][] matrixB, int rows, int cols) {
        int[][] diffMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diffMatrix[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return diffMatrix;
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

    public static String matrixToString(int[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (int[] row : matrix) {
            for (int element : row) {
                result.append(element).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
