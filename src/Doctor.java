
/**
 * This class models the Doctor in the game. A Doctor has a position and can
 * move to a new position.
 */
public class Doctor {

    private int row, col;
    private boolean alive;

    /**
     * Initializes the variables for a Doctor.
     *
     * @param theRow The row this Doctor starts at.
     * @param theCol The column this Doctor starts at.
     */
    public Doctor(int theRow, int theCol) {
        this.row = theRow;
        this.col = theCol;
        alive = true;
    }

    /**
     * Move the Doctor. If the player clicks on one of the squares immediately
     * surrounding the Doctor, the peg is moved to that location. Clicking on
     * the Doctor does not move the peg, but instead allows the Doctor to wait
     * in place for a turn. Clicking on any other square causes the Doctor to
     * teleport to a random square (perhaps by using a �sonic screwdriver�).
     * Teleportation is completely random.
     *
     * @param newRow The row the player clicked on.
     * @param newCol The column the player clicked on.
     */
    public void move(int newRow, int newCol) {
        if (newRow > this.row + 1 || newRow < this.row - 1 || newCol > this.col + 1 || newCol < this.col - 1) {
            this.col = (int) (Math.random() * 12);
            this.row = (int) (Math.random() * 12);
        } else {
            if (newRow == this.row + 1) {
                this.row++;
            } else if (newRow == this.row - 1) {
                this.row--;
            }
            if (newCol == this.col + 1) {
                this.col++;
            } else if (newCol == this.col - 1) {
                this.col--;
            }
        }

    }

    /**
     * Returns the row of this Doctor.
     *
     * @return This Doctor's row.
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column of this Doctor.
     *
     * @return This Doctor's column.
     */
    public int getCol() {
        return col;
    }

    /**
     * returns if the doctor is alive
     *
     * @return true if the doctor is alive
     */
    public boolean isAlive() {
        if (alive) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Setting the doctor to dead if there is a dalek on the same spot as the
     * dalek
     *
     * @param D a dalek that you feed in
     */
    public void caught(Dalek D) {
        if (row == D.getRow() && col == D.getCol()) {
            alive = false;
        }
    }
}
