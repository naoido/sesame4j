package com.naoido.sesame4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.naoido.sesame4j.model.Command;
import com.naoido.sesame4j.model.History;
import com.naoido.sesame4j.model.Key;
import com.naoido.sesame4j.model.Status;
import com.naoido.sesame4j.util.ApiRequest;

import java.io.IOException;
import java.util.List;

public class SesameClient extends ApiRequest{
    private final String apiKey;

    /**
     * Create a Sesame Client.
     * @param apiKey The SesameWebApi Key
     */
    public SesameClient(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Lock the key.
     * @param key target key
     * @param history history name
     */
    public void lock(Key key, String history) {
        sendRequest(key, history, Command.LOCK, this.apiKey);
    }

    /**
     * Unlock the key.
     * @param key target key
     * @param history history name
     */
    public void unlock(Key key, String history) {
        sendRequest(key, history, Command.UNLOCK, this.apiKey);
    }

    /**
     * Toggle the key
     * @param key target key
     * @param history history name
     */
    public void toggle(Key key, String history) {
        sendRequest(key, history, Command.TOGGLE, this.apiKey);
    }

    /**
     * Get a target key's history
     * @param key target key
     * @param page number of pages to get
     * @param log number of logs to get
     * @return History list
     * @throws IOException error
     */
    public List<History> getHistory(Key key, int page, int log) throws IOException {
        String response = getResponse(key, this.apiKey, "/history?page=" + page + "&lg=" + log);

        return new ObjectMapper().readValue(response, new TypeReference<>(){});
    }

    /**
     * Get a target key's status.
     * @param key target key
     * @return Target key's status
     * @throws IOException error
     */
    public Status getStatus(Key key) throws IOException {
        String response = getResponse(key, this.apiKey, "");

        return new ObjectMapper().readValue(response, Status.class);
    }
}
