/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.CountDownLatch;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.json.simple.
import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author ENG ALAA AL_KHEDER
 */
public class FXMLController implements Initializable {

   
    @FXML
    private Pane pane;

    @FXML
    private Label labelAlpha;

    @FXML
    private RadioButton AZ;

    @FXML
    private ToggleGroup ALPHABET;

    @FXML
    private RadioButton binary;

    @FXML
    private RadioButton N09;

    @FXML
    private TextField name;

    @FXML
    private TextField transation;

    @FXML
    private TextField alphabet;

    @FXML
    private TextField finalState;

    @FXML
    private TextField initialState;

    @FXML
    private Button next;

    @FXML
    private Button submit;

    @FXML
    private Label labelState;

    @FXML
    private CheckBox deadState;

    @FXML
    private RadioButton other;

    @FXML
    private TextField finite;

//    @FXML
//    void AZ(ActionEvent event) {
//
//    }
//
//    @FXML
//    void I09(ActionEvent event) {
//
//    }
//
//    @FXML
//    void bin(ActionEvent event) {
//
//    }
//
//    @FXML
//    void deadState(ActionEvent event) {
//
//    }
//
//    @FXML
//    void next(ActionEvent event) {
//
//    }
//
//    @FXML
//    void othre(ActionEvent event) {
//
//    } @FXML
//    void submit(ActionEvent event) {
//
//    }    
///////////////////////////////////////////////////////////////////////////////////
   
    double prog = 0;
    JSONObject obj = new JSONObject();
    String i_s = "0";

    //final state
//    String f_s = "3";
    ArrayList<String>f_s=new ArrayList<>();
    ArrayList<String>finalStatestext=new ArrayList<>();
    ArrayList<Integer> states = new ArrayList<Integer>();

    List<String> tran = new LinkedList<>();
    String alphabet1 = "abcdefghijklmnopqrstuvwxyz0123456789.; =/";
  int Count;

    @FXML
    void AZ(ActionEvent event) {
        alphabet.setDisable(true);
        alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
    }

    @FXML
    void I09(ActionEvent event) {
        alphabet.setDisable(true);
        alphabet1 = "0123456789";
    }

    @FXML
    void bin(ActionEvent event) {
        alphabet.setDisable(true);
        alphabet1 = "01";
    }

    @FXML
    void deadState(ActionEvent event) {
//        transation.setDisable(true);
    }
    int x = 0, k = 0;

    @FXML
    void next(ActionEvent event) {

        if (deadState.isSelected()) {
            tran.add("-1");
//            deadState.setSelected(false);
            transation.setDisable(false);
        } else {
            tran.add(transation.getText());
        }
//        transation.clear();
//        prog += 0.1;
//        prograssBar.setProgress(prog);

        if (k == alphabet1.length() - 1 && x == Count-1) {
            next.setDisable(true);

            obj.put("final_states", f_s);
            obj.put("initial_state", i_s);
            obj.put("states", states);
            obj.put("alphabet", alphabet1);
            obj.put("transaction", tran);
            obj.put("resultText", finalStatestext);
            String path = name.getText() + "json.json";
            try (FileWriter file = new FileWriter(path)) {
                file.write(obj.toString());
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(obj);

        }
        k++;

        if (k == alphabet1.length()) {
            k = 0;
            x++;
        }
        labelState.setText("Q" + x);
        labelAlpha.setText("" + alphabet1.charAt(k));
    }

    @FXML
    void othre(ActionEvent event) {
        alphabet.setDisable(false);

    }

    @FXML
    void submit(ActionEvent event) {
        System.out.println(alphabet1.length());
        i_s = initialState.getText();
        f_s.add("8");
        f_s.add("10");
        f_s.add("26");
//          f_s = finalState.getText();
        String so=finite.getText();
        Count=Integer.parseInt(so);
        for (int i = 0; i < Count; i++) {// 4 number of states
            states.add(i);
                  }

        submit.setDisable(true);
        next.setDisable(false);
        labelState.setText("Q" + x);
        labelAlpha.setText("" + alphabet1.charAt(k));

    }
//    
//     
//        obj.put("final_states", f_s);
//        obj.put("initial_state", i_s);
//        obj.put("states", states);
//        obj.put("alphabet", alphabet);
//        obj.put("transaction", tran);
//      try (FileWriter file = new FileWriter("json.json")) {
//            file.write(obj.toString());
//            file.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        create.setSelected(true);
//        binary.setSelected(true);
//        alphabet.setDisable(true);
//        next.se  while (numberOfSquares > 0) {
//////            generateAnimation();
////            numberOfSquares--;
//
////        }tDisable(true);
//        prograssBar.setProgress(prog);

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

        r1.setFill(Color.web("#07a9f5"));
        r1.setOpacity(0.1);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(speedOfSqaure * 1000), moveXAxis, moveYAxis);
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
//          javafx.application.Platform.runLater(()
//                            ->  
//                    ); 
        try {
            pane.getChildren().add(pane.getChildren().size() - 1, r1);
        } catch (Exception e) {
        }

        //this line make exception
    }

}

/*
 //        int [] alphabet = {0,1};
 //        String [] s = {"q0","q1","q2"};
 //        String i_s = "q0";
 //        String  f_s = "q2";
 // alphabet
      
 //        ArrayList<Character> alphabet = new ArrayList<Character>();
 //        alphabet.add('0');
 //        alphabet.add('1');
 // initial state
     

 ArrayList<Integer> ee = new ArrayList<Integer>();
 ee.add(0);
 ee.add(2);

        
 // states
       
 // transaction
 //           String [][] tran = new String[3][2];
 //           tran[0][0] = "q1";
 //           tran[0][1] = "";
 //           tran[1][0] = "";
 //           tran[1][1] = f_s;
 //           tran[2][0] = f_s;
 //           tran[2][1] = f_s;
 //           int [][] tran = new int[3][2];
 //           tran[0][0] = 0;
 //           tran[0][1] = -1;
 //           tran[1][0] = -1;
 //           tran[1][1] = 2;
 //           tran[2][0] = 2;
 //           tran[2][1] = 2;

       
 tran.add("1");
 tran.add("-1");
 tran.add("-1");
 tran.add("2");
 tran.add("2");
 tran.add("2");
 //            tran.add(-1);
 //            tran.add(-1);
 //            tran.add(2);
 //            tran.add(2);
 //            tran.add(2);
 int[] a = null;
 a = new int[10];
 for (int i = 0; i < 10; i++) {
 a[i] = i;
 }
       
 obj.put("e", a[0]);

        
 System.out.println(obj);
 */
