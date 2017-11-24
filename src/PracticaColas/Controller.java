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
    public static Cola cl = new Cola();// Instancia para llamar a la clase cola
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
        // Acción del botón agregar
        this.ingresarBtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                // Llama al metodo para comprobar si lo que ingreso el usuario es entero y mayor a cero
                if (ComprobarInt(ingresarTxf.getText()) && 0<Integer.parseInt(ingresarTxf.getText())) {
                    // Llama al método de insertar de la clase cola para meter un número a la cola
                    cl.Insertar(ingresarTxf.getText());
                    // Llama al método para llenar el flowpane con el contenido de la cola
                    LlenarCont(0);
                    // Limpia el textfield de ingresar
                    ingresarTxf.clear();
                }else{//En caso de que el valor no sea un número entero mayor a cero
                    // LLama al alert de valores incorrectos
                    LlamarAlertValoresIncorrectos();
                    // Limpia el textfield de ingresar valores
                    ingresarTxf.clear();
                }
            }
        });
        // Acción del botón buscar, este botón pasa por varios verificadores para su buen funcionamiento
        this.buscarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Verifica si la cola no esta vacia
                if (cl.itsEmpty()){
                    // Verifica que el número ingresado sea entero y mayor a cero
                    if (ComprobarInt(buscarTxf.getText())) {
                        // Verifica que el número ingresado esta en la cola
                        if (cl.itsHere(buscarTxf.getText())){
                            // Busca y marca el número buscado
                            LlenarCont(Integer.parseInt(buscarTxf.getText()));
                        }else{
                            // Llama a la alerta que indica que el numero no esta en la cola
                            LlamarAlertValorNoEncontrado();
                            // Limpia el textfield de buscar
                            buscarTxf.clear();
                        }
                    }else{
                        // Llama a la alerta de valores incorrectos
                        LlamarAlertValoresIncorrectos();
                        // Limpia el textfield de buscar
                        buscarTxf.clear();
                    }
                }else{
                    // Llama a la alerta de cola vacia
                    LlamarAlertColaVacia();
                    // Limpia el textfield de buscar
                    buscarTxf.clear();
                }
            }
        });
        // Acción del botón extraer
        this.extraerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Invoca al método de la clase cola para extaer el primer elemento de la cola
                cl.Extraer();
                // Vuelve a llenar el contenedor para verificar que se borro el elemento
                LlenarCont(0);
            }
        });
        // Acción del botón vaciar
        this.vaciarBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Invoca al método Vaciar cola de la clase cola
                cl.VaciarCola();
                // Limpia el contenedor
                contenedorFP.getChildren().clear();
                // Muestra en 0 el tamaño de la cola
                tamañoLbl.setText("0");
            }
        });
    }
    // Método para llenar el contenedor
    public void LlenarCont(int buscador){
        // Limpia el mismo contenedor
        contenedorFP.getChildren().clear();
        /**
         * Ciclo que recorrera la cola, inicia con un nodo temporal igual al el frente de la cola,
         * se repite mientras sea diferente de nulo,
         * temporal sera igual a el siguiente valor de la cola
         */
        for (Nodo temp = cl.frente;temp!=null;temp = temp.getProximo()) {
            // Se introduce la ruta de la imagen por defecto, el de color azul claro
            String toy = "src/PracticaColas/image/M1.png";
            // Se crea el contenedor para la cola y su imagen
            VBox caja = new VBox();
            // Se crea el contenedor para la cola
            Label nodo = new Label(temp.getValor().toString());
            // Si el buscador es diferente a cero el flujo pasa por el if
            if (temp.getValorInt()==buscador){
                // Si el buscador es igual a el valor de temp el muñequito cambia de azul claro a azul oscuro
                toy = "src/PracticaColas/image/M2.png";
            }
            // Se crea el contenedor de la imgen, se iguala a null
            ImageView Muñequito = null;
            // Para evitar errores se inicia un try-catch
            try {
                // Se incia un file con la ruta del muñeco designado
                File archivo = new File(toy);
                //System.out.println(archivo.toURI().toURL().toString());
                // Se crea una imagen con la rura del archivo asignada
                Image imagen = new Image(archivo.toURI().toURL().toString());
                // Se introduce la imagen dentro de su contendor
                Muñequito = new ImageView(imagen);
            }catch (Exception e){
                // En caso de un error se imprime la ruta de la imagen
                e.printStackTrace();
            }
            // El tamaño del número de la cola se hace más grande
            nodo.setStyle("-fx-font-size:30px;");
            // Por orden de poicion primero se introduce el valor de la cola
            caja.getChildren().add(nodo);
            // Desspues se introduce la imagen correspondiente
            caja.getChildren().add(Muñequito);
            // Y se concluye metiendo el contenedor de la cola e imgagen, dentro del contenedor general
            contenedorFP.getChildren().add(caja);
        }
        // Actualiza el contendor del tamaño
        tamañoLbl.setText(cl.getSize()+"");
    }
    // Método para comprobar si lo que inserto el usuario es un entero
    public boolean ComprobarInt (String num){
        // Se inicia un try-catch para evitar errores
        try {
            // Si la acción de Integer.parseint secompleta con exito retorna verdadero
            Integer.parseInt(num);
            return true;
        }catch (Exception e){
            // Si no, retorna falso
            return false;
        }
    }
    /*
    * Los siguiente son las alertas especificadas para cada ocación
    * La mayoria se llaman en la acción de buscar
    * */
    public void LlamarAlertValoresIncorrectos(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Valores Incorrectos");
        alert.setContentText("Acabas de ingresar datos que no son numericos" +
                "\npor favor introduce valores numericos enteros" +
                "\ny que sean mayores a cero");
        alert.showAndWait();
    }
    public void LlamarAlertColaVacia(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sin valores en la cola");
        alert.setContentText("Al parecer la cola esta vácia, " +
                "\nno puedes algo donde no hay nada");
        alert.showAndWait();
    }
    public void LlamarAlertValorNoEncontrado(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Número sin encontrar");
        alert.setContentText("Usted ha ingresado un valor que no esta en" +
                            "\nla cola, por favor intente otra vez");
        alert.showAndWait();
    }
}