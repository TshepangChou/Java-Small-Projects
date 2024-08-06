import javax.swing.JOptionPane;

public class ArrayTraversal {

    public static void main(String[] args) {
        // Input for Matrix
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns:"));
        int[][] matrix = new int[rows][cols];

        JOptionPane.showMessageDialog(null, "Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter element [" + (i + 1) + "][" + (j + 1) + "]:"));
            }
        }

        // Traversing and printing the matrix
        StringBuilder matrixString = new StringBuilder("Matrix:\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixString.append(matrix[i][j]).append(" ");
            }
            matrixString.append("\n");
        }
        JOptionPane.showMessageDialog(null, matrixString.toString());

        // Calculating the sum of all elements
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }
        JOptionPane.showMessageDialog(null, "Sum of all elements: " + sum);

        // Finding the maximum element
        int max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum element: " + max);

        // Finding the minimum element
        int min = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Minimum element: " + min);
    }
}
