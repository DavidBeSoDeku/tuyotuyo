/**
 * The Block class stores a color and (x, y) coordinate,
 * and is able to move the block and return its color and rectangle
 *
 * @author Tristan Pior, Rithwik Path, David Brooks Teacher Name: Mrs.Ishman
 */
package tuyotuyo;

import java.util.*;
import javafx.scene.paint.Color;

public class Block {

    private final List<Color> colors = new ArrayList<>(Arrays.asList(Color.CYAN, Color.BLUE, Color.ORANGE,
            Color.YELLOW, Color.GREEN, Color.MAGENTA, Color.RED));
    private Color blockColor;

    /**
     * Instantiates a block with a random color
     */
    public Block() {
        blockColor = colors.get((int) (Math.random() * 7));
    }

    /**
     * Returns the block color
     *
     * @return Color the color of the block
     */
    public Color getColor() {
        return blockColor;
    }

    /**
     * Returns if the current block equals the given block in terms of color
     *
     * @param b block to compare against
     * @return if the current block equals the given block
     */
    public boolean equals(Block b) {
        if (blockColor.equals(b.getColor())) {
            return true;
        }
        return false;
    }

}
