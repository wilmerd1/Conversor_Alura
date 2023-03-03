import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MainSceneController {

    @FXML
    private ImageView arrowDivisas;

    @FXML
    private ImageView arrowExit;

    @FXML
    private ImageView arrowTemp;

    @FXML
    private ImageView btnExit;

    @FXML
    private ComboBox<?> cbxDivisa1;

    @FXML
    private ComboBox<?> cbxDivisa11;

    @FXML
    private ComboBox<?> cbxDivisa2;

    @FXML
    private ComboBox<?> cbxDivisa21;

    @FXML
    private AnchorPane divisasPanel;

    @FXML
    private Label lblDivisa1;

    @FXML
    private Label lblDivisa11;

    @FXML
    private Label lblDivisa2;

    @FXML
    private Label lblDivisa21;

    @FXML
    private AnchorPane tempPanel;

    @FXML
    private TextField txtDivisa;

    @FXML
    private TextField txtDivisa1;

    @FXML
    private TextField txtResultado;

    @FXML
    private TextField txtResultado1;

    @FXML
    void getOnDivisasButtonClicked(MouseEvent event) {
        divisasPanel.setVisible(true);
        arrowDivisas.setVisible(true);
        tempPanel.setVisible(false);
        arrowTemp.setVisible(false);
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
        arrowTemp.setVisible(true);
        divisasPanel.setVisible(false);
        arrowDivisas.setVisible(false);
        arrowExit.setVisible(false);

    }

}
