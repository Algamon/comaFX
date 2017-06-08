package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Entity.RashodyEntity;

import java.io.IOException;

public class Controller {
    private ObservableList<RashodyEntity> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<RashodyEntity> rashody;

    @FXML
    private TableColumn<RashodyEntity,Integer> idColumn = new TableColumn<>("id");

    @FXML
    private TableColumn<RashodyEntity, String> dateColumn = new TableColumn<>("id");

    @FXML
    private TableColumn<RashodyEntity, String> rashodColumn = new TableColumn<>("id");

    @FXML
    private TableColumn<RashodyEntity, String> statiaColumn = new TableColumn<>("id");

    @FXML
    private TableColumn<RashodyEntity, String> osnovanieColumn = new TableColumn<>("id");

    // инициализируем форму данными@PostConstruct
    @FXML
    private void initialize() {
        initData();
        //TableColumn<RashodyEntity, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity, Integer>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("Дата"));
        rashodColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("Расходы"));
        statiaColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("Статья"));
        osnovanieColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("Основание"));

        // заполняем таблицу данными
        rashody.getColumns().setAll(idColumn,dateColumn,rashodColumn,statiaColumn,osnovanieColumn);
        rashody.setItems(usersData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        usersData.add(new RashodyEntity(1, "Alex", "qwerty", "alex@mail.com","hhy"));
        /*usersData.add(new RashodyEntity("", "Bob", "dsfsdfw", "bob@mail.com",""));
        usersData.add(new RashodyEntity("", "Jeck", "dsfdsfwe", "Jeck@mail.com"));
        usersData.add(new RashodyEntity("", "Mike", "iueern", "mike@mail.com"));
        usersData.add(new RashodyEntity("", "colin", "woeirn", "colin@mail.com"));*/
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
