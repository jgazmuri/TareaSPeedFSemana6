package reparto;

public class PedidoComida extends Pedido {

    private boolean esComidaCaliente;

    public PedidoComida(int id, String cliente, String direccionEntrega, boolean esComidaCaliente) {
        super(id, cliente, direccionEntrega);
        this.esComidaCaliente = esComidaCaliente;
    }

    @Override
    public double calcularTiempoEntrega() {
        return esComidaCaliente ? 20 : 30;
    }

    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor en moto (comida)";
    }
}
