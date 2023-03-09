
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import clases.Divisas;
import clases.DivisasList;
import clases.Temperatura;
import clases.TemperaturaList;
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
    private Button ConvertirTempButton;

    @FXML
    private ImageView arrowDivisas;

    @FXML
    private ImageView arrowExit;

    @FXML
    private ImageView arrowTemperatura;

    @FXML
    private ImageView btnExit;

    @FXML
    private Button calcularButton;

    @FXML
    private ComboBox<Divisas> cbDivisa1;

    @FXML
    private ComboBox<Divisas> cbDivisa2;

    @FXML
    private ComboBox<Temperatura> cbTempDos;

    @FXML
    private ComboBox<Temperatura> cbTempUno;

    @FXML
    private AnchorPane divisasPanel;

    @FXML
    private Button invertButton;

    @FXML
    private Button invertirTemperaturaButton;

    @FXML
    private Label lblDdos;

    @FXML
    private Label lblDuno;

    @FXML
    private Label lblTempDos;

    @FXML
    private Label lblTempUno;

    @FXML
    private AnchorPane temperaturaPanel;

    @FXML
    private TextField txtMoneda;

    @FXML
    private TextField txtResultado;

    @FXML
    private TextField txtTempDos;

    @FXML
    private TextField txtTempUno;

    DivisasList divisasList = new DivisasList();
    TemperaturaList temperaturaList = new TemperaturaList();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cargarComboboxDivisas();
        cargarComboboxTemperatura();

    }

    @FXML
    void getOnDivisasButtonClicked(MouseEvent event) {
        divisasPanel.setVisible(true);
        arrowDivisas.setVisible(true);
        temperaturaPanel.setVisible(false);
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

        temperaturaPanel.setVisible(true);
        arrowTemperatura.setVisible(true);
        divisasPanel.setVisible(false);
        arrowDivisas.setVisible(false);
        arrowExit.setVisible(false);

    }

    @FXML
    private void cargarComboboxDivisas() {
        cbDivisa1.getItems().addAll(divisasList.crearCollectionDivisas());
        cbDivisa2.getItems().addAll(divisasList.crearCollectionDivisas());
    }

    @FXML
    private void cargarComboboxTemperatura() {
        cbTempUno.getItems().addAll(temperaturaList.coleccionTemperaturas());
        cbTempDos.getItems().addAll(temperaturaList.coleccionTemperaturas());
    }

    @FXML
    void calcularButtonsetOnAction(ActionEvent event) {
        calcularDivisas();

    }

    @FXML
    void comboBox1setOnAction(ActionEvent event) {
        cambiarSeleccionDivisasCb1();
    }

    @FXML
    void comboBox2setOnAction(ActionEvent event) {
        cambiarSeleccionDivisasCb2();

    }

    @FXML
    void alternarButtonsetOnAction(ActionEvent event) {
        invertirSeleccionComboBox();
        limpiarTexto();

    }

    @FXML
    void alternarTempButtonsetOnAction(ActionEvent event) {

    }

    @FXML
    void comboBoxTemp1setOnAction(ActionEvent event) {
        cambiarSeleccionTemperaturaCb1();

    }

    @FXML
    void comboBoxTemp2setOnAction(ActionEvent event) {
cambiarSeleccionTemperaturaCb2();
    }

    @FXML
    void convertirTempButtonsetOnAction(ActionEvent event) {

    }

    private void cambiarSeleccionDivisasCb1() {

        String seleccion = cbDivisa1.getSelectionModel().getSelectedItem().toString();
        if (seleccion == "USD") {

            lblDuno.setText("Dolar Americano");
        } else if (seleccion == "EUR") {

            lblDuno.setText("Euro");
        } else if (seleccion == "COP") {

            lblDuno.setText("Peso Colombiano");
        }

    }

    private void cambiarSeleccionDivisasCb2() {
        String seleccion = cbDivisa2.getSelectionModel().getSelectedItem().toString();

        if (seleccion == "USD") {

            lblDdos.setText("Dolar Americano");
        } else if (seleccion == "EUR") {

            lblDdos.setText("Euro");
        } else if (seleccion == "COP") {

            lblDdos.setText("Peso Colombiano");
        }
    }


    private void cambiarSeleccionTemperaturaCb1() {

        String seleccion = cbTempUno.getSelectionModel().getSelectedItem().toString();
        if (seleccion == "Celsius") {

            lblTempUno.setText("-273.15 °C");
        } else if (seleccion == "Fahrenheit") {

            lblTempUno.setText("-459.67 °F");
        } else if (seleccion == "Kelvin") {

            lblTempUno.setText("0 K");
        } else if (seleccion == "Rankine"){
            lblTempUno.setText("0 °R");

        }

    }

    private void cambiarSeleccionTemperaturaCb2() {
        String seleccion = cbTempDos.getSelectionModel().getSelectedItem().toString();

        if (seleccion == "Celsius") {

            lblTempDos.setText("-273.15 °C");
        } else if (seleccion == "Fahrenheit") {

            lblTempDos.setText("-459.67 °F");
        } else if (seleccion == "Kelvin") {

            lblTempDos.setText("0 K");
        } else if (seleccion == "Rankine"){
            lblTempDos.setText("0 °R");

        }
    }

    public void invertirSeleccionComboBox() {

        int combouno = cbDivisa1.getSelectionModel().getSelectedIndex();
        int combodos = cbDivisa2.getSelectionModel().getSelectedIndex();

        int temporal = combouno;

        combouno = combodos;
        combodos = temporal;

        cbDivisa1.getSelectionModel().select(combouno);
        cbDivisa2.getSelectionModel().select(combodos);

    }

    public void limpiarTexto() {

        txtMoneda.setText("");
        txtResultado.setText("");

    }

    public void calcularDivisas() {
        try {
            String valorTexto = txtMoneda.getText(); // toma el valor ingresado
            double valorDoble = Double.parseDouble(valorTexto); // se pasa a double para poder hacer las operaciones
            Divisas divisa1 = cbDivisa1.getSelectionModel().getSelectedItem();
            Divisas divisa2 = cbDivisa2.getSelectionModel().getSelectedItem();

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
