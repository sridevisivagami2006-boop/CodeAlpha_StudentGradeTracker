import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== AI CHATBOT =====");
        System.out.println("Type 'bye' to exit.\n");

        while (true) {

            System.out.print("You: ");
            String input = sc.nextLine().toLowerCase();

            if (input.equals("hello") || input.equals("hi")) {
                System.out.println("Bot: Hello! How can I help you?");
            }

            else if (input.contains("name")) {
                System.out.println("Bot: I am an AI Chatbot created in Java.");
            }

            else if (input.contains("java")) {
                System.out.println("Bot: Java is a popular object-oriented programming language.");
            }

            else if (input.contains("internship")) {
                System.out.println("Bot: Internships help students gain practical experience.");
            }

            else if (input.contains("how are you")) {
                System.out.println("Bot: I am doing great. Thank you!");
            }

            else if (input.equals("bye")) {
                System.out.println("Bot: Goodbye! Have a nice day.");
                break;
            }

            else {
                System.out.println("Bot: Sorry, I don't understand that question.");
            }
        }

        sc.close();
    }
}