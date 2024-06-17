package org.example;

import quiz5.UserInteractionManager;
import quiz6.SpecialCommunicationManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInteractionManager userInteractionManager = new UserInteractionManager();
        SpecialCommunicationManager specialCommunicationManager = new SpecialCommunicationManager("http://commonservice.com", "http://specialservice.com");

        Scanner scanner = new Scanner(System.in);
        String message;

        System.out.println("Enter your messages. Type 'exit' to stop the conversation.");

        while (true) {
            System.out.print("Your message: ");
            message = scanner.nextLine();

            if ("exit".equalsIgnoreCase(message)) {
                break;
            }

            if (message.contains("help")) {
                specialCommunicationManager.sendRequest("user1", message, java.time.Instant.now().toString());
            } else {
                userInteractionManager.sendMessage("user1", message);
            }
        }

        scanner.close();
    }
}