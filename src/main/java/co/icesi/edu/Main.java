package co.icesi.edu;

import java.util.ArrayList;
import java.util.List;

//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//

public class Main {

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//

    public static final int[] S = {100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50};


    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//


    public static void main(String[] args) {

        System.out.println("Revertir un String");
        String input = ("Abecedario");
        String reversed = reverseString(input);
        System.out.println(reversed);
        System.out.println("");

        System.out.println("Promedio del array");
        int[] array = {1, 2, 3, 4, 5};
        double promedio = prom(array);
        System.out.println("Resultado: " + promedio);
        System.out.println("");

        System.out.println("División por restas sucesivas");
        int dividendo = 20;
        int divisor = 7;
        divisionEntera(dividendo, divisor);
        System.out.println("");

        System.out.println("Máximo común divisor");
        int a = 48;
        int b = 18;
        int mcd = euclidesMCD(a, b);
        System.out.println("El máximo común divisor de " + a + " y " + b + " es: " + mcd);
        System.out.println("");

        System.out.println("Problema del cambio de dinero");
        int TARGET = 82500;
        List<Integer> cambio = cambioDinero(TARGET);
        System.out.println("Para el valor de " + TARGET + " se puede dar el cambio con: " + cambio);
        System.out.println("");
    }

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//
    //Revertir un String
    public static String reverseString(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//
    // Promedio del array
    public static double prom(int[] array) {
        return calcularPromedio(array, 0, 0);
    }

    private static double calcularPromedio(int[] array, int indice, double sumaParcial) {

        if (indice == array.length) {
            if (array.length != 0) {
                return sumaParcial / array.length;
            } else {
                return 0;

            }
        } else {
            sumaParcial += array[indice];
            return calcularPromedio(array, indice + 1, sumaParcial);
        }
    }


    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//
    //División por restas sucesivas
    public static void divisionEntera(int dividendo, int divisor) {
        if (dividendo <  divisor) {
            System.out.println("Resultado: 0");
            System.out.println("Residuo: " + dividendo);
        } else {
            divisionEntera(dividendo - divisor, divisor);
            System.out.println("Resultado: " + (1 + (dividendo - divisor) / divisor));
        }
    }

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//
    //Máximo común divisor
    public static int euclidesMCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return euclidesMCD(b, a % b);
        }
    }

    //--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//--//
    //Problema del cambio de dinero
    public static List<Integer> cambioDinero(int valor) {
        return cambioDineroRecursivo(valor, 0);
    }

    private static List<Integer> cambioDineroRecursivo(int valor, int indice) {
        List<Integer> cambio = new ArrayList<>();

        if (valor == 0) {
            return cambio;
        }

        while (indice < S.length && S[indice] > valor) {
            indice++;
        }

        if (indice < S.length) {
            int denominacion = S[indice];
            int cantidad = valor / denominacion;
            for (int i = 0; i < cantidad; i++) {
                cambio.add(denominacion);
            }
            int resto = valor % denominacion;
            cambio.addAll(cambioDineroRecursivo(resto, indice + 1));
        }

        return cambio;
    }


}
