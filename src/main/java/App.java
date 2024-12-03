import java.util.ArrayList;
import java.util.List;

public class App implements Mediator {
    private List<User> users;

    public App() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public User findUser(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public void deliverMessage(String senderId, String recipientId, String content) {
        User sender = findUser(senderId);
        User recipient = findUser(recipientId);

        Message message = new Message(content, sender, recipient);
        recipient.receiveMessage(message);
        message.markDelivered();
    }
}
