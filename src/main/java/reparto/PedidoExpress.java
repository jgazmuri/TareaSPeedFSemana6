package reparto;

public class PedidoExpress extends Pedido {

    private double distanciaKm;

    public PedidoExpress(int id, String cliente, String direccionEntrega, double distanciaKm) {
        super(id, cliente, direccionEntrega);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularTiempoEntrega() {
        return distanciaKm * 3;
    }

    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor exprés más cercano disponible";
    }
}