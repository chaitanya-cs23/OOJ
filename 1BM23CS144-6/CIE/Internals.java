
package CIE;

public class Internals extends Student {
    protected int[] internalMarks = new int[5];

    public Internals(String usn, String name, int semester, int[] internalMarks) {
        super(usn, name, semester);
        this.internalMarks = internalMarks;
    }

    public void displayInternalMarks() {
        System.out.println("Internal Marks (out of 50):");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + internalMarks[i]);
        }
    }
}