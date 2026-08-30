package reparto;

public abstract class Pedido {

    protected int id;
    protected String cliente;
    protected String direccionEntrega;
    protected String repartidorAsignado;

    public Pedido(int id, String cliente, String direccionEntrega) {
        this.id = id;
        this.cliente = cliente;
        this.direccionEntrega = direccionEntrega;
        this.repartidorAsignado = "Sin asignar";
    }

    public abstract double calcularTiempoEntrega();

    public void asignarRepartidor() {
        this.repartidorAsignado = "Repartidor genérico";
    }

    public void asignarRepartidor(String nombre) {
        this.repartidorAsignado = nombre;
    }

    public void mostrarResumen() {
        System.out.println("----- Resumen del pedido #" + id + " -----");
        System.out.println("Cliente: " + cliente);
        System.out.println("Entrega en: " + direccionEntrega);
        System.out.println("Repartidor: " + repartidorAsignado);
        System.out.println("Tiempo estimado: " + calcularTiempoEntrega() + " minutos");
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getRepartidorAsignado() {
        return repartidorAsignado;
    }
}