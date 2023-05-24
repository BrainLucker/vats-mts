package by.mts.vats.setup;

import by.mts.vats.web.Client;

import static by.mts.vats.properties.ConfigProvider.*;

public class Main {
    public static void main(String[] args) {
        int start = 1683958023;
        int end = 1684577223;

        Client client = new Client(BASE_URL, COMPANY_ID, API_KEY);
        client.getRecords(PATH, start, end);
    }
}