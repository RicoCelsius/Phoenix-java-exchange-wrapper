package org.phoenix.exchanges;

import org.phoenix.Encryption;
import org.phoenix.Request;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class KrakenFutures extends AbstractExchange {

    public KrakenFutures(String apiKey, String apiSecret) {
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }


    @Override
    public String generateAuthenticationHeader(JSONObject data,String endpoint) throws NoSuchAlgorithmException {
        String none = Encryption.getNonce();
        String concat = data+none+endpoint;
        String hash = Arrays.toString(Encryption.convertToSHA256(concat));
        String decodedSecret = Encryption.decodeFromBase64(apiSecret);
        String signature = Arrays.toString(Encryption.convertToHMACSHA512(hash,decodedSecret));
        System.out.println("Signature: "+signature);
        return Encryption.encodeToBase64(signature.getBytes());
    }

    @Override
    public void getBalance() {

    }

    @Override
    public void getOpenOrders() {

    }

    @Override
    public String createLimitOrder(String pair, String side, String size, String price) throws IOException, InterruptedException, NoSuchAlgorithmException {
        JSONObject order = new JSONObject();
        order.put("orderType", "lmt");
        order.put("symbol", pair);
        order.put("side", side);
        order.put("size", size);
        order.put("limitPrice", price);




        HttpResponse<String> response = Request.sendPostRequest(getBaseUrl() + "sendorder", order,this);
        return response.body();
    }


    @Override
     String getBaseUrl() {
        return "https://futures.kraken.com/derivatives/api/v3/";
    }

    @Override
    public Map<String, String> getHeaders(JSONObject data, String endpoint) throws NoSuchAlgorithmException {
        Map<String,String> headers = new HashMap<>();
        String apiKey = this.apiKey;
        String authEnt = generateAuthenticationHeader(data,endpoint);
        String nonce = Encryption.getNonce();

        headers.put("APIKey", apiKey);
        headers.put("Authent", authEnt);
        headers.put("Nonce", nonce);

        return headers;
    }


}
