/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gurulotaxi.taxiadmin.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.gurulotaxi.taxiadmin.model.Freetaxi;
import com.gurulotaxi.taxiadmin.model.JsonResponse;
import com.gurulotaxi.taxiadmin.util.ServerUtil;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ezzored
 */
public class MockService {

    public String getMockFreeTaxis() throws Exception {
                Gson myGson = new Gson();

        String fetchUrl =
                ServerUtil.SERVER_BASE_URL + "mock/getFreeTaxis";
        URLConnection urlConnection = new URL(fetchUrl).openConnection();
        urlConnection.connect();

        JsonReader reader = new JsonReader(
                new InputStreamReader(urlConnection.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonElement rootElement = parser.parse(reader);

        JsonResponse myTweet = myGson.fromJson(rootElement, JsonResponse.class);
        
        return myTweet.getStatus();
    }
}
