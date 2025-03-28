package main.java.BitManipulation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Json {
    public static void main(String[] args) {
        List<String> res = showsInProduction(2019, -1);
//        for (String s : res) {
//            System.out.println(s);
//        }

    }

    public static List<String> showsInProduction(int startYear, int endYear) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        String baseUrl = "https://jsonmock.hackerrank.com/api/tvseries";
        int currentPage = 1;
        int totalPages = 1;

        try {
            while (currentPage <= totalPages) {
                // Fetch data from the API
                String url = baseUrl + "?page=" + currentPage;
                String response = fetchApiData(url);
                sb.append(response).append("\n");
                // Parse the JSON response
                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = (JSONObject) parser.parse(response);

                // Get total pages
                totalPages = ((Long) jsonResponse.get("total_pages")).intValue();

                // Get the data array
                JSONArray data = (JSONArray) jsonResponse.get("data");

                for (Object obj : data) {
                    JSONObject tvShow = (JSONObject) obj;

                    String name = (String) tvShow.get("name");
                    String runtimeOfSeries = (String) tvShow.get("runtime_of_series");

                    // Extract start and end years
                    int showStartYear = extractStartYear(runtimeOfSeries);
                    int showEndYear = extractEndYear(runtimeOfSeries);

                    // Check if the show matches the criteria
                    if (showStartYear >= startYear && (endYear == -1 || showEndYear <= endYear)) {
                        result.add(name);
                    }
                }

                currentPage++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Sort the result alphabetically
        Collections.sort(result);
        System.out.println(sb);
        return result;
    }

    private static String fetchApiData(String urlString) throws IOException {
        StringBuilder response = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }

    private static int extractStartYear(String runtimeOfSeries) {
        runtimeOfSeries = runtimeOfSeries.replaceAll("[^0-9-]", ""); // Remove non-numeric characters
        String[] years = runtimeOfSeries.split("-");
        return Integer.parseInt(years[0]);
    }

    private static int extractEndYear(String runtimeOfSeries) {
        runtimeOfSeries = runtimeOfSeries.replaceAll("[^0-9-]", ""); // Remove non-numeric characters
        String[] years = runtimeOfSeries.split("-");
        if (years.length > 1 && !years[1].isEmpty()) {
            return Integer.parseInt(years[1]);
        }
        return Integer.MAX_VALUE; // If the show is still in production
    }
}


