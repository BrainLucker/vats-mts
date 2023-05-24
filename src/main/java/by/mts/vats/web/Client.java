package by.mts.vats.web;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;

import by.mts.vats.data.Record;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.util.UriComponentsBuilder;

public class Client {

    private final String baseURL;
    private final String companyID;
    private final String apiKey;
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public Client(String baseURL, String companyID, String apiKey) {
        this.baseURL = baseURL;
        this.companyID = companyID;
        this.apiKey = apiKey;
    }

    public void getRecords(String path, long start, long end) {

        URI uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(baseURL)
                .path(path)
                .queryParam("company_id", companyID)
                .queryParam("api_key", apiKey)
                .queryParam("start", start)
                .queryParam("end", end)
                .build()
                .toUri();

        System.out.println(uri);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();

        sendRequest(request);
    }

    public void sendRequest(HttpRequest request) {
        String body = "";
        try {
            HttpResponse<String> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());
//            System.out.println("Status code: " + response.statusCode());
//            System.out.println("Body: " + response.body());
            body = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


//        ObjectMapper mapper = new ObjectMapper();
//        Record record = mapper.readValues(body, ArrayList<Record>.class);

    }

}