package module7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public static void main(String[] args) {
        HttpStatusImageDownloader.downloadStatusImage(497);
        HttpStatusImageDownloader.downloadStatusImage(999);
    }

    public static void downloadStatusImage(int code) throws ImageNotFoundException {
        String url = HttpStatusChecker.getStatusImage(code);
        try (InputStream inputStream = new URL(url).openStream()) {
            String path = String.format("cats/%s.jpg", code);
            if (!new File(path).exists()) {
                Files.copy(inputStream, Paths.get(path));
                System.out.printf("File successfully downloaded: %s", path);
            } else {
                System.out.printf("File with code %s already exist!", code);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}