package org.phoenix;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.phoenix.enums.RequestType;
import org.phoenix.exchanges.AbstractExchange;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Request {

    public static HttpResponse<String> sendPostRequest(String url, JSONObject body, AbstractExchange exchange) throws IOException, InterruptedException, NoSuchAlgorithmException {
        HttpClient client = HttpClient.newHttpClient();
        var request = createRequest(url, body, RequestType.POST, exchange);
        return client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> sendGetRequest(String url, AbstractExchange exchange) throws IOException, InterruptedException, NoSuchAlgorithmException {
        HttpClient client = HttpClient.newHttpClient();
        var request = createRequest(url, null, RequestType.GET, exchange);
        return client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
    }

    private static HttpRequest createRequest(String url, JSONObject body, RequestType method, AbstractExchange exchange) throws NoSuchAlgorithmException {
        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .header("Content-Type", "application/json");

        Map<String, String> headers = exchange.getHeaders(body, url);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            requestBuilder.header(entry.getKey(), entry.getValue());
        }

        return switch (method) {
            case POST -> requestBuilder.POST(HttpRequest.BodyPublishers.ofString(String.valueOf(body))).build();
            case GET -> requestBuilder.GET().build();
            default -> throw new IllegalArgumentException("Invalid method: " + method);
        };
    }
}
