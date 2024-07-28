import java.util.ArrayList;
/**
 * Class representing the Voice Mail System
 */
public class MailSystem {
    /**
     * Constructor
     */
    public MailSystem(){

    }
    /**
     * method to tell the user that the voice mail system has accepted their connection request
     * @return the string asking user to enter the mail box number to be reached
     */
    public String openConnection(){
        return "You have reached the main line, please enter the mailbox number you want to reach : ";
    }
    /**
     * method to return the mailbox that is requested by the caller based on the ID supplied to it
     * @param ID the mailbox id that is supplied
     * @return the mailbox matching to the ID
     */
    public Mailbox getMailbox(int ID){
        for(int i=0;i<mailBoxes.size();i++){
            if(mailBoxes.get(i).inboxID == ID){
                System.out.println(mailBoxes.get(i).getGreeting());
                return mailBoxes.get(i);
            }
        }
        return null;
    }
    ArrayList<Mailbox> mailBoxes = new ArrayList<Mailbox>();
    
}
