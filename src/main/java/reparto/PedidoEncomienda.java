package reparto;

public class PedidoEncomienda extends Pedido {

    private double pesoKg;

    public PedidoEncomienda(int id, String cliente, String direccionEntrega, double pesoKg) {
        super(id, cliente, direccionEntrega);
        this.pesoKg = pesoKg;
    }

    @Override
    public double calcularTiempoEntrega() {
        return 45 + (pesoKg * 2);
    }

    @Override
    public void asignarRepartidor() {
        if (pesoKg > 10) {
            this.repartidorAsignado = "Repartidor en camioneta (encomienda)";
        } else {
            this.repartidorAsignado = "Repartidor en auto (encomienda)";
        }
    }
}