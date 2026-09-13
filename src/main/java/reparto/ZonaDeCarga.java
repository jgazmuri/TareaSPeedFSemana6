package reparto;
import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    private List<Pedido> pedidosPendientes = new ArrayList<>();

    public synchronized void agregarPedido(Pedido p){

    pedidosPendientes.add(p);

    }

    public synchronized Pedido retirarPedido(){
        if (pedidosPendientes.isEmpty()){
            return null;
            return pedidosPendientes.remove(0);
        }
    }

}
