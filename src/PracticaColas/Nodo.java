package PracticaColas;

/**
 * Created by Akado on 16/11/2017.
 */
public class Nodo {
    private Object valor;// Variable que guarda el elemento a unir en el nodo
    private Nodo proximo;// Nodo que une la lista
    // Constructor simple
    public Nodo (){
        this.valor = 0;
        this.proximo = null;
    }
    // Constructor que une a la lista
    public Nodo(Object v){
        this.valor = v;
        this.proximo = null;
    }
    // Método para asignar el siguiente nodo
    public void setProximo(Nodo p){
        proximo = p;
    }
    // Metodo para devolver el valor del elemento actual
    public Object getValor(){
        return valor;
    }
    // Método para devolver el valor del elemto actual pero en entero
    public int getValorInt(){return Integer.parseInt(valor.toString());}
    // Método para obtener el siguiente valor del nodo actual
    public Nodo getProximo(){
        return proximo;
    }
}