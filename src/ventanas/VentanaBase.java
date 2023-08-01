package ventanas;

import javax.swing.*;

public abstract class VentanaBase {

    protected JFrame ventanaPrincipal;

    public VentanaBase() {
        this.ventanaPrincipal = new JFrame();
    }

    public VentanaBase(String s) {
        this.ventanaPrincipal = new JFrame(s);
    }

    public VentanaBase(String s, int x, int y) {
        this.ventanaPrincipal = new JFrame(s);
        this.ventanaPrincipal.setSize(x, y);
    }

    public abstract void execute();

}
