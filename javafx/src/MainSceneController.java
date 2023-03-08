
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import clases.*;
import clases.Divisas;
import clases.DivisasList;
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

public class MainSceneController implements Initializable {

    @FXML
    private Button calcularButton;
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

    DivisasList divisasList = new DivisasList();

    public ComboBox<Divisas> getCbDivisa2() {
        return cbDivisa2;
    }

    public void setCbDivisa2(ComboBox<Divisas> cbDivisa2) {
        this.cbDivisa2 = cbDivisa2;
    }

    public ComboBox<Divisas> getCbDivisa1() {
        return cbDivisa1;
    }

    public void setCbDivisa1(ComboBox<Divisas> cbDivisa1) {
        this.cbDivisa1 = cbDivisa1;
    }

    public TextField getTxtResultado() {
        return txtResultado;
    }

    public void setTxtResultado(TextField txtResultado) {
        this.txtResultado = txtResultado;
    }

    public TextField getTxtMoneda() {
        return txtMoneda;
    }

    public void setTxtMoneda(TextField txtMoneda) {
        this.txtMoneda = txtMoneda;
    }

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
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarCombobox();
    }

    @FXML
    private void cargarCombobox() {
        cbDivisa1.getItems().addAll(divisasList.crearCollectionDivisas());
        cbDivisa2.getItems().addAll(divisasList.crearCollectionDivisas());
        cbDivisa1.setConverter(new Divisas_Converter());
        cbDivisa2.setConverter(new Divisas_Converter());

    }

    @FXML
    void calcularButtonsetOnAction(ActionEvent event) {
        calcularDivisas();

    }

    /*
     * 
     * public void invertirSeleccionComboBox() {
     * 
     * invertButton.setOnAction(event -> {
     * Divisas tempSelection1 = cbDivisa1.getSelectionModel().getSelectedItem();
     * Divisas tempSelection2 = cbDivisa2.getSelectionModel().getSelectedItem();
     * 
     * if (tempSelection1 == null || tempSelection2 == null &&
     * tempSelection1.equals(tempSelection2)
     * || tempSelection2.equals(tempSelection1)) {
     * System.out.println("Error");
     * return;
     * 
     * }
     * 
     * cbDivisa1.getSelectionModel().select(tempSelection2);
     * cbDivisa2.getSelectionModel().select(tempSelection1);
     * cbDivisa1.requestFocus();
     * 
     * });}
     * 
     */


     // Iconos
		ImageIcon iconCambioDivisa = new ImageIcon("src/imagenes/cambios_divisa.png");
		ImageIcon iconCalcular = new ImageIcon("src/imagenes/calcular.png");
		ImageIcon iconEuro = new ImageIcon("src/imagenes/euro.png");
		ImageIcon iconDolar = new ImageIcon("src/imagenes/dollar.png");
		ImageIcon iconPesoCol = new ImageIcon("src/imagenes/peso.png");

        
    public void calcularDivisas() {
        try {
            String valorTexto = txtMoneda.getText(); // toma el valor ingresado
            double valorDoble = Double.parseDouble(valorTexto); // se pasa a double para poder hacer las operaciones
            Divisas divisa1 = getCbDivisa1().getSelectionModel().getSelectedItem();
            Divisas divisa2 = getCbDivisa2().getSelectionModel().getSelectedItem();

            String separador = divisa1 + " - " + divisa2; // ! el separador usado entre las elecciones

            // HashMap con las posibles combinaciones
            Map<String, String> opciones = new HashMap<>();
            opciones.put("USD - EUR", "USD a EUR");
            opciones.put("USD - COP", "USD a COP");
            opciones.put("EUR - USD", "EUR a USD");
            opciones.put("EUR - COP", "EUR a COP");
            opciones.put("COP - USD", "COP a USD");
            opciones.put("COP - EUR", "COP a EUR");

            String resultado = opciones.get(separador);

            // Comprobacion del resultado y posibles combinaciones con sus operaciones
            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Las Divisas no pueden ser iguales o debes selecionar alguna",
                        "Alerta",
                        JOptionPane.ERROR_MESSAGE);
            } else if (resultado == "USD a EUR") {
                double operacion = valorDoble * 0.95;
                String solucion = Double.valueOf(operacion).toString();
                txtResultado.setText(solucion);
            } else if (resultado == "USD a COP") {
                double operacion = valorDoble * 4841.58;
                String solucion = Double.valueOf(operacion).toString();
                txtResultado.setText(solucion);
            } else if (resultado == "EUR a USD") {
                double operacion = valorDoble * 1.05;
                String solucion = Double.valueOf(operacion).toString();
                txtResultado.setText(solucion);
            } else if (resultado == "EUR a COP") {
                double operacion = valorDoble * 5105.49;
                String solucion = Double.valueOf(operacion).toString();
                txtResultado.setText(solucion);
            } else if (resultado == "COP a USD") {
                double operacion = valorDoble * 0.00021;
                String solucion = Double.valueOf(operacion).toString();
                txtResultado.setText(solucion);
            } else if (resultado == "COP a EUR") {
                double operacion = valorDoble * 0.00019;
                String solucion = Double.valueOf(operacion).toString();
                txtResultado.setText(solucion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numerico unicamente", "Error!",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
