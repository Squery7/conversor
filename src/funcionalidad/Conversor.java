package funcionalidad;

public class Conversor {

    // Valores de las monedas: Dolar = 0, Euro = 1, Libra = 2, Yen = 3, Won = 4
    private double[] valoresMonedas = { 0.12705804, 0.11521277, 0.098920215, 17.936954, 161.81961 };

    // Valores de las distancias: Milimetros = 0, Centimetros = 1,Decimetros = 2, Kilometros = 3, Millas = 4
    private double[] valoresDistancias = { 1000, 100, 10, 0.001, 0.00062137 };

    public Conversor() {
    }

    /**
     * Este método realiza las operaciones solicitadas tales como:
     * - Convertir una cantidad de un tipo de moneda a otra.
     * - Convertir una cantidad de grados a otra escala.
     * - Convertir una cantidad en distancia a otra escala.
     *
     * @param tipo     Para monedas puede ser:
     *                 - Quetzal a Dolar ó Dolar a Quetzal
     *                 - Quetzal a Euro ó Euro a Quetzal
     *                 - Quetzal a Libra Esterlina ó Libra Esterlina a Quetzal
     *                 - Quetzal a Yen Japonés ó Yen Japonés a Quetzal
     *                 - Quetzal a Won Sur-Coreano ó Won Sur-Coreano a Quetzal
     *                 Para Temperatura puede ser:
     *                 - Celsius a Farenheit ó Farenheit a Celsius
     *                 - Celsius a Kelvin ó Kelvin a Celsius
     *                 - Celsius a Rankine ó Rankine a Celsius
     * @param cantidad La cantidad que se desea convertir.
     * @param inversor Un valor booleano que indica si se debe realizar una
     *                 conversión inversa.
     * @return El valor convertido al dato solicitado.
     */

    public double execute(int tipo, double cantidad, boolean inversor) {
        if (tipo == 1) {
            return this.convertirMonedas(cantidad, inversor, 0); // Dolar
        } else if (tipo == 2) {
            return this.convertirMonedas(cantidad, inversor, 1); // Euro
        } else if (tipo == 3) {
            return this.convertirMonedas(cantidad, inversor, 2); // Libra
        } else if (tipo == 4) {
            return this.convertirMonedas(cantidad, inversor, 3); // Yen
        } else if (tipo == 5) {
            return this.convertirMonedas(cantidad, inversor, 4); // Won
        } else if (tipo == 6) {
            return this.convertirDistancia(cantidad, inversor, 0); // Milimetros
        } else if (tipo == 7) {
            return this.convertirDistancia(cantidad, inversor, 1); // Centimetros
        } else if (tipo == 8) {
            return this.convertirDistancia(cantidad, inversor, 2); // Decimetros
        } else if (tipo == 9) {
            return this.convertirDistancia(cantidad, inversor, 3); // Kilometros
        } else if (tipo == 10) {
            return this.convertirDistancia(cantidad, inversor, 4); // Millas
        } else if (tipo == 11) {
            return this.celsiusFarenheit(cantidad, inversor);
        } else if (tipo == 12) {
            return this.celsiusKelvin(cantidad, inversor);
        } else if (tipo == 13) {
            return this.celsiusRankin(cantidad, inversor);
        }
        return -1;
    }

    // ---------------------- Monedas ---------------------- //
    @Deprecated(forRemoval = true)
    protected double quetzalDolar(double valorQuetzales, boolean inversor) {
        // if (inversor) {
        // return valorQuetzales / this.valores[0];
        // }
        // return valorQuetzales * this.valores[0];
        return inversor ? valorQuetzales / this.valoresMonedas[0] : valorQuetzales * this.valoresMonedas[0];
    }

    @Deprecated(forRemoval = true)
    protected double quetzalEuro(double valorQuetzales, boolean inversor) {
        // if (inversor) {
        // return valorQuetzales / this.valores[1];
        // }
        // return valorQuetzales * this.valores[1];
        return inversor ? valorQuetzales / this.valoresMonedas[1] : valorQuetzales * this.valoresMonedas[1];
    }

    @Deprecated(forRemoval = true)
    protected double quetzalLibras(double valorQuetzales, boolean inversor) {
        // if (inversor) {
        // return valorQuetzales / this.valores[2];
        // }
        // return valorQuetzales * this.valores[2];
        return inversor ? valorQuetzales / this.valoresMonedas[2] : valorQuetzales * this.valoresMonedas[2];
    }

    @Deprecated(forRemoval = true)
    protected double quetzalYen(double valorQuetzales, boolean inversor) {
        // if (inversor) {
        // return valorQuetzales / this.valores[3];
        // }
        // return valorQuetzales * this.valores[3];
        return inversor ? valorQuetzales / this.valoresMonedas[3] : valorQuetzales * this.valoresMonedas[3];
    }

    @Deprecated(forRemoval = true)
    protected double quetzalWonSulCoreano(double valorQuetzales, boolean inversor) {
        // if (inversor) {
        // return valorQuetzales / this.valores[4];
        // }
        // return valorQuetzales * this.valores[4];
        return inversor ? valorQuetzales / this.valoresMonedas[4] : valorQuetzales * this.valoresMonedas[4];
    }

    /**
     * Método optimizado para recibir 3 parámetros
     * 
     * @param valorQuetzales Es el valor decimal en quetzales que se desea convertir
     * @param inversor       true para indicar si se desea de quetzal a una cantidad
     *                       o false para lo contrario
     * @param valor          [0 - 4] para indicar el valor en el arreglo de valores
     *                       correspondiente al equivalente en otra moneda
     * @return El valor convertido a la moneda solicitada
     */
    private double convertirMonedas(double valorQuetzales, boolean inversor, int valor) {
        return inversor ? valorQuetzales / this.valoresMonedas[valor] : valorQuetzales * this.valoresMonedas[valor];
    }

    // ---------------------- Distancia ---------------------- //
    private double convertirDistancia(double valorDistancia, boolean inversor, int valor) {
        return inversor ? valorDistancia / this.valoresDistancias[valor] : valorDistancia * this.valoresDistancias[valor];
    }

    // ---------------------- Grados ---------------------- //
    private double celsiusFarenheit(double grados, boolean inversor) {
        // if (inversor) {
        // return (grados - 32) * 5 / 9;
        // }
        // return (grados * 9 / 5) + 32;
        return inversor ? (grados - 32) * 5 / 9 : (grados * 9 / 5) + 32;
    }

    private double celsiusKelvin(double grados, boolean inversor) {
        // if (inversor) {
        // return grados - 273.15;
        // }
        // return grados + 273.15;
        return inversor ? grados - 273.15 : grados + 273.15;
    }

    private double celsiusRankin(double grados, boolean inversor) {
        // if (inversor) {
        // return (grados - 491.67) * 5 / 9;
        // }
        // return (grados + 273.15) * 9 / 5;
        return inversor ? (grados - 491.67) * 5 / 9 : (grados + 273.15) * 9 / 5;
    }

}
