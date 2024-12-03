import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Message {
    private static final Map<User, Integer> userCounters = new HashMap<>();
    private String message_id;
    private LocalDateTime timestamp;
    private String content;
    private User from;
    private User to;
    private boolean delivered;
    private boolean read;

    private static String generateId(User user) {
        userCounters.putIfAbsent(user, 0);
        int userIdCounter = userCounters.get(user);
        userCounters.put(user, userIdCounter + 1);
        return user.getUsername() + "-" + userIdCounter;
    }

    public Message(String content, User from, User to) {
        this.message_id = generateId(to);
        this.timestamp = LocalDateTime.now();
        this.content = content;
        this.from = from;
        this.to = to;
        this.delivered = false;
        this.read = false;
    }

    public void log() {
        System.out.println("Message ID: " + message_id);
        System.out.println("From: " + from.getUsername());
        System.out.println("To: " + to.getUsername());
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Content: " + content);
        System.out.println("Delivered: " + delivered);
        System.out.println("Read: " + read);

    }

    public void markDelivered() {
        this.delivered = true;
    }

    public void markRead() {
        this.read = true;
    }
}
