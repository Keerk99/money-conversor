package com.keerk99.moneyconverter.models;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchMoney {
    public Money checkmoney(String moneyType) {
        URI address = URI.create("https://v6.exchangerate-api.com/v6/c18595614a0230bc58a9c511/latest/" +moneyType);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), Money.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontró la moneda que desea convertir");
        }
    }
}
