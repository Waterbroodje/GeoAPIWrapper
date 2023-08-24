import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoAPIWrapper {

    private static final String API_URL = "https://apis.thatapicompany.com/geo-ip-api-community/locations/iplookup?ip=";
    private final String apiKey;

    public GeoAPIWrapper(String apiKey) {
        this.apiKey = apiKey;
    }

    public GeoLocationInfo lookupIP(String ip) throws IOException {
        String url = API_URL + ip;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestProperty("X-BLOBR-KEY", apiKey);

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
                return new GeoLocationInfo(jsonObject);
            }
        } else {
            throw new IOException("Error fetching data from API. Response Code: " + connection.getResponseCode());
        }
    }
}
