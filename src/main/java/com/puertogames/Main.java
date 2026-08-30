package com.puertogames;

import reparto.ControladorDeEnvios;
import reparto.PedidoComida;
import reparto.PedidoEncomienda;
import reparto.PedidoExpress;

public class Main {

    public static void main(String[] args) {


        PedidoComida pedido1 = new PedidoComida(1, "Ana Torres", "Av. Siempre Viva 123", true);
        PedidoEncomienda pedido2 = new PedidoEncomienda(2, "Luis Rojas", "Calle Falsa 456", 15.0);
        PedidoExpress pedido3 = new PedidoExpress(3, "Marta Diaz", "Pasaje Central 789", 4.0);
        PedidoComida pedido4 = new PedidoComida(4, "Pedro Soto", "Los Aromos 321", false);

        pedido1.asignarRepartidor();

        pedido2.asignarRepartidor("Carlos Munoz");

        System.out.println("=== Estado antes de reservar/despachar ===");
        pedido1.mostrarResumen();
        pedido2.mostrarResumen();
        pedido3.mostrarResumen();


        ControladorDeEnvios controlador = new ControladorDeEnvios();

        controlador.reservarPedido(pedido4);
        controlador.reservarPedido(pedido1);
        controlador.reservarPedido(pedido2);
        controlador.reservarPedido(pedido3);

        System.out.println("\n=== Cancelando un pedido ===");
        controlador.cancelar();

        System.out.println("\n=== Despachando pedidos ===");
        controlador.despachar();

        System.out.println("\n=== Historial de entregas ===");
        controlador.verHistorial();
    }
}