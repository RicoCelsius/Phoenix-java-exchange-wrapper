package org.phoenix;

import org.phoenix.exchanges.KrakenFutures;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws URISyntaxException {

        KrakenFutures krakenFutures = new KrakenFutures("apiKey", "apiSecret");
        try {
            String response = krakenFutures.createLimitOrder("BTCUSD", "buy", "10000", "1000");
            System.out.println(response);
        }
        catch (Exception e) {
            e.printStackTrace();




    }
}}