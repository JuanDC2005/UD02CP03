package org.example;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        VariableCompartida vc = new VariableCompartida();

        HebraProductora hp = new HebraProductora(vc);
        HebraConsumidora hc = new HebraConsumidora(vc);

        Thread t1 = new Thread(hp);
        Thread t2 = new Thread(hc);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Han finalizado las dos hebras.");
    }
}

/*
 * RESPUESTA A LAS PREGUNTAS:
 * 
 * 1. ¿Se recogen todos los valores? ¿Qué ocurre?
 * En una implementación sin coordinación adecuada, no se recogen todos los valores:
 * - Se producen pérdidas de datos por sobreescritura si la hebra productora avanza más rápido.
 * - Se producen lecturas duplicadas e inconsistentes si la hebra consumidora
 * lee antes de generarse un nuevo valor.
 * - Esto genera desperdicio de ciclos de cómputo y resultados erróneos.
 * 
 * 2. Solución aplicada:
 * Para maximizar la utilidad del sistema, evitar el desperdicio
 * de recursos y garantizar la total integridad de los datos,
 * se implementa el patrón Productor-Consumidor mediante monitores
 * synchronized, una bandera de estado (hayDatoNuevo)
 * y los métodos wait() y notifyAll() en VariableCompartida.
 * De este modo, los 100 valores (0 al 99) son producidos
 * y consumidos exactamente una vez en perfecto orden.
 */



