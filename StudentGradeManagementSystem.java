import javax.swing.*;
import java.util.ArrayList;

/**
 * Class to represent a student.
 */
class Student {
    private String name;
    private ArrayList<Double> grades;

    /**
     * Constructor to initialize the student with a name.
     *
     * @param name The name of the student.
     */
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a grade to the student's list of grades.
     *
     * @param grade The grade to be added.
     */
    public void addGrade(double grade) {
        grades.add(grade);
    }

    /**
     * Updates a grade at a specific index in the student's list of grades.
     *
     * @param index The index of the grade to be updated.
     * @param grade The new grade.
     */
    public void updateGrade(int index, double grade) {
        if (index >= 0 && index < grades.size()) {
            grades.set(index, grade);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid index.");
        }
    }

    /**
     * Calculates the average grade of the student.
     *
     * @return The average grade.
     */
    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }

    /**
     * Gets the list of grades as a string.
     *
     * @return A string representation of the grades.
     */
    public String getGrades() {
        return grades.toString();
    }
}

/**
 * Main class to manage student grades.
 */
public class StudentGradeManagementSystem {
    private ArrayList<Student> students;

    /**
     * Constructor to initialize the student grade management system.
     */
    public StudentGradeManagementSystem() {
        students = new ArrayList<>();
    }

    /**
     * Adds a student to the system.
     *
     * @param name The name of the student to be added.
     */
    public void addStudent(String name) {
        students.add(new Student(name));
    }

    /**
     * Finds a student by name.
     *
     * @param name The name of the student to find.
     * @return The student object if found, otherwise null.
     */
    public Student findStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Main method to run the student grade management system.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        StudentGradeManagementSystem system = new StudentGradeManagementSystem();

        while (true) {
            String[] options = {"Add Student", "Add Grade", "Update Grade", "Calculate Average Grade", "Print Student Grades", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an option", "Student Grade Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    String name = JOptionPane.showInputDialog("Enter student name:");
                    if (name != null && !name.trim().isEmpty()) {
                        system.addStudent(name);
                        JOptionPane.showMessageDialog(null, "Student added.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid name.");
                    }
                    break;
                case 1:
                    name = JOptionPane.showInputDialog("Enter student name:");
                    if (name != null) {
                        Student student = system.findStudent(name);
                        if (student != null) {
                            String gradeStr = JOptionPane.showInputDialog("Enter grade:");
                            try {
                                double grade = Double.parseDouble(gradeStr);
                                student.addGrade(grade);
                                JOptionPane.showMessageDialog(null, "Grade added.");
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid grade.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Student not found.");
                        }
                    }
                    break;
                case 2:
                    name = JOptionPane.showInputDialog("Enter student name:");
                    if (name != null) {
                        Student student = system.findStudent(name);
                        if (student != null) {
                            String indexStr = JOptionPane.showInputDialog("Enter grade index to update:");
                            try {
                                int index = Integer.parseInt(indexStr);
                                String newGradeStr = JOptionPane.showInputDialog("Enter new grade:");
                                double newGrade = Double.parseDouble(newGradeStr);
                                student.updateGrade(index, newGrade);
                                JOptionPane.showMessageDialog(null, "Grade updated.");
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid input.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Student not found.");
                        }
                    }
                    break;
                case 3:
                    name = JOptionPane.showInputDialog("Enter student name:");
                    if (name != null) {
                        Student student = system.findStudent(name);
                        if (student != null) {
                            double average = student.calculateAverage();
                            JOptionPane.showMessageDialog(null, "Average grade: " + average);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student not found.");
                        }
                    }
                    break;
                case 4:
                    name = JOptionPane.showInputDialog("Enter student name:");
                    if (name != null) {
                        Student student = system.findStudent(name);
                        if (student != null) {
                            String grades = student.getGrades();
                            JOptionPane.showMessageDialog(null, "Grades: " + grades);
                        } else {
                            JOptionPane.showMessageDialog(null, "Student not found.");
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }
}
