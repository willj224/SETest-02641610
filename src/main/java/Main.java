import assessments.AssessmentFeed;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Student> students = new ArrayList<>();
        for (String CID : AssessmentFeed.getCIDs()) {
            students.add(new Student(CID));
        }
        printReport(students);
        SwingUtilities.invokeLater(() -> displayResults(students));

    }

     private static void printReport(List<Student> students) {
        for (Student student : students) {
            System.out.printf("%s | CID: %s | %s%n", student.getName(), student.getCID(), student.getYear());
            for (Assessments assessment : students.getFirst().getAsssessments()) {
                System.out.printf("  %s:%n", assessment.getTitle(), assessment.CalculatGrade());
            }

        }
        System.out.println("  Overall module mark: " + students.getFirst().modulePercentage());
        System.out.println();
    }

     private static void displayResults(List<Student> students) {
        String[] headings = {"Student", "CID", "Type", AssessmentFeed.PROGRAMMING_TEST,
                AssessmentFeed.AI_PROJECT, AssessmentFeed.DESIGN_VIVA, "Overall module mark"};

        String[][] rows = new String[students.size()][headings.length];
        for (int row = 0; row < students.size(); row++) {
            Student student = students.get(row);
            rows[row] = new String[]{student.getName(), student.getCID(), student.getName(),
                    student.markFor(AssessmentFeed.PROGRAMMING_TEST), student.markFor(AssessmentFeed.AI_PROJECT),
                    student.markFor(AssessmentFeed.DESIGN_VIVA),student.modulePercentage()};

        }
        JTable table = new JTable(rows, headings);
        JFrame frame = new JFrame("Software Engineering Module Results");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}