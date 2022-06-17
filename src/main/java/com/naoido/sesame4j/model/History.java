package com.naoido.sesame4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class History {
    @JsonProperty("type")
    private int type;
    @JsonProperty("timeStamp")
    private double timeStamp;
    @JsonProperty("historyTag")
    private String historyTag;
    @JsonProperty("recordID")
    private int recordId;
    @JsonProperty("parameter")
    private String parameter;

    public History() {}

    public int getType() {
        return this.type;
    }

    public double getTimeStamp() {
        return this.timeStamp;
    }

    public String getHistoryTag() {
        return this.historyTag;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public String getParameter() {
        return this.parameter;
    }
}
