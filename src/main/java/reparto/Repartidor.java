package reparto;

import java.util.List;
import java.util.Random;

public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> pedidosAsignados;
    private Random random = new Random();

    public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
        this.nombre = nombre;
        this.pedidosAsignados = pedidosAsignados;
    }

    @Override
    public void run() {
        System.out.println(nombre + " inicia su recorrido con " + pedidosAsignados.size() + " pedido(s).");

        for (Pedido pedido : pedidosAsignados) {
            pedido.asignarRepartidor(nombre);
            System.out.println(nombre + " va en camino al pedido #" + pedido.getId()
                    + " (" + pedido.getCliente() + ")...");

            try {
                int tiempoSimuladoMs = 1000 + random.nextInt(3000); // entre 1 y 4 segundos
                Thread.sleep(tiempoSimuladoMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " fue interrumpido y detiene su recorrido.");
                return;
            }

            System.out.println(nombre + " entregó el pedido #" + pedido.getId()
                    + " a " + pedido.getCliente() + ".");
        }

        System.out.println(nombre + " terminó su recorrido.");
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }
}