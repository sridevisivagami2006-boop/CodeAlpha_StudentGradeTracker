import java.util.ArrayList;
import java.util.Scanner;
class Student {
    String name;
    ArrayList<Integer> marks;
    double average;
    int highest;
    int lowest;
    char grade;

    public Student(String name, ArrayList<Integer> marks) {
        this.name = name;
        this.marks = marks;
        calculateResults();
    }

    private void calculateResults() {
        int total = 0;
        highest = marks.get(0);
        lowest = marks.get(0);

        for (int mark : marks) {
            total += mark;

            if (mark > highest)
                highest = mark;

            if (mark < lowest)
                lowest = mark;
        }

        average = (double) total / marks.size();

        if (average >= 90)
            grade = 'A';
        else if (average >= 80)
            grade = 'B';
        else if (average >= 70)
            grade = 'C';
        else if (average >= 60)
            grade = 'D';
        else
            grade = 'F';
    }

    public void displayReport() {
        System.out.println("\n----------------------------");
        System.out.println("Student Name : " + name);
        System.out.println("Marks        : " + marks);
        System.out.printf("Average      : %.2f\n", average);
        System.out.println("Highest Mark : " + highest);
        System.out.println("Lowest Mark  : " + lowest);
        System.out.println("Grade        : " + grade);
        System.out.println("----------------------------");
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter Number of Students: ");
        int studentCount = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= studentCount; i++) {

            System.out.println("\nEnter Details for Student " + i);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Number of Subjects: ");
            int subjectCount = sc.nextInt();

            ArrayList<Integer> marks = new ArrayList<>();

            for (int j = 1; j <= subjectCount; j++) {
                System.out.print("Enter Mark " + j + ": ");
                marks.add(sc.nextInt());
            }

            sc.nextLine();

            students.add(new Student(name, marks));
        }

        System.out.println("\n========== STUDENT REPORT ==========");

        for (Student student : students) {
            student.displayReport();
        }

        System.out.println("\nTotal Students: " + students.size());

        sc.close();
    }
}