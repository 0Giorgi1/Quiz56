package quiz5;

import java.time.Instant;

public class UserInteractionManager {
    private CommunicationManager communicationManager;

    public UserInteractionManager() {
        this.communicationManager = new DummyCommunicationManager();
    }

    public void sendMessage(String userId, String message) {
        String timestamp = Instant.now().toString();
        communicationManager.sendRequest(userId, message, timestamp);
        communicationManager.handleResponse("Good day"); // Dummy response
    }
}