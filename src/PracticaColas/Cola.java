package PracticaColas;

/**
 * Created by Akado on 16/11/2017.
 */
public class Cola {
    public Nodo frente; //el inicio de la cola
    public int size = 0; //Tamaño de la cola
    //Constructor simple
    public Cola() {
        this.frente = null;
    }
    //Método para insertar siguiente elemento (nodo), el elemento debe colocarse detrás del último nodo
    public void Insertar(Object valor){
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
    //Método para Extraer el elemento del frente
    public Object Extraer(){
        if(frente == null){
            size--;
            return 0;
        }else{
            Object valorExtraer = frente.getValor(); //variable temporal
            frente = frente.getProximo(); //cambiar el frente por el siguiente
            //System.out.println("Valor extraído: "+ frente.getValor());
            size--;
            return valorExtraer ; //devolver el valor extraído de la cola
        }
    }
    // Método para obtener el tamaño de la cola
    public int getSize(){
        return size;
    }
    // Metodo para vaciar cola
    public void VaciarCola(){
        frente = null;
        size = 0;
    }
    // Método para comprobar si la cola esta vacia
    public boolean itsEmpty(){
        if (frente == null){
            return false;
        }else {
        return true;
        }
    }
    // Método verificar si en una cola esta un valor
    public boolean itsHere(Object H1){
        boolean h = false;
        int H2 = Integer.parseInt(H1.toString());
        for (Nodo temp=frente;temp!=null;temp=temp.getProximo()){
            if (H2 == temp.getValorInt()){
                h = true;
            }
        }
        return h;
    }
}