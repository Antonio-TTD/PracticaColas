package PracticaColas;

/**
 * Created by Akado on 16/11/2017.
 */
public class Nodo {
    private Object valor;
    private Nodo proximo;

    public Nodo (){
        this.valor = 0;
        this.proximo = null;
    }

    public Nodo(Object v){
        this.valor = v;
        this.proximo = null;
    }

    public void setValor(Object v){
        valor = v;
    }

    public void setProximo(Nodo p){
        proximo = p;
    }

    public Object getValor(){
        return valor;
    }

    public Nodo getProximo(){
        return proximo;
    }
}