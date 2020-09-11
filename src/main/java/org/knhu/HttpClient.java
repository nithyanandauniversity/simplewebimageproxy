package org.knhu;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class HttpClient {

    private static OkHttpClient client = new OkHttpClient();

    public static byte[] get(String url) throws IOException {
        var request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).bytes();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            throw e;
        }
    }
}
