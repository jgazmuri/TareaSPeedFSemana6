package com.puertogames;

import modelo.Pedido;
import modelo.Repartidor;
import modelo.ZonaDeCarga;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        escenarioOriginal();
    }

    private static void escenarioOriginal() throws InterruptedException {
        System.out.println("\n########## ESCENARIO 1: caso original (3 repartidores, 5 pedidos) ##########");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        zonaDeCarga.agregarPedido(new Pedido(1, "Av. Siempre Viva 123"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Calle Falsa 456"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Pasaje Central 789"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Los Aromos 321"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Villa del Mar 77"));

        Repartidor repartidor1 = new Repartidor("Juan", zonaDeCarga);
        Repartidor repartidor2 = new Repartidor("Maria", zonaDeCarga);
        Repartidor repartidor3 = new Repartidor("Pedro", zonaDeCarga);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(repartidor1);
        executor.submit(repartidor2);
        executor.submit(repartidor3);

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Todos los pedidos han sido entregados correctamente");
    }
}