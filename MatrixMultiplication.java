import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Matrix A
        System.out.println("Enter the number of rows for Matrix A:");
        int rowsA = scanner.nextInt();
        System.out.println("Enter the number of columns for Matrix A:");
        int colsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][colsA];

        System.out.println("Enter the elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        // Input for Matrix B
        System.out.println("Enter the number of rows for Matrix B:");
        int rowsB = scanner.nextInt();
        System.out.println("Enter the number of columns for Matrix B:");
        int colsB = scanner.nextInt();
        int[][] matrixB = new int[rowsB][colsB];

        System.out.println("Enter the elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Check if multiplication is possible
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication is not possible with these dimensions.");
            return;
        }

        // Multiply matrices
        int[][] resultMatrix = multiplyMatrices(matrixA, matrixB, rowsA, colsA, colsB);

        // Display the result
        System.out.println("Resulting Matrix:");
        printMatrix(resultMatrix);
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

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}