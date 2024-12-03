




import CIE.Internals;
import SEE.External;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        String[] usns = new String[n];
        String[] names = new String[n];
        int[] semesters = new int[n];
        int[][] internalMarks = new int[n][5];  
        int[][] externalMarks = new int[n][5]; 

        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            
            System.out.println("\nEnter details for student " + (i + 1) + ":");
            
            System.out.print("Enter USN: ");
            usns[i] = scanner.nextLine();
            
            System.out.print("Enter Name: ");
            names[i] = scanner.nextLine();
            
            System.out.print("Enter Semester: ");
            semesters[i] = scanner.nextInt();
            
            System.out.println("Enter Internal marks (out of 50) for 5 courses:");
            for (int j = 0; j < 5; j++) {
                internalMarks[i][j] = scanner.nextInt();
            }
            
            System.out.println("Enter External marks (out of 100) for 5 courses:");
            for (int j = 0; j < 5; j++) {
                externalMarks[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            Internals studentInternal = new Internals(usns[i], names[i], semesters[i], internalMarks[i]);
            External studentExternal = new External(usns[i], names[i], semesters[i], internalMarks[i], externalMarks[i]);

            studentInternal.displayStudentInfo();
            studentInternal.displayInternalMarks();
            studentExternal.displayExternalMarks();

            System.out.println("Final Marks:");
            for (int j = 0; j < 5; j++) {
                int finalMarks = internalMarks[i][j] + externalMarks[i][j];
                System.out.println("Course " + (j + 1) + ": " + finalMarks);
            }

            System.out.println("Name: K.CHAITANYA");
            System.out.println("USN: 1BM23CS144");
        }

        scanner.close();
    }
}