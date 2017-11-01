
import java.awt.Color;

/**
 * This class manages the interactions between the different pieces of the game:
 * the Board, the Daleks, and the Doctor. It determines when the game is over
 * and whether the Doctor won or lost.
 */
public class CatchGame {

    /**
     * Instance variables go up here Make sure to create a Board, 3 Daleks, and
     * a Doctor
     */
    Board b = new Board(12, 12);
    Doctor D = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek one = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek two = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    Dalek three = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
    boolean run = true;
    boolean win = false;

    /**
     * The constructor for the game. Use it to initialize your game variables.
     * (create people, set positions, etc.)
     */
    public CatchGame() {
        b.putPeg(Color.black, one.getRow(), one.getCol());
        b.putPeg(Color.black, two.getRow(), two.getCol());
        b.putPeg(Color.black, three.getRow(), three.getCol());
        b.putPeg(Color.green, D.getRow(), D.getCol());
    }

    /**
     * The playGame method begins and controls a game: deals with when the user
     * selects a square, when the Daleks move, when the game is won/lost.
     */
    public void playGame() {
        while (run) {
            //movement
            Coordinate click = b.getClick();
            b.removePeg(D.getRow(), D.getCol());
            b.removePeg(one.getRow(), one.getCol());
            b.removePeg(two.getRow(), two.getCol());
            b.removePeg(three.getRow(), three.getCol());
            D.move(click.getRow(), click.getCol());
            one.advanceTowards(D);
            two.advanceTowards(D);
            three.advanceTowards(D);

            //collision between daleks
            if (one.intersects(two)) {
                one.crash();
                two.crash();
            }
            if (two.intersects(three)) {
                two.crash();
                three.crash();
            }
            if (one.intersects(three)) {
                one.crash();
                three.crash();
            }

            //placing pegs after everything has crash tested
            b.putPeg(Color.green, D.getRow(), D.getCol());
            b.putPeg(Color.black, one.getRow(), one.getCol());
            b.putPeg(Color.black, two.getRow(), two.getCol());
            b.putPeg(Color.black, three.getRow(), three.getCol());
            if (one.hasCrashed()) {
                b.putPeg(Color.red, one.getRow(), one.getCol());
            }
            if (two.hasCrashed()) {
                b.putPeg(Color.red, two.getRow(), two.getCol());
            }
            if (three.hasCrashed()) {
                b.putPeg(Color.red, three.getRow(), three.getCol());
            }

            //checking if the doctor is caught by any of the daleks and checking the win conditions
            D.caught(one);
            D.caught(two);
            D.caught(three);
            if (!D.isAlive()) {
                run = false;
                win = false;
            }
            if (one.hasCrashed() && two.hasCrashed() && three.hasCrashed()) {
                run = false;
                win = true;
            }
            //for flavour
            b.displayMessage("EXTERMINATE!!!");
        }
            //if you win
        if (win) {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    b.putPeg(Color.GREEN, i, j);
                }
            }
            b.displayMessage("You win!");
            //if you lose
        } else {
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    b.putPeg(Color.BLACK, i, j);
                }
            }
            b.displayMessage("You lose!");
        }
    }
}
