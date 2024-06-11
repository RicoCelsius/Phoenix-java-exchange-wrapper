package org.phoenix;

public abstract class AbstractExchange {



    abstract void getBalance();
    abstract void getOpenOrders();
    abstract void createLimitOrder(String pair, String type, String price);
    abstract String getBaseUrl();
}
