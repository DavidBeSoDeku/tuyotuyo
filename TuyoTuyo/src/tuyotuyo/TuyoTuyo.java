/**
 * Class to set up the stage and connect to the scene and FXML
 * @author Rithwik Pattikonda
 * Teacher: Tracy Ishman
 * Date: 5/18/2018
 * Period: 2
 */
package tuyotuyo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TuyoTuyo extends Application{
    
    /**
     * Sets up the stage with a scene designed with XML
     * @param stage on which the program runs
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TuyoFXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
    }

    /**
     * Main method
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
 
    
}
