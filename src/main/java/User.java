import java.util.List;

public class User {
    private String id;
    private String username;
    private List<MessageInterface> inbox;
    private App app;

    public User(String id, String username, List<MessageInterface> inbox, App app) {
        this.id = id;
        this.username = username;
        this.inbox = inbox;
        this.app = app;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void login(App app) {
        this.app = app;
        app.addUser(this);
    }

    public void sendMessage(String recipientId, String content) {
        app.deliverMessage(this.id, recipientId, content);
    }

    public void receiveMessage(MessageInterface message) {
        inbox.add(message);
    }


    public void readMessage(int idx) {
        try {
            MessageInterface message = inbox.get(idx);
            message.markRead();
            message.log();
        } catch (Exception e) {
            System.out.printf("Couldn't read message. Error: %s", e.getMessage());
            System.out.println();
        }
    }

}