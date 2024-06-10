package org.phoenix;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;

public class Authentication {

    public static long getNonce() {
        return Instant.now().toEpochMilli();
    }
}
