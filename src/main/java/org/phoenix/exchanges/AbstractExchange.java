package org.phoenix.exchanges;

import org.json.JSONObject;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public abstract class AbstractExchange {

    String apiKey;
    String apiSecret;


    abstract String generateAuthenticationHeader(JSONObject data, String endpoint) throws NoSuchAlgorithmException;

    abstract void getBalance();
    abstract void getOpenOrders();
    public abstract String createLimitOrder(String pair, String side, String size, String price) throws IOException, InterruptedException, NoSuchAlgorithmException;

    abstract String getBaseUrl();

    public abstract Map<String, String> getHeaders(JSONObject data, String endpoint) throws NoSuchAlgorithmException;
}
