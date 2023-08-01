package ventanas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import funcionalidad.Conversor;

public class Medida extends VentanaBase {

    private JPanel panelPrincipal;
    private JLabel etiquetaPrincipal;
    private JLabel etiquetaEntrada;
    private JLabel etiquetaSalida;

    private JTextField entradaDato;
    private JTextField salidaDato;
    private JComboBox<String> comboOpciones;
    private JCheckBox checkInversor;
    private JButton botonCalcular;
    private JButton botonCerrar;
    private JButton botonLimpiar;

    private Conversor c = new Conversor();

    private Menu m;

    public Medida() {
        super();
        this.ajustesPorDefecto();
    }

    public Medida(String nombreVentana) {
        super(nombreVentana);
        this.ajustesPorDefecto();
    }

    public Medida(String nombreVentana, int tamX, int tamY, Menu m) {
        super(nombreVentana, tamX, tamY);
        this.m = m;
        this.ajustesPorDefecto();
    }

    private void ajustesPorDefecto() {
        this.panelPrincipal = new JPanel();
        this.etiquetaPrincipal = new JLabel();
        this.etiquetaEntrada = new JLabel();
        this.etiquetaSalida = new JLabel();
        this.entradaDato = new JTextField();
        this.salidaDato = new JTextField();
        this.checkInversor = new JCheckBox();
        this.botonCalcular = new JButton();
        this.botonCerrar = new JButton();
        this.botonLimpiar = new JButton();
    }

    @Override
    public void execute() {
        this.ventanaPrincipal.setLayout(null);
        this.ventanaPrincipal.setResizable(false);
        this.ventanaPrincipal.setLocationRelativeTo(null);
        this.ventanaPrincipal.setDefaultCloseOperation(3); // Exit on close

        this.AgregarPanelPrincipal();
        this.AgregarEtiquetaPrincipal();
        this.AgregarEtiquetaEntrada();
        this.AgregarEtiquetaSalida();
        this.AgregarEntradaDato();
        this.AgregarSalidaDato();
        this.AgregarComboOpciones();
        this.AgregarCheckInversor();
        this.AgregarBotonCalcular();
        this.AgregarBotonCerrar();
        this.AgregarBotonLimpiar();

        this.ventanaPrincipal.setVisible(true);
    }

    private void AgregarPanelPrincipal() {
        this.panelPrincipal.setLayout(null);
        this.panelPrincipal.setBackground(new Color(102, 178, 255));
        this.panelPrincipal.setBounds(0, 0, this.ventanaPrincipal.getWidth() - 16,
                this.ventanaPrincipal.getHeight() - 39);

        this.ventanaPrincipal.add(this.panelPrincipal);
    }

    private void AgregarEtiquetaPrincipal() {
        this.etiquetaPrincipal.setText("Ingrese la cantidad que desea convertir ");
        this.etiquetaPrincipal.setFont(new Font("Bold", Font.BOLD, 20));
        this.etiquetaPrincipal.setBounds(50, 15, 380, 30);
        this.panelPrincipal.add(this.etiquetaPrincipal);
    }

    private void AgregarEtiquetaEntrada() {
        this.etiquetaEntrada.setText("Entrada");
        this.etiquetaEntrada.setBounds(50, 70, 181, 30);
        this.panelPrincipal.add(this.etiquetaEntrada);
    }

    private void AgregarEtiquetaSalida() {
        this.etiquetaSalida.setText("Salida");
        this.etiquetaSalida.setBounds(241, 70, 181, 30);
        this.panelPrincipal.add(this.etiquetaSalida);
    }

    private void AgregarEntradaDato() {
        this.entradaDato.setHorizontalAlignment(0);
        this.entradaDato.setBounds(50, 100, 181, 30);
        this.entradaDato.setFont(new Font("Bold", Font.BOLD, 15));
        this.panelPrincipal.add(this.entradaDato);
    }

    private void AgregarSalidaDato() {
        this.salidaDato.setHorizontalAlignment(0);
        this.salidaDato.setBounds(241, 100, 181, 30);
        this.salidaDato.setFont(new Font("Bold", Font.BOLD, 15));
        this.salidaDato.setEnabled(false);
        this.panelPrincipal.add(this.salidaDato);
    }

    private void AgregarComboOpciones() {
        String[] opciones = {
                "Metros a Milimetros",
                "Metros a Centimetros",
                "Metros a Decimetros",
                "Metros a Kilometros",
                "Metros a Millas"
        };
        this.comboOpciones = new JComboBox<>(opciones);

        this.comboOpciones.setBounds(125, 150, 220, 30);
        this.panelPrincipal.add(this.comboOpciones);
    }

    private void AgregarCheckInversor() {
        this.checkInversor.setText("Invertir Medida");
        this.checkInversor.setBounds(182, 190, 130, 30);
        this.checkInversor.setBackground(new Color(102, 178, 255));
        this.checkInversor.setAlignmentX(0);
        this.panelPrincipal.add(this.checkInversor);
    }

    private void AgregarBotonCalcular() {
        this.botonCalcular.setText("Calcular");
        this.botonCalcular.setBackground(new Color(171, 235, 198));
        this.botonCalcular.setBounds(50, 230, 140, 40);

        this.botonCalcular.addActionListener(e -> {
            boolean inversor = this.checkInversor.isSelected();
            String valorEnString = this.entradaDato.getText().trim();
            String tipoString = (String) this.comboOpciones.getSelectedItem();

            if (!valorEnString.isEmpty()) {
                try {
                    double valor = Double.parseDouble(valorEnString);
                    if (valor <= 0) {
                        JOptionPane.showMessageDialog(null,
                                "Error, solo se permite el ingreso de numeros positivos mayores a 0!");
                    } else {
                        double valorConvertido = c.execute(this.tipoConversion(tipoString), valor, inversor);
                        this.salidaDato.setText(String.valueOf(valorConvertido));
                        // JOptionPane.showMessageDialog(null, valorConvertido);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error, solo se permite el ingreso de numeros!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un dato, por favor!");
            }

        });

        this.panelPrincipal.add(this.botonCalcular);
    }

    private void AgregarBotonCerrar() {
        this.botonCerrar.setText("Cerrar");
        this.botonCerrar.setBackground(new Color(230, 176, 170));
        this.botonCerrar.setBounds(282, 230, 140, 40);

        this.botonCerrar.addActionListener(e -> {
            this.entradaDato.setText("");
            this.salidaDato.setText("");
            this.ventanaPrincipal.setVisible(false);
            this.m.ventanaPrincipal.setVisible(true);
        });

        this.panelPrincipal.add(this.botonCerrar);
    }

    private void AgregarBotonLimpiar() {
        this.botonLimpiar.setText("Limpiar");
        this.botonLimpiar.setBackground(new Color(252, 243, 207));
        this.botonLimpiar.setBounds(195, 230, 80, 30);

        this.botonLimpiar.addActionListener(e -> {
            this.entradaDato.setText("");
            this.salidaDato.setText("");
        });

        this.panelPrincipal.add(this.botonLimpiar);
    }

    private int tipoConversion(String s) {
        switch (s) {
            case "Metros a Milimetros":
                return 6;
            case "Metros a Centimetros":
                return 7;
            case "Metros a Decimetros":
                return 8;
            case "Metros a Kilometros":
                return 9;
            case "Metros a Millas":
                return 10;
            default:
                return 0;
        }
    }

}
