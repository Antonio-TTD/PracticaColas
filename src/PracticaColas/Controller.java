package PracticaColas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public static Cola cl = new Cola();
    @FXML
    Label tamañoLbl;
    @FXML
    Button ingresarBtn,buscarBtn,vaciarBtn,extraerBtn;
    @FXML
    TextField ingresarTxf,buscarTxf;
    @FXML
    FlowPane contenedorFP;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.ingresarBtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                if (ComprobarInt(ingresarTxf.getText()) && 0<Integer.parseInt(ingresarTxf.getText())) {
                    cl.Insertar(ingresarTxf.getText());
                    LlenarCont(0);
                    ingresarTxf.clear();
                }else{
                    LlamarAlert();
                    ingresarTxf.clear();
                }
            }
        });
        this.extraerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cl.extraer();
                LlenarCont(0);
            }
        });
        this.vaciarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cl.VaciarCola();
                contenedorFP.getChildren().clear();
                tamañoLbl.setText("0");
            }
        });
        this.buscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ComprobarInt(buscarTxf.getText())) {
                    LlenarCont(Integer.parseInt(buscarTxf.getText()));
                }else{
                    LlamarAlert();
                    buscarTxf.clear();
                }
            }
        });
    }
    public void LlenarCont(int buscador){
        contenedorFP.getChildren().clear();
        for (Nodo temp = cl.frente;temp!=null;temp = temp.getProximo()) {
            String toy = "src/PracticaColas/image/M1.png";
            VBox caja = new VBox();
            Label nodo = new Label(temp.getValor().toString());
            if (temp.getValorInt()==buscador){
                toy = "src/PracticaColas/image/M2.png";
            }
            ImageView Muñequito = null;
            try {
                File archivo = new File(toy);
                //System.out.println(archivo.toURI().toURL().toString());
                Image imagen = new Image(archivo.toURI().toURL().toString());
                Muñequito = new ImageView(imagen);

            }catch (Exception e){
                e.printStackTrace();
            }
            nodo.setStyle("-fx-font-size:30px;");
            caja.getChildren().add(nodo);
            caja.getChildren().add(Muñequito);
            contenedorFP.getChildren().add(caja);
        }
        tamañoLbl.setText(cl.getSize()+"");
    }
    public boolean ComprobarInt (String num){
        try {
            Integer.parseInt(num);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void LlamarAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Valores Incorrectos");
        alert.setContentText("Acabas de ingresar datos que no son númmericos" +
                "\npor favor introduce valores numericos enteros" +
                "\ny que sean mayores a cero");
        alert.showAndWait();
    }
}