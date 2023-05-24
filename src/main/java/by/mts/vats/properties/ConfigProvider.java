package by.mts.vats.properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }

    String BASE_URL = readConfig().getString("baseURL");
    String PATH = readConfig().getString("prefix");
    String COMPANY_ID = readConfig().getString("clientsParams.test.companyID");
    String API_KEY = readConfig().getString("clientsParams.test.apiKey");
}