package com.naoido.sesame4j.util;

import com.naoido.sesame4j.model.Command;
import com.naoido.sesame4j.model.Key;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.KeyParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HexFormat;
import java.util.concurrent.TimeUnit;

public class ApiRequest {
    //https://app.candyhouse.co/api/sesame2/{ UUID }
    private static final String BASE_URL = "https://app.candyhouse.co/api/sesame2/";

    protected static void sendRequest(Key key, String history, Command cmd, String apiKey) {
        history = Base64.getEncoder().encodeToString(history.getBytes());

        String body = "{\"cmd\":"+ cmd +",\"history\":\""+ history +"\",\"sign\":\""+ getSign(key) +"\"}";

        System.out.println(body);
        try {
            URL url = new URL(BASE_URL + key.getUuid() + "/cmd");
            HttpURLConnection connection = getConnection(url, "POST", apiKey);

            OutputStreamWriter output = new OutputStreamWriter(connection.getOutputStream());
            output.write(body);
            output.flush();
            connection.connect();

            connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected static String getResponse(Key key, String apiKey, String endPoint) throws IOException {
        HttpURLConnection connection = getConnection(new URL(BASE_URL + key.getUuid() + endPoint), "GET", apiKey);
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();

        String line;
        while((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();

        return sb.toString();
    }

    private static HttpURLConnection getConnection(URL url, String method, String apiKey) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setRequestProperty("x-api-key", apiKey);
        connection.setDoOutput(true);

        return connection;
    }

    private static String getSign(Key key) {
        HexFormat hex = HexFormat.of();
        ByteBuffer byteBuffer = ByteBuffer.allocate(4)
                .order(ByteOrder.LITTLE_ENDIAN)
                .putInt((int) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));

        String message = hex.formatHex(byteBuffer.array()).substring(2, 8);

        CMac mac = new CMac(new AESEngine());
        mac.init(new KeyParameter(hex.parseHex(key.getSecretKey())));

        byte[] bytes = hex.parseHex(message);
        mac.update(bytes, 0, bytes.length);

        byte[] out = new byte[mac.getMacSize()];
        mac.doFinal(out, 0);

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b: out) {
            stringBuilder.append(String.format("%02X", b));
        }

        return stringBuilder.toString();
    }
}
