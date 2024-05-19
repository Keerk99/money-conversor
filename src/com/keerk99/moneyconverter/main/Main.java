package com.keerk99.moneyconverter.main;

import com.keerk99.moneyconverter.models.Calculations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String menu = """
                    **********************************************************************
                    Sea bienvenido/a al Conversor de Moneda :)

                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar ==> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dólar
                    7) Salir
                    Elija una opción válida:
                    **********************************************************************
                    """;

        System.out.println(menu);

        int option = teclado.nextInt();

        while (option != 7) {

            Calculations calculations = new Calculations();

            switch (option) {
                case 1:
                    calculations.conversion("USD", "ARS");
                    break;
                case 2:
                    calculations.conversion("ARS", "USD");
                    break;
                case 3:
                    calculations.conversion("USD", "BRL");
                    break;
                case 4:
                    calculations.conversion("BRL", "USD");
                    break;
                case 5:
                    calculations.conversion("USD", "COP");
                    break;
                case 6:
                    calculations.conversion("COP", "USD");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }

            System.out.println(menu);
            option = teclado.nextInt();

        }

        System.out.println("Gracias por usar el conversor de monedas :)");
    }
}
