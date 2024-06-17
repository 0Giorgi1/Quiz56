package quiz6;

import okhttp3.*;
import quiz5.CommunicationManager;

import java.io.IOException;

public class SpecialCommunicationManager extends CommunicationManager {
    private final String commonServiceUrl;
    private final String specialServiceUrl;
    private final OkHttpClient httpClient = new OkHttpClient();

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
    }

    @Override
    public void sendRequest(String userId, String message, String timestamp) {
        RequestBody body = new FormBody.Builder()
                .add("userId", userId)
                .add("message", message)
                .add("timestamp", timestamp)
                .build();

        Request request = new Request.Builder()
                .url(commonServiceUrl) // or specialServiceUrl depending on the service you want to use
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            if (response.body() != null) {
                handleResponse(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void handleResponse(String response) {
        System.out.println("Response from server: " + response);
    }
}