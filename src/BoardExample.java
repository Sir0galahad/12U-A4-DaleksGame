
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author millc9988
 */
public class BoardExample {

    public static Color RandomCol() {
        double rand1 = (Math.random() * (255 - 0) + 0);
        double rand2 = (Math.random() * (255 - 0) + 0);
        double rand3 = (Math.random() * (255 - 0) + 0);
        int randA = (int) rand1;
        int randB = (int) rand2;
        int randC = (int) rand3;
        Color randCol = new Color(randA, randB, randC);
        return randCol;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Board b = new Board(8, 8);

        b.putPeg(Color.yellow, 4, 4);
        b.removePeg(4, 4);
        b.displayMessage("give me tendies reeeeee");
        while (true) {
            Coordinate click = b.getClick();
            int clickRow = click.getRow();
            int clickCol = click.getCol();
            b.putPeg(RandomCol(), clickRow, clickCol);
        }
    }
}
