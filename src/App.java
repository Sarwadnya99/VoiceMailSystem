import java.util.ArrayList;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World! Welcome to our in house voice mail system!!");
        MailSystem mailSystem = getSystem();
        Telephone telephone = new Telephone(mailSystem);
        telephone.callTheMainLine();
        int boxID = telephone.getMailboxNumberFromUser();
        while(boxID != -1){
            telephone.getMailbox(boxID);
            Message message = telephone.getMessageFromUser();
            telephone.sendMessageToMailBox(message);
            boxID = telephone.getMailboxNumberFromUser();
        }
    }
    private static MailSystem getSystem(){
        ArrayList<Mailbox> mailboxes = new ArrayList<>();
        mailboxes.add(new Mailbox(1, "Hey you have reached box 1. Enter your message or enter passcode to login", "one", new LinkedList<Message>(), new LinkedList<>()));
        mailboxes.add(new Mailbox(2, "Hey you have reached box 2. Enter your message or enter passcode to login", "two", new LinkedList<Message>(), new LinkedList<>()));
        mailboxes.add(new Mailbox(3, "Hey you have reached box 3. Enter your message or enter passcode to login", "three", new LinkedList<Message>(), new LinkedList<>()));
        mailboxes.add(new Mailbox(4, "Hey you have reached box 4. Enter your message or enter passcode to login", "four", new LinkedList<Message>(), new LinkedList<>()));
        return new MailSystem(mailboxes);
    }
}
