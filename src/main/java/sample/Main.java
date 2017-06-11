package sample;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import java.io.IOException;

public class Main extends Application {

    private static GridPane mainLayout = new GridPane();
    private static BorderPane workedLayout;
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("ComaFX");
        primaryStage.setTitle("comaFX");
        showMainItems();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.exit(0);
    }

    private static PieDataset createDataset( )
    {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        dataset.setValue( "IPhone 5s" , new Double( 20 ) );
        dataset.setValue( "SamSung Grand" , new Double( 20 ) );
        dataset.setValue( "MotoG" , new Double( 40 ) );
        dataset.setValue( "Nokia Lumia" , new Double( 10 ) );
        return dataset;
    }
    public static void diagram(){
        JFreeChart chart = ChartFactory.createPieChart("тест",createDataset());
        SwingNode chartSwingNode = new SwingNode();
        chartSwingNode.setContent(new ChartPanel(chart));
        BorderPane box = new BorderPane(chartSwingNode);
        box.setCenter(chartSwingNode);
        box.setMaxSize(600,600);
        mainLayout.add(box,2,0);
    }
    private void showMainItems() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/main.fxml"));
        workedLayout = loader.load();
        ScrollPane scrollPane = new ScrollPane(mainLayout);
        mainLayout.setHgap(10);
        mainLayout.setVgap(10);
        workedLayout.setCenter(scrollPane);
        Scene scene = new Scene(workedLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void showDohod() throws IOException{
        mainLayout.getChildren().removeAll();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/dohod.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
        diagram();
    }
    public static void showRashod() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/rashod.fxml"));
        BorderPane bpane = loader.load();
        BorderPane unusedBpane = new BorderPane();
        mainLayout.add(bpane,0,0);
        mainLayout.add(unusedBpane,1,0);
    }
    public static void showThird() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/third.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showTochki() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/tochki.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showSotrudniki() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/sotrudniki.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showPlanirovanie() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/planirovanie.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showSotr_otchet() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/sotr_otchet.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showSklad() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/sklad.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showOtchety() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/otchety.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showOtchety_po_tochkam() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/otchety_po_tochkam.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void showAnaliz() throws IOException{
        mainLayout.getChildren().clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/FXML/analiz_otchetov.fxml"));
        BorderPane bpane = loader.load();
        mainLayout.add(bpane,0,0);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
