package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import sample.MainHibernate;
import sample.entity.DohodEntity;

import javax.annotation.PostConstruct;
import java.util.List;


public class DohodController {
    private ObservableList<DohodEntity> usersData = FXCollections.observableArrayList();

    //Таблица
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

    //Форма изменения

    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldPrihod;
    @FXML
    private TextField fieldStatia;
    @FXML
    private TextField fieldSotrudnik;

    @SuppressWarnings("unchecked")
    @PostConstruct
    @FXML
    private void initialize() {

        initData();



        //TableColumn<RashodyEntity, Integer> idColumn = new TableColumn<>("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity, Integer>("id"));
        prihodColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity,String>("prihod"));
        sotrudnikColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity,String>("sotrudnik"));
        statiaColumn.setCellValueFactory(new PropertyValueFactory<DohodEntity,String>("statia"));


        // заполняем таблицу данными
        dohod.getColumns().setAll(idColumn,prihodColumn,statiaColumn,sotrudnikColumn);
        dohod.setItems(usersData);
    }

    // подготавливаем данные для таблицы
    // вы можете получать их с базы данных
    @SuppressWarnings("unchecked")
    private void initData() {
        Session session = MainHibernate.getSession();
        session.beginTransaction();
        List<Long> list = session.createQuery("select id from DohodEntity ").list();
        for (long x: list){
            DohodEntity dohods = (DohodEntity) session.get(DohodEntity.class, x);
            DohodEntity dohod_one = new DohodEntity(dohods.getId(), dohods.getPrihod(), dohods.getSotrudnik(), dohods.getStatia());
            usersData.add(dohod_one);
        }
        session.close();
    }
    @SuppressWarnings("unchecked")
    @FXML
    private void buttonChangeEvent(){
        Session session = MainHibernate.getSession();
        session.beginTransaction();
        if (fieldId.getText().equals("")){
            if (fieldPrihod.getText().equals("")&&fieldSotrudnik.getText().equals("")&&fieldStatia.getText().equals("")){
                session.close();
                System.out.println("test 1");
                return;
            }
            else {
                List<Long> longList = session.createQuery("select id from DohodEntity ").list();
                long y=1;
                for (long x: longList){
                    if (x!=y) break;
                    y++;
                }
                session.save(new DohodEntity(y,fieldPrihod.getText(),fieldSotrudnik.getText(),fieldStatia.getText()));
            }
        }
        else {
            Object dohodChange = session.get(DohodEntity.class, Long.parseLong(fieldId.getText()));
            if (dohodChange == null) {
                List<Long> longList = session.createQuery("select id from DohodEntity ").list();
                long y = 1;
                for (long x : longList) {
                    if (x != y) break;
                    y++;
                }
                session.save(new DohodEntity(y, fieldPrihod.getText(), fieldSotrudnik.getText(), fieldStatia.getText()));
            } else {
                DohodEntity dohodEntity = (DohodEntity) dohodChange;
                dohodEntity.setPrihod(fieldPrihod.getText());
                dohodEntity.setSotrudnik(fieldSotrudnik.getText());
                dohodEntity.setStatia(fieldStatia.getText());
            }
        }
        session.flush();
        session.getTransaction().commit();
        session.close();
        usersData.clear();
        fieldId.clear();
        fieldPrihod.clear();
        fieldSotrudnik.clear();
        fieldStatia.clear();
        initData();

    }
    @FXML
    private void buttonDeleteEvent(){
        Session session = MainHibernate.getSession();
        session.beginTransaction();
        session.delete(dohod.getSelectionModel().getSelectedItem());
        session.getTransaction().commit();
        session.close();
        usersData.clear();
        initData();
    }
}
