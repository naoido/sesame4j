package com.naoido.sesame4j.model;

public class Key {
    private final String uuid;
    private final String secretKey;

    public Key(String uuid, String secretKey) {
        this.uuid = uuid;
        this.secretKey = secretKey;
    }


    public String getUuid() {
        return this.uuid;
    }

    public String getSecretKey() {
        return this.secretKey;
    }
}
