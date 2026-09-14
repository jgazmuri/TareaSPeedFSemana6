package reparto;
import java.util.Random;

import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        Pedido pedido;
        while ((pedido = zonaDeCarga.retirarPedido()) !=null){
            pedido.setEstado("EN_REPARTO");
            System.out.println(nombre + " retiro el pedido #" + pedido.getId() + " y va en camino...");
            try {
                Thread.sleep(1000 + new Random().nextInt(3000));
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
            pedido.setEstado("EMTREGADO");
            System.out.println(nombre + " entrego el pedido #" + pedido.getId() + ".");
        }
        System.out.println(nombre + " no tiene mas pedidos para retirar.");
    }
}

