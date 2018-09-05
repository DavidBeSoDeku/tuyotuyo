/**
 * Grid.java
 * Creates a grid of blocks and keeps track of a user piece.
 * Deletes rows upon completion and deletes 4 adjacent with the
 * same color.
 *
 * @author: David Brooks
 * Teacher: Tracy Ishman
 * Period 2
 * Date: May 18 2018
 */
package tuyotuyo;

import java.util.*;
import javafx.scene.paint.Color;

public class Grid {

    private Block[][] del;
    private final int DONE = 3;
    private final int TUYO = 4;
    private final int BLOCKS = 4;
    public Block[][] grid;
    private Piece p;
    public Block[][] pieceG;
    public int score;
    public static String debugt = "";

    /**
     * Creates a new grid with the given number of rows and columns, inserts a
     * piece, and resets the score.
     *
     * @param row number of rows to instantiate the grid with
     * @param col number of columns to instantiate the grid with
     */
    public Grid(int row, int col) {
        grid = new Block[row][col];
        score = 0;
        insertPiece();
    }

    /**
     * Creates a new piece for the player
     */
    private void insertPiece() {
        p = new Piece();
        pieceG = new Block[grid.length][grid[0].length];
        int col = grid[0].length / 2 - p.getBlockArray()[0].length / 2;
        for (int r = 0; r < p.getBlockArray().length; r++) {
            for (int c = 0; c < p.getBlockArray()[0].length; c++) {
                pieceG[r][c + col] = p.getBlockArray()[r][c];
            }
        }
    }

    /**
     * Attempts to rotate the piece, checks if it would cause any issues doing
     * so and returns the either same grid or updated grid
     *
     * @return block[][] Returns the updated grid after attempting to rotate the
     * piece
     */
    public Block[][] rotate() {
        int ind = p.getIndex();
        Block[][] previousP = pieceG;

        p.rotate();
        int row = -1;
        int col = -1;
        System.out.println();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (pieceG[r][c] != null && row < 0) {
                    row = r;
                    col = c;
                } else if (pieceG[r][c] != null && c < col) {
                    col = c;
                }
            }
        }

        if (col + p.getBlockArray()[0].length - 1 > grid.length - 1) {
            col = grid.length - p.getBlockArray().length;
        }

        boolean canChange = true;
        int count = 0;
        pieceG = new Block[grid.length][grid[0].length];

        for (int r = 0; r < p.getBlockArray().length; r++) {
            if (r + row >= grid.length) {
                row = grid.length - r - 1;
            }
            if (r + row < 0) {
                row = 0;
            }
            for (int c = 0; c < p.getBlockArray()[0].length; c++) {
                System.out.println(r + row + " " + (c + col) + " " + r + " " + c);
                int add = 0;
                if (c + col >= grid[0].length) {
                    col = grid[0].length - c - 1;
                }
                if (c + col < 0) {
                    col = 0;
                }

                pieceG[r + row][c + col + add] = p.getBlockArray()[r][c];
                if (grid[r + row][c + col + add] != null) {
                    canChange = false;
                }
            }
        }

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (pieceG[r][c] != null) {
                    count++;
                }
            }
        }
        System.out.println("\n" + count);
        if (count < BLOCKS) {
            canChange = false;
        }

        if (canChange) {
            return getGrid();
        } else {
            System.out.println("reset");
            p.setIndex(ind);
            pieceG = previousP;
            return getGrid();
        }
    }

    /**
     * Attempts to move the piece to the right 1 space so long as it isn't at
     * the end edge of the grid and nothing is next to it
     *
     * @return block[][] Returns the updated grid after attempting to move the
     * piece to the right
     */
    public Block[][] right() {
        boolean canChange = true;
        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c = grid[r].length - 1; c >= 0; c--) {
                if (pieceG[r][c] != null) {
                    if (c == grid[r].length - 1 || grid[r][c + 1] != null) {
                        canChange = false;
                    }
                }
            }
        }

        if (canChange) {
            for (int r = grid.length - 1; r >= 0; r--) {
                for (int c = grid[r].length - 2; c >= 0; c--) {
                    if (pieceG[r][c] != null) {
                        pieceG[r][c + 1] = pieceG[r][c];
                        pieceG[r][c] = null;
                    }
                }
            }
        }
        return getGrid();
    }

    /**
     * Attempts to move the piece to the left 1 space so long as it isn't at the
     * end edge of the grid and nothing is next to it
     *
     * @return block[][] Returns the updated grid after attempting to move the
     * piece to the left
     */
    public Block[][] left() {
        boolean canChange = true;
        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c = 0; c < grid[r].length; c++) {
                if (pieceG[r][c] != null) {
                    if (c == 0 || grid[r][c - 1] != null) {
                        canChange = false;
                    }
                }
            }
        }

        if (canChange) {
            for (int r = grid.length - 1; r >= 0; r--) {
                for (int c = 1; c < grid[r].length; c++) {
                    if (pieceG[r][c] != null) {
                        pieceG[r][c - 1] = pieceG[r][c];
                        pieceG[r][c] = null;
                    }
                }
            }
        }
        return getGrid();
    }

    /**
     * Returns the integer score
     *
     * @return int returns the game score
     */
    public int getScore() {
        return score;
    }

    /**
     * Takes the piece grid and combines it with the block grid and returns the
     * combination for drawing.
     *
     * @return Block[][] grid and pieceG embedded together for drawing
     */
    private Block[][] getGrid() {
        Block[][] ret = new Block[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {

                if (pieceG[r][c] != null) {
                    ret[r][c] = pieceG[r][c];
                } else {
                    ret[r][c] = grid[r][c];
                }
            }
        }
        return ret;
    }

    /**
     * Checks if the piece has stopped moving. If so, it checks for a Tetris and
     * inserts a new piece. Otherwise it moves the piece down 1 space.
     *
     * @return Block[][] returns the updated grid for drawing
     */
    public Block[][] updateGrid() {
        debugt = "";
        if (pieceStopped()) {
            debugt += " tetris";

            tetris();
            insertPiece();
        } else {
            for (int r = grid.length - 1; r > 0; r--) {
                for (int c = 0; c < grid[r].length; c++) {
                    pieceG[r][c] = pieceG[r - 1][c];
                    pieceG[r - 1][c] = null;
                }
            }
        }
        return getGrid();
    }

    /**
     * Returns if the piece has stopped moving down or not
     *
     * @return boolean returns if the piece has stopped or not
     */
    private boolean pieceStopped() {
        boolean stop = false;

        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c = 0; c < grid[r].length; c++) {
                if (pieceG[r][c] != null) {
                    if (r == grid.length - 1) {
                        stop = true;
                        debugt += " going below ";
                    } else if (grid[r + 1][c] != null) {
                        stop = true;
                        debugt += " below is not null ";
                    }
                }
            }
        }

        if (stop) {
            score += 100;
        }
        return stop;
    }

    /**
     * Runs through and checks for completed rows, calling puyo as needed and
     * then deleting rows.
     */
    private void tetris() {
        debugt += "t";
        for (int r = grid.length - 1; r >= 0; r--) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == null) {
                    if (pieceG[r][c] != null) {
                        grid[r][c] = pieceG[r][c];
                        pieceG[r][c] = null;
                        puyo(r);
                    }
                }
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (pieceG[r][c] != null) {
                    puyo(r);
                }
            }
        }

        for (int r = grid.length - 1; r >= 0; r--) {
            boolean full = true;
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == null) {
                    full = false;
                }
            }

            if (full) {
                moveDown(r);
                puyo(r);
            }
        }
    }

    /**
     * Moves the grid down one row starting at the given row
     *
     * @param row row to start moving down at
     */
    private void moveDown(int row) {
        debugt += " remove row ";
        for (int r = row; r > 0; r--) {
            grid[r] = grid[r - 1];
        }
    }

    /**
     * Runs puyo for every block in the given row
     *
     * @param row row of blocks to be checked for puyo
     */
    private void puyo(int row) {
        debugt += " puyo ";
        for (int c = 0; c < grid[row].length; c++) {
            if (grid[row][c] != null) {
                del = new Block[grid.length][grid[row].length];
                if (puyo(row, c, grid[row][c].getColor()) >= TUYO) {
                    for (int r = 0; r < grid.length; r++) {
                        for (int col = 0; col < grid[r].length; col++) {
                            if (del[r][col] != null) {
                                grid[r][col] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns the number of blocks directly adjacent to the block of the given
     * row and column with the same color as the given one.
     *
     * @param row row of requested block to be checked
     * @param col col of requested block to be checked
     * @param c color to be checked against
     * @return int number of blocks directly adjacent with the same color
     */
    private int puyo(int row, int col, Color c) {
        int ret = 0;
        if (grid[row][col] != null && grid[row][col].getColor().equals(c) && del[row][col] == null) {
            ret += 1;
            del[row][col] = grid[row][col];
            if (row + 1 < grid.length) {
                ret += puyo(row + 1, col, c);
            }
            if (col + 1 < grid[0].length) {
                ret += puyo(row, col + 1, c);
            }
            if (row - 1 > 0) {
                ret += puyo(row - 1, col, c);
            }
            if (col - 1 > 0) {
                ret += puyo(row, col - 1, c);
            }
        }
        return ret;
    }

    /**
     * Return if the game is over or not by going out of bounds
     *
     * @return if the game is over or not
     */
    public Boolean gameDone() {
        boolean done = false;
        for (int c = 0; c < grid[DONE].length; c++) {

            if (grid[DONE][c] != null) {
                done = true;
            }
        }
        if (done) {
            debugt += " done ";
        }
        return done;
    }

    /**
     * Returns debug string of methods called
     *
     * @return string returns Debug Text
     */
    public static String debugT() {
        return debugt;
    }
}
