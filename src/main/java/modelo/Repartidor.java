package modelo;

import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;
    private Random random = new Random();

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
        while ((pedido = zonaDeCarga.retirarPedido()) != null) {
            try {
                pedido.setEstado("EN_REPARTO");
                System.out.println(nombre + " retiro el pedido #" + pedido.getId() + " y va en camino...");

                Thread.sleep(1000 + random.nextInt(3000));

                pedido.setEstado("ENTREGADO");
                System.out.println(nombre + " entrego el pedido #" + pedido.getId() + ".");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } catch (Exception e) {
                System.out.println(nombre + " tuvo un error inesperado:");
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " no tiene mas pedidos para retirar.");
    }
}
