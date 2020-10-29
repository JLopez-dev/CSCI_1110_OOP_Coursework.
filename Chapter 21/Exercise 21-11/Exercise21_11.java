/*  Name: John Lopez.
 *  Date: 10/27/2020.
 */
package Exercise21_11;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.util.*;

public class Exercise21_11 extends Application {
    final int BOYS_NAMES = 1;
    final int GIRLS_NAMES = 3;
    protected ComboBox<String> cboYear = new ComboBox<>();
    protected ComboBox<String> cboGender = new ComboBox<>();
    protected TextField tfName = new TextField();
    protected Button btFindRanking = new Button("Find Ranking");
    protected Label lblResults = new Label("");
    protected Map[] boys = getNames(BOYS_NAMES);
    protected Map[] girls = getNames(GIRLS_NAMES);

    @Override
    public void start(Stage primaryStage) {

        btFindRanking.setOnAction(e -> displayRank());

        Scene scene = new Scene(getPane(), 300, 160);
        primaryStage.setTitle("Exercise_21_11");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayRank() {
        lblResults.setText(getGender() + " name "
                + tfName.getText() + " is ranked #" + getRank()
                + " in year " + cboYear.getValue());
    }

    private String getGender() {
        return cboGender.getValue().equals("Male") ? "Boy" : "Girl";
    }

    private String getRank() {
        int year = Integer.parseInt(cboYear.getValue()) - 2001;

        if (cboGender.getValue().equals("Male")) {
            return boys[year].get(tfName.getText()) + "";
        }
        else
            return girls[year].get(tfName.getText()) + "";
    }

    private BorderPane getPane() {
        for (int i = 2001; i <= 2010; i++)
            cboYear.getItems().add(i + "");

        cboGender.getItems().addAll("Male", "Female");

        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 0, 5, 0));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Label("Select a year: "), 0, 0);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(new Label("Boy or girl?: "), 0, 1);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(new Label("Enter a name: "), 0, 2);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);

        BorderPane pane = new BorderPane();
        pane.setCenter(gridPane);
        pane.setBottom(lblResults);
        pane.setAlignment(lblResults, Pos.CENTER);

        return pane;
    }

    private Map[] getNames(int gender) {
        Map[] array = new Map[10];

        for (int year = 2001, i = 0; year <= 2010 && i < 10; year++, i++) {
            Map<String, String> map = new HashMap<>();
            try {
                java.net.URL url = new java.net.URL(
                        "http://liveexample.pearsoncmg.com/data/babynamesranking2001.txt"
                                + year + "http://liveexample.pearsoncmg.com/data/babynamesranking2010.txt");

                Scanner input = new Scanner(url.openStream());
                while (input.hasNext()) {
                    ArrayList<String> list = new ArrayList<>();
                    for (int l = 0; l < 5; l++) {
                        list.add(l, input.next());
                    }
                    map.put(list.get(gender), list.get(0));
                }
            }
            catch (java.net.MalformedURLException ex) {
                System.out.println("Invalid URL");
            }
            catch (java.io.IOException ex) {
                System.out.println(" ");
            }
            array[i] = map;
        }

        return array;
    }
}