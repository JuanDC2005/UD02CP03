package org.example;

public class VariableCompartida {
    private int v;
    private boolean hayDatoNuevo = false;

    public synchronized void set(int valor) {
        while (hayDatoNuevo) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.v = valor;
        hayDatoNuevo = true;
        notifyAll();
    }

    public synchronized int get() {
        while (!hayDatoNuevo) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hayDatoNuevo = false;
        notifyAll();
        return v;
    }
}