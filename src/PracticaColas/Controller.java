package PracticaColas;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public static Cola cl = new Cola();
    @FXML
    Label tamañoLbl;
    @FXML
    Button ingresarBtn,buscarBtn,vaciarBtn,extraerBtn;
    @FXML
    TextField ingresarTxf,buscarTxf,extraerTxf;
    @FXML
    HBox contenedorHbx;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.ingresarBtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                cl.Insertar(ingresarTxf);
                LlenarContenedor();
            }
        });
    }

    public void LlenarContenedor(){
        Nodo temp=cl.frente.getValor();
        contenedorHbx.getChildren().clear();
        while (temp!=null){
            Label nodo = new Label(temp.getValor().toString());
            contenedorHbx.getChildren().add(nodo);
            temp=temp.getProximo();
        }
        tamañoLbl.setText(cl.getSize()+"");
    }
}
