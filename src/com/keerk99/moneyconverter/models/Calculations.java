package com.keerk99.moneyconverter.models;

import java.util.Scanner;

public class Calculations {
    private final SearchMoney searchMoney;

    public Calculations() {
        this.searchMoney = new SearchMoney();
    }

    public void conversion(String moneyType, String moneyResult) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el valor que desea convertir: ");
        double quantity = teclado.nextDouble();

        Money money = searchMoney.checkmoney(moneyType);
        Double rate = money.conversion_rates().get(moneyType);
        Double rateConverted = money.conversion_rates().get(moneyResult);

        if (rate == null) {
            try {
                throw new IllegalAccessException("No se encontró la tasa de conversión para la moneda: " +moneyType);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        double result = rate * rateConverted * quantity;

        System.out.println("Valor del cambio: " +money.conversion_rates().get(moneyResult));
        System.out.println("El valor de " +quantity +
                " " + moneyType + " corresponde al valor final de =>> " + result +
                " " + moneyResult);
    }
}
