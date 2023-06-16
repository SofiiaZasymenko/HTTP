package module7;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public static void main(String[] args) {
        HttpImageStatusCli.askStatus();
    }

    public static void askStatus() {
        Integer code = null;
        while (code == null) {
            System.out.println("Enter HTTP status code: ");
            Scanner scanner = new Scanner(System.in);
            try {
                code = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid number");
            }
        }
        try {
            HttpStatusImageDownloader.downloadStatusImage(code);
        } catch (ImageNotFoundException e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}