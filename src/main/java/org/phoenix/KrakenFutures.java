package org.phoenix;

public class KrakenFutures extends AbstractExchange{
    @Override
    void getBalance() {

    }

    @Override
    void getOpenOrders() {

    }

    @Override
    void createLimitOrder(String pair, String type, String price) {

    }

    @Override
     String getBaseUrl() {
        return "https://api.kraken.com/0";
    }
}
