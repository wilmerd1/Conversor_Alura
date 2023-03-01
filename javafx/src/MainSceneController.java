
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private ComboBox<?> cbDviisa2;
    
    @FXML
    private ComboBox<?> cbDivisa1;

    @FXML
    private TextField tfTltle;

    @FXML
    void btnOKClicked(ActionEvent event) {
        Stage mainWindows = (Stage) tfTltle.getScene().getWindow();
        String title = tfTltle.getText();
        mainWindows.setTitle(title);

    }

}
