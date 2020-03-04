/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileWriter;
import java.io.IOException;
import static java.util.Objects.hash;
import java.util.Arrays;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

/**
 *
 * @author Faiez AL-Ebrahim
 */
public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static Stage stage1 = new Stage();
    public static Stage stage2 = new Stage();
    public static Scene scene, scene1,scene2;

    @Override
    public void start(Stage primaryStage) throws Exception {

//   static Parent   root ;
//        Parent root = FXMLLoader.load(getClass().getResource("automata 1st show.fxml"));
//        scene = new Scene(root);
//        Parent root1 = FXMLLoader.load(getClass().getResource("AHOW AUTOMATA.fxml"));
//        scene1 = new Scene(root1);
        Parent root2 = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        scene = new Scene(root2);
        stage1.getIcons().add(new Image( Test.class.getResourceAsStream("images.png")));
       stage1.setTitle("AUTOMATA");
        stage1.setScene(scene);
        stage1.show();

    }
}
/*
//        int [] alphabet = {0,1};
//        String [] s = {"q0","q1","q2"};
//        String i_s = "q0";
//        String  f_s = "q2";
        // alphabet
        JSONObject obj = new JSONObject();
//        ArrayList<Character> alphabet = new ArrayList<Character>();
//        alphabet.add('0');
//        alphabet.add('1');
        // initial state
        String i_s = "0";

        ArrayList<Integer> ee = new ArrayList<Integer>();
        ee.add(0);
        ee.add(2);

        //final state
        String f_s = "2";
        // states
        ArrayList<Integer> states = new ArrayList<Integer>();
        states.add(0);
        states.add(1);
        states.add(2);
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

        List<String> tran = new LinkedList<>();
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
       String alphabet="*0";
        obj.put("final_states", f_s);
        obj.put("initial_state", i_s);
        obj.put("states", states);
        obj.put("alphabet", alphabet);
        obj.put("transaction", tran);
        obj.put("e", a[0]);

        try (FileWriter file = new FileWriter("json.json")) {
            file.write(obj.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(obj);

    }
public static  Stage stage1=new Stage();
   public static Scene scene,scene2;
    @Override
    public void start(Stage primaryStage) throws Exception {
     
//   static Parent   root ;
   
      Parent   root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
    scene = new Scene(root);
                stage1.setScene(scene);
        stage1.show();
      }
}

*/
