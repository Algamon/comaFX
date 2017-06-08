package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;

import java.io.IOException;
import java.util.Map;

public class Main extends Application {

    private static BorderPane mainLayout;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{


        final Session session = MainHibernate.getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
            for (Object key : metadataMap.keySet()) {
                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
                final String entityName = classMetadata.getEntityName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("ComaFX");
        primaryStage.setTitle("comaFX");
        showMainItems();
    }

    private void showMainItems() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/main.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void showDohod() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/dohod.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showRashod() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/rashod.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showThird() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/third.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showTochki() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/tochki.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showSotrudniki() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/sotrudniki.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showPlanirovanie() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/planirovanie.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showSotr_otchet() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/sotr_otchet.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showSklad() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/sklad.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showOtchety() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/otchety.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showOtchety_po_tochkam() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/otchety_po_tochkam.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void showAnaliz() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/analiz_otchetov.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.setCenter(bpane);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
