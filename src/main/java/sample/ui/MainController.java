package sample.ui;

import javafx.fxml.FXML;
import sample.Main;

import java.io.IOException;

public class MainController {
    @FXML
    private void closeAction(){
        System.exit(0);
    }
    @FXML
    private void aboutAction(){

    }
    @FXML
    public void showFirstDohod()throws IOException {
        Main.showDohod();
    }
    @FXML
    public void showFirstRashod()throws IOException {
        Main.showRashod();
    }
    @FXML
    public void showFirstThird()throws IOException {
        Main.showThird();
    }
    @FXML
    public void showFirstTochki()throws IOException {
        Main.showTochki();
    }
    @FXML
    public void showFirstSotrudniki()throws IOException {
        Main.showSotrudniki();
    }
    @FXML
    public void showFirstPlanirovanie()throws IOException {
        Main.showPlanirovanie();
    }
    @FXML
    public void showFirstPoTochkam()throws IOException {
        Main.showOtchety_po_tochkam();
    }
    @FXML
    public void showFirstSklad()throws IOException {
        Main.showSklad();
    }
    @FXML
    public void showFirstOtchety()throws IOException {
        Main.showOtchety();
    }
    @FXML
    public void showFirstOtchet()throws IOException {
        Main.showSotr_otchet();
    }
    @FXML
    public void showFirstAnaliz()throws IOException {
        Main.showAnaliz();
    }
}
