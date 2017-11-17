package PracticaColas;

/**
 * Created by Akado on 16/11/2017.
 */
public class Cola {
    private Nodo frente; //el inicio de la cola
    public int size = 0;
    //constructor simple
    public Cola() {
        this.frente = null;
    }
    //Método para insertar siguiente elemento (nodo), el elemento debe colocarse detrás del último nodo
    public void Insertar(int valor){
        Nodo nuevo = new Nodo(valor);
        if(frente == null){
            frente = nuevo;
        }else{
            Nodo temp = frente;
            while(temp.getProximo() != null){
                temp = temp.getProximo();
            }
            temp.setProximo(nuevo);
        }
        size++;
    }
    //Método para mostrar los elementos de la cola
    public void Mostrar(){
        if( frente != null){
            Nodo temp = frente;
            System.out.println("Los valores de la cola son: ");
            while(temp != null){
                System.out.println(temp.getValor());
                temp = temp.getProximo();
            }
        }else{
            System.out.println("La cola está vacía.");
        }
    }
    //Método para extraer el elemento del frente
    public int extraer(){
        if(frente == null){
            return 0;
        }else{
            int valorExtraer = frente.getValor(); //variable temporal
            frente = frente.getProximo(); //cambiar el frente por el siguiente
            System.out.println("Valor extraído: "+ frente.getValor());
            return valorExtraer ; //devolver el valor extraído de la cola
        }
    }
}
