import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        App app = new App();

        User charlie = new User("123", "Charlie", new ArrayList<>(), app);
        User violet = new User("456", "Violet", new ArrayList<>(), app);
        User mike = new User("789", "Mike", new ArrayList<>(), app);

        charlie.login(app);
        violet.login(app);
        mike.login(app);

        charlie.sendMessage("456", "Hello Violet");
        violet.readMessage(0);
        System.out.println();

        violet.sendMessage("123", "Hey Charlie");
        charlie.readMessage(0);
        System.out.println();

        violet.sendMessage("789", "Hello Mike");
        mike.readMessage(0);
        System.out.println();

        violet.sendMessage("789", "Hey Mike");
        mike.readMessage(1);
        System.out.println();

        mike.readMessage(2);
        System.out.println();
    }
}
