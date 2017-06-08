package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import sample.MainHibernate;
import sample.entity.DohodEntity;

import javax.annotation.PostConstruct;

public class DohodController {
    private ObservableList<DohodEntity> usersData = FXCollections.observableArrayList();

    //Таблица расходов
    @FXML
    private TableView<DohodEntity> dohod;
    @FXML
    private TableColumn<DohodEntity,Integer> idColumn;
    @FXML
    private TableColumn<DohodEntity, String> sotrudnikColumn;
    @FXML
    private TableColumn<DohodEntity, String> statiaColumn;
    @FXML
    private TableColumn<DohodEntity, String> prihodColumn;


    @SuppressWarnings("unchecked")
    @PostConstruct
    @FXML
    private void initialize() {

        initData();



        //TableColumn<RashodyEntity, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity, Integer>("id"));
        prihodColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity,String>("date"));
        sotrudnikColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity,String>("rashodi"));
        statiaColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity,String>("statia"));


        // заполняем таблицу данными
        dohod.getColumns().setAll(idColumn,prihodColumn,sotrudnikColumn,statiaColumn);
        dohod.setItems(usersData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    private void initData() {
        System.out.println("initData");

        Session session = MainHibernate.getSession();
        session.beginTransaction();
        DohodEntity dohods = (DohodEntity)session.get(DohodEntity.class,(long)3);
        DohodEntity dohod_one = new DohodEntity(dohods.getId(),dohods.getPrihod(),dohods.getSotrudnik(),dohods.getStatia());

        session.close();
        usersData.add(dohod_one);

    }
}
