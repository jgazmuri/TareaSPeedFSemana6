package reparto;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Despachable, Cancelable, Rastreable {

    private List<Pedido> pedidosActivos = new ArrayList<>();
    private List<Pedido> historialEntregas = new ArrayList<>();

    // "Reservar pedido": lo agregamos a la lista de activos.
    public void reservarPedido(Pedido pedido) {
        pedidosActivos.add(pedido);
        System.out.println("Pedido #" + pedido.getId() + " reservado con éxito.");
    }

    @Override
    public void despachar() {
        for (Pedido pedido : pedidosActivos) {
            pedido.asignarRepartidor();
            System.out.println("Despachando pedido #" + pedido.getId() + "...");
            pedido.mostrarResumen();
        }
        historialEntregas.addAll(pedidosActivos);
        pedidosActivos.clear();
    }

    @Override
    public void cancelar() {
        if (!pedidosActivos.isEmpty()) {
            Pedido cancelado = pedidosActivos.remove(0);
            System.out.println("Pedido #" + cancelado.getId() + " cancelado.");
        } else {
            System.out.println("No hay pedidos activos para cancelar.");
        }
    }

    @Override
    public void verHistorial() {
        System.out.println("----- Historial de entregas -----");
        for (Pedido pedido : historialEntregas) {
            System.out.println("Pedido #" + pedido.getId() + " - Cliente: " + pedido.getCliente());
        }
    }
}