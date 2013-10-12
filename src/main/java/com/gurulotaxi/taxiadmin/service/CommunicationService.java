/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.gurulotaxi.taxiadmin.model.JsonResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Ezzored
 */
public class CommunicationService {

    public static JsonResponse getResponse(String url) throws IOException {
        Gson myGson = new Gson();

        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.connect();

        JsonReader reader = new JsonReader(
                new InputStreamReader(urlConnection.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);

        return myGson.fromJson(rootElement, JsonResponse.class);
    }

    public static JsonResponse postObject(String serviceUrl, Object object) throws IOException {
        URL url = new URL(serviceUrl);
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Cache-Control", "no-cache");
        Gson gson;
        try (OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream())) {
            gson = new Gson();
            System.out.println(gson.toJson(object));
            if (object != null)
                out.write(gson.toJson(object));
            else
                out.write("");
        }

        JsonReader reader = new JsonReader(
                new InputStreamReader(connection.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);

        return gson.fromJson(rootElement, JsonResponse.class);
    }
}
