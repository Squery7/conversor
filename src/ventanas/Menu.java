package ventanas;

import java.awt.Color;

import javax.swing.*;

public class Menu extends VentanaBase {

    private JPanel panelPrincipal;
    private JButton botonMonedas;
    private JButton botonTemperatura;
    private JButton botonMedidas;
    private JButton botonSalir;

    public Menu() {
        super();
        this.ajustesPorDefecto();
    }

    public Menu(String nombreVentana) {
        super(nombreVentana);
        this.ajustesPorDefecto();
    }

    public Menu(String nombreVentana, int tamX, int tamY) {
        super(nombreVentana, tamX, tamY);
        this.ajustesPorDefecto();
    }

    private void ajustesPorDefecto() {
        this.panelPrincipal = new JPanel();
        this.botonMonedas = new JButton();
        this.botonTemperatura = new JButton();
        this.botonMedidas = new JButton();
        this.botonSalir = new JButton();
    }

    @Override
    public void execute() {
        this.ventanaPrincipal.setLayout(null); // Quita los ajustes por defecto de una ventana
        this.ventanaPrincipal.setResizable(true); // Redimensionable
        this.ventanaPrincipal.setLocationRelativeTo(null); // Centrada en la pantalla
        this.ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar el programa al presionar X

        this.AgregarPanelPrincipal();
        this.AgregarBotonMonedas();
        this.AgregarBotonTemperatura();
        this.AgregarBotonMedidas();
        this.AgregarBotonSalir();

        this.ventanaPrincipal.setVisible(true);
    }

    private void AgregarPanelPrincipal() {
        this.panelPrincipal.setLayout(null);
        this.panelPrincipal.setBackground(new Color(102, 178, 255));
        this.panelPrincipal.setBounds(0, 0, this.ventanaPrincipal.getWidth() - 16,
                this.ventanaPrincipal.getHeight() - 39);

        this.ventanaPrincipal.add(this.panelPrincipal);
    }

    private void AgregarBotonMonedas() {
        this.botonMonedas.setText("Conversor de monedas");
        this.botonMonedas.setBounds(50, 30, 250, 30);

        this.botonMonedas.addActionListener(e -> {
            Moneda money = new Moneda("Conversor de Monedas", 480, 330, this);
            this.ventanaPrincipal.setVisible(false);
            money.execute();
        });

        this.panelPrincipal.add(this.botonMonedas);
    }

    private void AgregarBotonTemperatura() {
        this.botonTemperatura.setText("Conversor de temperatura");
        this.botonTemperatura.setBounds(50, 70, 250, 30);

        this.botonTemperatura.addActionListener(e -> {
            Temperatura tem = new Temperatura("Temperatura", 480, 330, this);
            this.ventanaPrincipal.setVisible(false);
            tem.execute();
        });

        this.panelPrincipal.add(this.botonTemperatura);
    }

    private void AgregarBotonMedidas() {
        this.botonMedidas.setText("Conversor de medidas");
        this.botonMedidas.setBounds(50, 110, 250, 30);

        this.botonMedidas.addActionListener(e -> {
            Medida med = new Medida("Medidas", 480, 330, this);
            med.execute();
            this.ventanaPrincipal.setVisible(false);
        });

        this.panelPrincipal.add(this.botonMedidas);
    }

    private void AgregarBotonSalir() {
        this.botonSalir.setText("Salir");
        this.botonSalir.setBounds(50, 150, 250, 30);

        this.botonSalir.addActionListener(e -> {
            System.exit(0);
        });

        this.panelPrincipal.add(this.botonSalir);
    }

}
