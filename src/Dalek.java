
/**
 * This class models a Delek in the game. A Delek has a position and can advance
 * towards the Doctor.
 */
public class Dalek {

    private int row, col;
    private boolean hasCrashed;

    /**
     * Initializes the variables for a Dalek.
     *
     * @param theRow The row this Dalek starts at.
     * @param theCol The column this Dalek starts at.
     */
    public Dalek(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
    }

    /**
     * Attempts to move the Dalek towards the Doctor by the most direct route,
     * moving up, down, right, left or diagonally. For example, if the Doctor is
     * above and to the right of a Dalek, it will move diagonally. If the Doctor
     * is directly below a Dalek, it will move down.
     *
     * @param doc The Doctor to move towards.
     */
    public void advanceTowards(Doctor doc) {
        if (!this.hasCrashed) {
            if (doc.getCol() > this.col) {
                this.col++;
            }
            if (doc.getCol() < this.col) {
                this.col--;
            }
            if (doc.getRow() > this.row) {
                this.row++;
            }
            if (doc.getRow() < this.row) {
                this.row--;
            }
        }
    }

    /**
     * Returns the row of this Dalek.
     *
     * @return This Dalek's row.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Returns the column of this Dalek.
     *
     * @return This Dalek's column.
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the Dalek to be in a crashed state.
     */
    public void crash() {
        this.hasCrashed = true;
    }

    /**
     * Returns whether or not this Dalek has crashed.
     *
     * @return true if this Dalek has crashed, false otherwise
     */
    public boolean hasCrashed() {
        if (this.hasCrashed) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param A put in a different dalek
     * @return if it runs into a different dalek
     */
    public boolean intersects(Dalek A) {
        if (this.row == A.getRow() && this.col == A.getCol()) {
            return true;
        } else {
            return false;
        }
    }
}
