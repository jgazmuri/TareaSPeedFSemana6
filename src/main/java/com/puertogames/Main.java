package com.puertogames;

import reparto.ControladorDeEnvios;
import reparto.PedidoComida;
import reparto.PedidoEncomienda;
import reparto.PedidoExpress;
import reparto.Repartidor;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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

        System.out.println("\n=== Simulación concurrente de repartidores ===");

        PedidoComida pedidoA = new PedidoComida(5, "Camila Vera", "Los Nogales 10", true);
        PedidoExpress pedidoB = new PedidoExpress(6, "Jorge Paz", "Av. Central 200", 6.0);
        PedidoEncomienda pedidoC = new PedidoEncomienda(7, "Sofia Leon", "Pasaje Sur 45", 8.0);
        PedidoComida pedidoD = new PedidoComida(8, "Diego Nunez", "Villa del Mar 77", false);
        PedidoExpress pedidoE = new PedidoExpress(9, "Rosa Ibanez", "Calle Norte 3", 3.5);
        PedidoEncomienda pedidoF = new PedidoEncomienda(10, "Tomas Rivas", "Los Alamos 500", 20.0);

        Repartidor repartidor1 = new Repartidor("Juan", Arrays.asList(pedidoA, pedidoB));
        Repartidor repartidor2 = new Repartidor("Maria", Arrays.asList(pedidoC, pedidoD));
        Repartidor repartidor3 = new Repartidor("Pedro", Arrays.asList(pedidoE, pedidoF));

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(repartidor1);
        executor.submit(repartidor2);
        executor.submit(repartidor3);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("\n=== Todos los repartidores terminaron sus entregas ===");
    }
}