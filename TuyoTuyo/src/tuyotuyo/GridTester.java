/**
 * GridTester.java
 * Tests the grid class to make sure the grid is working properly
 *
 * @author: David Brooks Teacher: Tracy Ishman Period 2 Date: May 18 2018
 */
package tuyotuyo;

import java.util.*;

public class GridTester {

    public static Timer timer;
    public static Grid g;

    /**
     *
     *
     */
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Block[][] gr = g.updateGrid();

                for (Block[] r : gr) {

                    for (Block c : r) {
                        if (c != null) {
                            System.out.print("n");
                        } else {
                            System.out.print(",");
                        }
                    }
                    System.out.println();
                }

                System.out.println(g.debugT());
                System.out.println(g.getScore() + "a");
                System.out.println(g.gameDone());
                System.out.println(g.pieceG.length + " " + g.pieceG[0].length);

            }
        };
        g = new Grid(14, 10);
        timer = new Timer();
        timer.scheduleAtFixedRate(task, 500l, 500l);
    }
}
