
package SEE;

import CIE.Internals;

public class External extends Internals {
    protected int[] externalMarks = new int[5];

    public External(String usn, String name, int semester, int[] internalMarks, int[] externalMarks) {
        super(usn, name, semester, internalMarks);
        this.externalMarks = externalMarks;
    }

    public void displayExternalMarks() {
        System.out.println("External Marks (out of 100):");
        for (int i = 0; i < 5; i++) {
            System.out.println("Course " + (i + 1) + ": " + externalMarks[i]);
        }
    }
}
