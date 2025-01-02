import java.time.format.DateTimeFormatter;

public class Adapter implements MessageInterface {
    private ExternalMessage externalMessage;

    public Adapter(ExternalMessage externalMessage) {
        this.externalMessage = externalMessage;
    }

    @Override
    public void log() {
        System.out.println("Content: " + externalMessage.getBody());
        System.out.println("Read: " + externalMessage.isRead());
    }

    @Override
    public void markDelivered() {
    System.out.println("Can't mark as delivered");
    }

    @Override
    public void markRead() {
        if (!externalMessage.isRead()) {
            externalMessage.toggleRead();
        }
    }

}
