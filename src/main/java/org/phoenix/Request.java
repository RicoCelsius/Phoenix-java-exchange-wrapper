package org.phoenix;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

public class Request {



    static HttpResponse<String> sendPostRequest(String url, String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        var request = java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .header("Content-Type", "application/json")
                .POST(java.net.http.HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        }

    }

