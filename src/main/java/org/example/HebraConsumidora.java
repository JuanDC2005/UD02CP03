package org.example;

public class HebraConsumidora implements Runnable {
    private VariableCompartida vc;

    public HebraConsumidora(VariableCompartida vc) {
        this.vc = vc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Valor recogido: " + vc.get());
        }
    }
}
