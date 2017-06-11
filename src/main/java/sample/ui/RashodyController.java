package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import sample.MainHibernate;
import sample.entity.RashodyEntity;

import javax.annotation.PostConstruct;

public class RashodyController {
    private ObservableList<RashodyEntity> usersData = FXCollections.observableArrayList();

    //Таблица расходов
    @FXML
    private TableView<RashodyEntity> rashody;
    @FXML
    private TableColumn<RashodyEntity,Integer> idColumn;
    @FXML
    private TableColumn<RashodyEntity, String> dateColumn;
    @FXML
    private TableColumn<RashodyEntity, String> rashodColumn;
    @FXML
    private TableColumn<RashodyEntity, String> statiaColumn;
    @FXML
    private TableColumn<RashodyEntity, String> osnovanieColumn;


    @SuppressWarnings("unchecked")
    @PostConstruct
    @FXML
    private void initialize() {

        initData();



        //TableColumn<RashodyEntity, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity, Integer>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("date"));
        rashodColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("rashodi"));
        statiaColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("statia"));
        osnovanieColumn.setCellValueFactory(new PropertyValueFactory<RashodyEntity,String>("osnovanie"));

        // заполняем таблицу данными
        rashody.getColumns().setAll(idColumn,dateColumn,rashodColumn,statiaColumn,osnovanieColumn);
        rashody.setItems(usersData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        Session session = MainHibernate.getSession();
        session.beginTransaction();
        Object check;
        long j = 1;
        for(;;){
            check = session.get(RashodyEntity.class,j);
            if (check==null) break;
            RashodyEntity rash = (RashodyEntity)session.get(RashodyEntity.class,j);
            RashodyEntity ras_one = new RashodyEntity(rash.getId(),rash.getDate(),rash.getRashodi(),rash.getStatia(),rash.getOsnovanie());
            usersData.add(ras_one);
            j++;
        }
        session.close();

    }

}
