package PracticaColas;

/**
 * Created by Akado on 16/11/2017.
 */
public class Nodo {
    private int valor;
    private Nodo proximo;

    public Nodo (){
        this.valor = 0;
        this.proximo = null;
    }

    public Nodo(int v){
        this.valor = v;
        this.proximo = null;
    }

    public void setValor(int v){
        valor = v;
    }

    public void setProximo(Nodo p){
        proximo = p;
    }

    public int getValor(){
        return valor;
    }

    public Nodo getProximo(){
        return proximo;
    }
}


