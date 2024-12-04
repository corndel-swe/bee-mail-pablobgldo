import java.util.List;

public class User {
    private String id;
    private String username;
    private List<Message> inbox;
    private App app;

    public User(String id, String username, List<Message> inbox, App app) {
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

    public void receiveMessage(Message message) {
        inbox.add(message);
    }

    public void readMessage(int idx) {
        try {
            Message message = inbox.get(idx);
            message.markRead();
            message.log();
        } catch (Exception e) {
      System.out.printf("Couldn't read message. Error: %s", e.getMessage());
        }
    }
}