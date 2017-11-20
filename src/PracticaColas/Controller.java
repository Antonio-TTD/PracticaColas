package PracticaColas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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
    HBox contenedorHbx;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.ingresarBtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                cl.Insertar(ingresarTxf.getText());
                LlenarContenedor();
            }
        });
        this.extraerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cl.extraer();
                LlenarContenedor();
            }
        });
        this.vaciarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cl.VaciarCola();
                LlenarContenedor();
            }
        });
        this.buscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Buscar(Integer.parseInt(buscarTxf.getText()));
            }
        });
    }
    public void LlenarContenedor(){
        contenedorHbx.getChildren().clear();
        for (Nodo temp = cl.frente;temp!=null;temp = temp.getProximo()){
            Label nodo = new Label(temp.getValor().toString());
            contenedorHbx.getChildren().add(nodo);
        }
    }
    public void Buscar(int buscador){
        contenedorHbx.getChildren().clear();
        for (Nodo temp = cl.frente;temp!=null;temp = temp.getProximo()){
            Label nodo = new Label(temp.getValor().toString());
            if (buscador == (Integer.parseInt(temp.getValor().toString()))) {
            nodo.setText("|"+temp.getValor().toString()+"|");
            }
            contenedorHbx.getChildren().add(nodo);
        }
        tamañoLbl.setText(cl.getSize()+"");
    }
}
