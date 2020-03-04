/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showautomata;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * * @author ENG ALAA AL_KHEDER
 */
public class FXMLDocumentController implements Initializable {

    @FXML // fx:id="usernameTextfield"
    private Pane pane; // Value injected by FXMLLoader
    @FXML
    private Button test;

    @FXML
    private Label label;

    @FXML
    private TextField testfieald;

    @FXML
    private Button browse;

    @FXML
    private Label Automataname;

    @FXML
    private Label result;
    JSONParser parser = new JSONParser();
    String alphabet;
    ArrayList<Integer> states;
    ArrayList<String> tran;
    ArrayList<String> resltString;

    String i_s;
    int IS;
    int FS;
    ArrayList<String> f_s = new ArrayList<>();
    Integer A[][];
    char[] alph1;
    JSONObject jsonobject;
    File select;

    @FXML
    void browse(ActionEvent event) {
//result.setText(testfieald.getText());
        test.setDisable(false);
        Object obj;

        try {
            obj = parser.parse(new FileReader(select));

            jsonobject = (JSONObject) obj;
//            ArrayList<Character> alphabet = (ArrayList<Character>) jsonobject.get("alphabet");
            alphabet = (String) jsonobject.get("alphabet");
            alphabet = alphabet.toLowerCase();
            System.out.println("Alph" + alphabet);
            states = (ArrayList<Integer>) jsonobject.get("states");
            System.out.println("states" + states);
            tran = (ArrayList<String>) jsonobject.get("transaction");
            System.out.println("tran" + tran);
            i_s = (String) jsonobject.get("initial_state");
            IS = Integer.parseInt(i_s);
            f_s = (ArrayList<String>) jsonobject.get("final_states");
            resltString= (ArrayList<String>) jsonobject.get("resultText");
//              FS = Integer.parseInt(f_s);
            A = new Integer[states.size()][alphabet.length()];
            alph1 = alphabet.toCharArray();

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void test(ActionEvent event) {
        test.setDisable(true);
//         ArrayList<String> tran1=tran;
        System.out.println("tran" + tran);
        String hh = testfieald.getText();//enter the user
        char[] User_input = hh.toCharArray();
        for (int i = 0; i < alph1.length; i++) {
            for (int j = 0; j < User_input.length; j++) {
                if (User_input[j] == alph1[i]) {
                    User_input[j] = '`';
                }
            }
        }
        //check the seq
        for (int j = 0; j < User_input.length; j++) {
            System.out.println("///////" + User_input[j]);
            if (User_input[j] != '`') {
                result.setText("Dont belong to the alphabet");
                return;
            }
        }

        User_input = hh.toCharArray();
        int curent_states = IS;
        String q, m = "-1";
//          tran.remove(0);
        int transmition[][] = new int[states.size()][alphabet.length()];
        System.out.println("tran.len  " + tran.size() + "     " + alph1[0] + "   " + alphabet.length());
        for (int i = 0; i < states.size(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
//                    System.out.println("zzzzzzz"+ i+j +" : "+tran.get(0));
                q = tran.get(0);
                transmition[i][j] = Integer.parseInt(q);//Integer.parseInt(q) ;
//                System.out.println("**"+);
                tran.remove(0);
            }
        }
        int c = 0;
        for (int i = 0; i < User_input.length; i++) {

            for (int j = 0; j < alph1.length; j++) {
                {
                    if (User_input[i] == alph1[j]) {
                        c = j;
                    }
                }
            }
            curent_states = (int) transmition[curent_states][c];
            System.out.println(curent_states);
            if (curent_states == -1) {
                break;
            }
        }
        String s = String.valueOf(curent_states);
        String b;
        
//if(resltString.isEmpty()){
        if (f_s.contains(s)) {
            result.setText("True");

        } else {
            result.setText("False");
        }
//    }
//else{
//    String b=f_s.indexOf(curent_states);
//int c=Integer.parseInt(b);
//      result.setText(resltString.get((curent_states)));
//    
//}

//       tran=tran1; 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        FileChooser a = new FileChooser();
        a.setInitialDirectory(new File(System.getProperty("user.home")));
        select = a.showOpenDialog(ShowAutomata.stage1);

        browse.setText("lode Rouls");
        test.setDisable(true);
        int numberOfSquares = 30;
        while (numberOfSquares > 0) {
            generateAnimation();
            numberOfSquares--;

        }
        // TODO
    }

    public void generateAnimation() {
        Random rand = new Random();
        int sizeOfSqaure = rand.nextInt(50) + 1;
        int speedOfSqaure = rand.nextInt(10) + 5;
        int startXPoint = rand.nextInt(420);
        int startYPoint = rand.nextInt(350);
        int direction = rand.nextInt(5) + 1;

        KeyValue moveXAxis = null;
        KeyValue moveYAxis = null;
        Rectangle r1 = null;

        switch (direction) {
            case 1:
                // MOVE LEFT TO RIGHT
                r1 = new Rectangle(0, startYPoint, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), 350 - sizeOfSqaure);
                break;
            case 2:
                // MOVE TOP TO BOTTOM
                r1 = new Rectangle(startXPoint, 0, sizeOfSqaure, sizeOfSqaure);
                moveYAxis = new KeyValue(r1.yProperty(), 420 - sizeOfSqaure);
                break;
            case 3:
                // MOVE LEFT TO RIGHT, TOP TO BOTTOM
                r1 = new Rectangle(startXPoint, 0, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), 350 - sizeOfSqaure);
                moveYAxis = new KeyValue(r1.yProperty(), 420 - sizeOfSqaure);
                break;
            case 4:
                // MOVE BOTTOM TO TOP
                r1 = new Rectangle(startXPoint, 420 - sizeOfSqaure, sizeOfSqaure, sizeOfSqaure);
                moveYAxis = new KeyValue(r1.xProperty(), 0);
                break;
            case 5:
                // MOVE RIGHT TO LEFT
                r1 = new Rectangle(420 - sizeOfSqaure, startYPoint, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), 0);
                break;
            case 6:
                //MOVE RIGHT TO LEFT, BOTTOM TO TOP
                r1 = new Rectangle(startXPoint, 0, sizeOfSqaure, sizeOfSqaure);
                moveXAxis = new KeyValue(r1.xProperty(), 350 - sizeOfSqaure);
                moveYAxis = new KeyValue(r1.yProperty(), 420 - sizeOfSqaure);
                break;

            default:
                System.out.println("default");
        }

        r1.setFill(Color.web("#4f5f4f"));
        r1.setOpacity(0.1);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(speedOfSqaure * 1000), moveXAxis, moveYAxis);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
//          javafx.application.Platform.runLater(()
////                            ->  
////                    ); 
        try {
            pane.getChildren().add(pane.getChildren().size() - 1, r1);
        } catch (Exception e) {
        }

        //this line make exception
    }

}
