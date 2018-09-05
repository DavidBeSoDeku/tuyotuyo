/**
 * Piece.java
 * Creates a 4 by 4 array of blocks in various configurations
 * that resemble the common tetris pieces
 *
 * @author: Tristan Teacher: Tracy Ishman Period 2 Date: May 18 2018
 */
package tuyotuyo;

import java.util.*;

public class Piece {

    private enum PieceType {
        I_BLOCK, J_BLOCK, L_BLOCK, O_BLOCK, S_BLOCK, T_BLOCK, Z_BLOCK
    }

    private final int X_START = -1;
    private final int Y_START = -1;
    private PieceType type;
    public int pieceIndex;
    private List<Block[][]> rotations;

    /**
     * Instantiates a randomized piece of randomized colors
     */
    public Piece() {
        int randPiece = (int) (Math.random() * 7);
        switch (randPiece) {
            case 0:
                type = PieceType.I_BLOCK;
                break;
            case 1:
                type = PieceType.J_BLOCK;
                break;
            case 2:
                type = PieceType.L_BLOCK;
                break;
            case 3:
                type = PieceType.O_BLOCK;
                break;
            case 4:
                type = PieceType.S_BLOCK;
                break;
            case 5:
                type = PieceType.T_BLOCK;
                break;
            case 6:
                type = PieceType.Z_BLOCK;
                break;
        }
        rotations = createRotations();
        pieceIndex = (int) (Math.random() * 4);
    }

    /**
     * Creates Rotations configurations for all the piece types
     *
     * @return a 2d List of blocks configuration
     */
    private List<Block[][]> createRotations() {
        Block a = new Block();
        Block b = new Block();
        Block c = new Block();
        Block d = new Block();
        if (type.equals(PieceType.I_BLOCK)) {
            return createIBlock(a, b, c, d);
        }
        if (type.equals(PieceType.J_BLOCK)) {
            return createJBlock(a, b, c, d);
        }
        if (type.equals(PieceType.L_BLOCK)) {
            return createLBlock(a, b, c, d);
        }
        if (type.equals(PieceType.O_BLOCK)) {
            return createOBlock(a, b, c, d);
        }
        if (type.equals(PieceType.S_BLOCK)) {
            return createSBlock(a, b, c, d);
        }
        if (type.equals(PieceType.T_BLOCK)) {
            return createTBlock(a, b, c, d);
        }
        if (type.equals(PieceType.Z_BLOCK)) {
            return createZBlock(a, b, c, d);
        }
        return null;
    }

    /**
     * Creates an I shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of an I Block with the 4 given blocks
     */
    private List<Block[][]> createIBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] iPiece1 = {{a, null, null, null},
        {b, null, null, null},
        {c, null, null, null},
        {d, null, null, null}};
        Block[][] iPiece2 = {{d, c, b, a},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] iPiece3 = {{d, null, null, null},
        {c, null, null, null},
        {b, null, null, null},
        {a, null, null, null}};
        Block[][] iPiece4 = {{a, b, c, d},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        ret.add(iPiece1);
        ret.add(iPiece2);
        ret.add(iPiece3);
        ret.add(iPiece4);
        return ret;
    }

    /**
     * Creates a J shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of an J Block with the 4 given blocks
     */
    private List<Block[][]> createJBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] jPiece1 = {{null, a, null, null},
        {null, b, null, null},
        {c, d, null, null},
        {null, null, null, null}};
        Block[][] jPiece2 = {{c, null, null, null},
        {d, b, a, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] jPiece3 = {{d, c, null, null},
        {b, null, null, null},
        {a, null, null, null},
        {null, null, null, null}};
        Block[][] jPiece4 = {{a, b, d, null},
        {null, null, c, null},
        {null, null, null, null},
        {null, null, null, null}};
        ret.add(jPiece1);
        ret.add(jPiece2);
        ret.add(jPiece3);
        ret.add(jPiece4);
        return ret;
    }

    /**
     * Creates an L shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of an L Block with the 4 given blocks
     */
    private List<Block[][]> createLBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] lPiece1 = {{a, null, null, null},
        {b, null, null, null},
        {c, d, null, null},
        {null, null, null, null}};
        Block[][] lPiece2 = {{c, b, a, null},
        {d, null, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] lPiece3 = {{d, c, null, null},
        {null, b, null, null},
        {null, a, null, null},
        {null, null, null, null}};
        Block[][] lPiece4 = {{null, null, d, null},
        {a, b, c, null},
        {null, null, null, null},
        {null, null, null, null}};
        ret.add(lPiece1);
        ret.add(lPiece2);
        ret.add(lPiece3);
        ret.add(lPiece4);
        return ret;
    }

    /**
     * Creates an O shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of an O Block with the 4 given blocks
     */
    private List<Block[][]> createOBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] oPiece1 = {{a, b, null, null},
        {c, d, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] oPiece2 = {{c, a, null, null},
        {d, b, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] oPiece3 = {{d, c, null, null},
        {b, a, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] oPiece4 = {{b, d, null, null},
        {a, c, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        ret.add(oPiece1);
        ret.add(oPiece2);
        ret.add(oPiece3);
        ret.add(oPiece4);
        return ret;
    }

    /**
     * Creates an S shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of an S Block with the 4 given blocks
     */
    private List<Block[][]> createSBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] sPiece1 = {{null, c, d, null},
        {a, b, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] sPiece2 = {{a, null, null, null},
        {b, c, null, null},
        {null, d, null, null},
        {null, null, null, null}};
        Block[][] sPiece3 = {{null, b, a, null},
        {d, c, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] sPiece4 = {{d, null, null, null},
        {c, b, null, null},
        {null, a, null, null},
        {null, null, null, null}};
        ret.add(sPiece1);
        ret.add(sPiece2);
        ret.add(sPiece3);
        ret.add(sPiece4);
        return ret;
    }

    /**
     * Creates a T shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of a T Block with the 4 given blocks
     */
    private List<Block[][]> createTBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] tPiece1 = {{null, c, null, null},
        {a, b, d, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] tPiece2 = {{a, null, null, null},
        {b, c, null, null},
        {d, null, null, null},
        {null, null, null, null}};
        Block[][] tPiece3 = {{d, b, a, null},
        {null, c, null, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] tPiece4 = {{null, d, null, null},
        {c, b, null, null},
        {null, a, null, null},
        {null, null, null, null}};
        ret.add(tPiece1);
        ret.add(tPiece2);
        ret.add(tPiece3);
        ret.add(tPiece4);
        return ret;
    }

    /**
     * Creates a Z shaped block with the 4 given Blocks
     *
     * @param a A Block
     * @param b B Block
     * @param c C Block
     * @param d D Block
     * @return configuration of a Z Block with the 4 given blocks
     */
    private List<Block[][]> createZBlock(Block a, Block b, Block c, Block d) {
        List<Block[][]> ret = new ArrayList<>();
        Block[][] zPiece1 = {{a, b, null, null},
        {null, c, d, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] zPiece2 = {{null, a, null, null},
        {c, b, null, null},
        {d, null, null, null},
        {null, null, null, null}};
        Block[][] zPiece3 = {{d, c, null, null},
        {null, b, a, null},
        {null, null, null, null},
        {null, null, null, null}};
        Block[][] zPiece4 = {{null, d, null, null},
        {b, c, null, null},
        {a, null, null, null},
        {null, null, null, null}};
        ret.add(zPiece1);
        ret.add(zPiece2);
        ret.add(zPiece3);
        ret.add(zPiece4);
        return ret;
    }

    /**
     * Increases the piece index so as to go up one rotation configuration
     */
    public void rotate() {
        pieceIndex++;
        if (pieceIndex > rotations.size() - 1) {
            pieceIndex = 0;
        }
    }

    /**
     * returns the pieceIndex
     *
     * @return integer of the pieceIndex
     */
    public int getIndex() {
        return pieceIndex;
    }

    /**
     * Sets the pieceIndex to the given index
     *
     * @param ind index to set to
     */
    public void setIndex(int ind) {
        pieceIndex = ind;
    }

    /**
     * Returns the block configuration of the piece
     *
     * @return the block configuration of the piece
     */
    public Block[][] getBlockArray() {
        return rotations.get(pieceIndex);
    }

    /**
     * Converts the piece into a string for displaying
     *
     * @return the piece as a string
     */
    @Override
    public String toString() {
        String ret = "";
        Block[][] me = rotations.get(pieceIndex);
        for (int i = 0; i < me.length; i++) {
            ret += "[";
            for (int j = 0; j < me[i].length; j++) {
                if (me[i][j] != null) {
                    ret += "1";
                } else {
                    ret += "0";
                }
            }
            ret += "]\n";
        }
        return ret;
    }
}
