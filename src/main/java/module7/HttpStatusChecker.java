package module7;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    private static final String URL = "https://http.cat";

    public static void main(String[] args) {
        System.out.println(HttpStatusChecker.getStatusImage(415));
        HttpStatusChecker.getStatusImage(999);
    }

    public static String getStatusImage(int code) {
        String url = URL + "/" + code + ".jpg";
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            if (connection.getResponseCode() == 404) {
                throw new ImageNotFoundException("The status code is 404!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}