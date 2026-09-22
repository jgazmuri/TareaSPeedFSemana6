package vista;

import modelo.Pedido;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.util.List;

public class VentanaRegistroPedido extends JFrame {

    private List<Pedido> pedidos;

    public VentanaRegistroPedido(List<Pedido> pedidos) {
        this.pedidos = pedidos;

        setTitle("SpeedFast - Registrar Pedido");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel labelId = new JLabel("ID Pedido:");
        JTextField campoId = new JTextField();

        JLabel labelDireccion = new JLabel("Direccion:");
        JTextField campoDireccion = new JTextField();

        JLabel labelTipo = new JLabel("Tipo:");
        String[] tipos = {"Comida", "Encomienda", "Express"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        JButton botonGuardar = new JButton("Guardar");

        add(labelId);
        add(campoId);
        add(labelDireccion);
        add(campoDireccion);
        add(labelTipo);
        add(comboTipo);
        add(new JLabel());
        add(botonGuardar);

        botonGuardar.addActionListener(e -> {
            String textoId = campoId.getText();
            String direccion = campoDireccion.getText();
            String tipo = (String) comboTipo.getSelectedItem();

            if (textoId.isEmpty() || direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar el ID y la direccion.");
                return;
            }

            try {
                int id = Integer.parseInt(textoId);
                Pedido nuevoPedido = new Pedido(id, direccion, tipo);
                pedidos.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido guardado correctamente.");
                campoId.setText("");
                campoDireccion.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El ID debe ser un numero.");
            }
        });

        setVisible(true);
    }
}