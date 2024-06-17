package quiz5;

public class DummyCommunicationManager extends CommunicationManager {
    @Override
    public void sendRequest(String userId, String message, String timestamp) {
        // Here you can define what should happen when a request is sent.
        // For a dummy implementation, you might do nothing or print a message.
        System.out.println("Dummy request sent");
    }

    @Override
    public void handleResponse(String response) {
        // Here you can define how to handle a response.
        // For a dummy implementation, you might do nothing or print the response.
        System.out.println("Dummy response handled: " + response);
    }
}