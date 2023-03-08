
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import clases.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainSceneController implements Initializable{
    @FXML
    private ImageView arrowDivisas;

    @FXML
    private ImageView arrowExit;

    @FXML
    private ImageView arrowTemperatura;

    @FXML
    private ImageView btnExit;

    @FXML
    private ComboBox<Divisas> cbDivisa1;

    @FXML
    private ComboBox<Divisas> cbDivisa2;

    @FXML
    private ComboBox<?> cbxDivisa11;

    @FXML
    private ComboBox<?> cbxDivisa21;

    @FXML
    private AnchorPane divisasPanel;

    @FXML
    private Button invertButton;

    @FXML
    private Label lblDivisa11;

    @FXML
    private Label lblDivisa21;

    @FXML
    private AnchorPane tempPanel;

    @FXML
    private TextField txtDivisa1;

    @FXML
    private TextField txtMoneda;

    @FXML
    private TextField txtResultado;

    @FXML
    private TextField txtResultado1;
    


    @FXML
    void getOnDivisasButtonClicked(MouseEvent event) {
        divisasPanel.setVisible(true);
        arrowDivisas.setVisible(true);
        tempPanel.setVisible(false);
        arrowTemperatura.setVisible(false);
        arrowExit.setVisible(false);
    }

    @FXML
    void getOnExitButtonClicked(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void getOnTemperaturaButtonClicked(MouseEvent event) {

        tempPanel.setVisible(true);
        arrowTemperatura.setVisible(true);
        divisasPanel.setVisible(false);
        arrowDivisas.setVisible(false);
        arrowExit.setVisible(false);

    }

    @FXML
    public void comboboxEvents(ActionEvent e){

       // Object evt = e.getSource();
        
    }

   
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbDivisa1.getItems().addAll(createColletDivisas());    
        cbDivisa1.setConverter(new Divisas_Converter());  
        
    }

   private ArrayList<Divisas> createColletDivisas(){
        ArrayList<Divisas> div = new ArrayList<>();
        div.add(new Divisas("USD"));
        div.add(new Divisas("EEU"));
        div.add(new Divisas("COL"));

        return div;


    }
   
    
    
   /* public void invertirSeleccionComboBox() {

        invertButton.setOnAction(event -> {
            Divisas tempSelection1 = cbxDivisa1.getSelectionModel().getSelectedItem();
            Divisas tempSelection2 = cbxDivisa2.getSelectionModel().getSelectedItem();

            if (tempSelection1 == null || tempSelection2 == null && tempSelection1.equals(tempSelection2)
                    || tempSelection2.equals(tempSelection1)) {
                System.out.println("Error");
                return;

            }

            cbxDivisa1.getSelectionModel().select(tempSelection2);
            cbxDivisa2.getSelectionModel().select(tempSelection1);
            cbxDivisa1.requestFocus();

        });*/

    }


