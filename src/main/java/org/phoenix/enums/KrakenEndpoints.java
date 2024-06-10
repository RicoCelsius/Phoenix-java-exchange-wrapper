package org.phoenix.enums;

public enum KrakenEndpoints {

    CREATE_ORDER("private/AddOrder"),
    CANCEL_ORDER("private/CancelOrder"),
    GET_ACCOUNT_BALANCE("private/Balance");

    public final String url;

    KrakenEndpoints(String url) {
        this.url = url;
    }
}
