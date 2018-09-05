/**
 * Manages and runs the game and connects the game logic to the FXML
 * @author Rithwik Pattikonda
 * Teacher: Tracy Ishman
 * Date: 5/18/2018
 * Period: 2
 */
package tuyotuyo;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author rithw
 */
public class TuyoFXMLController implements Initializable, EventHandler<KeyEvent> {
    private SimpleStringProperty value;
    private Timeline timeline;
    private boolean moveable;
    private Grid grid;
   // private Timeline timeline;

    private Block[][] blocks;

    @FXML
    private Text score;

    @FXML
    private Button startButton;

    @FXML
    private GridPane mainGrid;
    
    @FXML 
    private Text gameover;

    /**
     * Initializer method called when the program is started
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        value = new SimpleStringProperty(this, "0");
        //System.out.println(url.toString());
        //System.out.println(rb.toString());
        startButton.requestFocus();
        startButton.setOnKeyPressed(this);
        score.textProperty().bind(value);
        timeline = null;

    }

    /**
     * Starts the game timer and runs the game
     */
    @FXML
    private void startGame(ActionEvent event) {
        gameover.setVisible(false);

        System.out.println("You clicked me!");
        if (startButton.getText().equals("Stop Game")) {
            startButton.setText("Start Game");
            stopGame();
        } else if (startButton.getText().equals("Start Game")) {
            startButton.setText("Stop Game");
                    moveable  = true;
                    grid = new Grid(20, 10);

            
             timeline = new Timeline(new KeyFrame(Duration.millis(200l), ev -> {
                 if (grid.gameDone()) {
                        stopGame();
                        System.out.println(grid.gameDone());
                     }
                     blocks = grid.updateGrid();
                     value.set(Integer.toString(grid.getScore()));
                refresh(blocks);
            }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
    }

    /**
     * Refreshes the Tetris grid with new block positions
     *
     * @param blocks block array to replace the grid with
     */
    private void refresh(Block[][] blocks) {
        startButton.requestFocus();
        mainGrid.getChildren().clear();
        for (int r = 0; r < blocks.length; r++) {
            for (int c = 0; c < blocks[r].length; c++) {
                if (blocks[r][c] != null) {
                    Rectangle rect = new Rectangle(0, 0, 40, 40);
                    rect.setFill(blocks[r][c].getColor());
                    rect.setStroke(Color.BLACK);
                    mainGrid.add(rect, c, r );
                }
            }
        }
    }

    /**
     * Stops the game and clears the grid
     */
    private void stopGame() {
        timeline.stop();
        mainGrid.getChildren().clear();
        gameover.setVisible(true);
    }

    /**
     * Handles keypresses to move and rotate the piece
     *
     * @param event the keyevent detected
     */
    @Override
    public void handle(KeyEvent event) {
        if(!moveable){
            
        }
        else if (event.getCode().toString().equals("LEFT")) {
            refresh(grid.left());
        }
        else if (event.getCode().toString().equals("RIGHT")) {
            refresh(grid.right());
        }
        else if (event.getCode().toString().equals("UP")) {
            refresh(grid.rotate());
        }

    }
}
