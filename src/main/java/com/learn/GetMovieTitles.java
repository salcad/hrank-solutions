package com.learn;


import java.io.*;
import java.util.*;

import java.net.*;
import com.google.gson.*;


public class GetMovieTitles {

    static String[] getMovieTitles(String substr) {
        String response;
        int startPage = 1;
        int totalPages = Integer.MAX_VALUE;
        List<String> titles = new ArrayList<>();
        while (startPage <= totalPages) {
            try {
                URL obj = new URL(
                        "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + startPage);
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((response = reader.readLine()) != null) {
                    JsonObject json = new Gson().fromJson(response, JsonObject.class);
                    totalPages = json.get("total_pages").getAsInt();
                    JsonArray data = json.getAsJsonArray("data");
                    for (int i = 0; i < data.size(); i++) {
                        String title = data.get(i).getAsJsonObject().get("Title").getAsString();
                        titles.add(title);
                    }
                }
                reader.close();
                startPage++;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }

        }
        Collections.sort(titles);
        return titles.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }

        res = getMovieTitles(_substr);
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(res[res_i]);
        }

    }

}
