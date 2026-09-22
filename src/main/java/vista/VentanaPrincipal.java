package vista;

import modelo.Pedido;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal extends JFrame {

    private List<Pedido> pedidos = new ArrayList<>();

    public VentanaPrincipal() {
        setTitle("SpeedFast - Menu Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton botonRegistrar = new JButton("Registrar Pedido");
        JButton botonVerPedidos = new JButton("Ver Pedidos");
        JButton botonSalir = new JButton("Salir");

        add(botonRegistrar);
        add(botonVerPedidos);
        add(botonSalir);

        botonRegistrar.addActionListener(e -> new VentanaRegistroPedido(pedidos));
        botonVerPedidos.addActionListener(e -> new VentanaListaPedidos(pedidos));
        botonSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}