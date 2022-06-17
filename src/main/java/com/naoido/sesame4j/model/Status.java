package com.naoido.sesame4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {
    @JsonProperty("batteryPercentage")
    private int batteryPercentage;
    @JsonProperty("batteryVoltage")
    private double batteryVoltage;
    @JsonProperty("position")
    private int position;
    @JsonProperty("CHSesame2Status")
    private String sesameStatus;
    @JsonProperty("wm2State")
    private boolean wm2State;
    @JsonProperty("timestamp")
    private String timestamp;

    public Status() {}

    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public double getBatteryVoltage() {
        return this.batteryVoltage;
    }

    public int getPosition() {
        return this.position;
    }

    public String getSesameStatus() {
        return this.sesameStatus;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public boolean getWm2State() {
        return this.wm2State;
    }
}
