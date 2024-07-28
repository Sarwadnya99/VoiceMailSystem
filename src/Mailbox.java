import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This class represents the mail box one of each is assigned to one user of the mail system
 */
public class Mailbox {
    /**
     * contructor with zero arguments
     */
    public Mailbox(int ID, String greeting, String passcode, Queue<Message> newTexts, Queue<Message> savedTexts){
        this.inboxID = ID;
        this.greeting = greeting;
        this.passcode  = passcode;
        this.newMessages = newTexts;
        this.savedMessages = savedTexts;
    }

    /**
     * returns if the login was successful or not
     * @param passCode the password sent in by the user
     * @return true if the login was sucessful and vice versa
     */
    public boolean matches(String passCode){
        return passCode.equals(this.passcode);
    }
    /**
     * Method to save the latest message received in the mailbox
     * @return true if the operation was successful and vice versa
     */
    public boolean saveMessage(){
        try{
        Message message = this.newMessages.poll();
        this.savedMessages.add(message);
        return true;
        }
        catch(Exception exception){
            System.out.println("There was some error while storing the message : " + exception.getMessage());
            return false;
        }
    }
    /**
     * receives the message and adds it to the new messages queue of the current mailbox
     * @param message the message that needs to be sent to the mailbox
     * @return true if the operation was successful and vice versa
     */
    public boolean receiveMessage(Message message){
        try{
            this.newMessages.add(message);
            return true;
        }
        catch(Exception exception){
            System.out.println("Adding message to the mailbox threw and exception with the message : " + exception.getMessage());
            return false;
        }
    }
    /**
     * deletes the latest message of the mailbox
     * @return true if the message is correctly removed and vice versa
     */
    public boolean deleteMessage(){
        try{
            this.newMessages.remove();
            return true;
        }
        catch(NoSuchElementException exception){
            System.out.println("removing message threw an exception with the message : " + exception.getMessage());
            return false;
        }
    }
    /**
     * gets the current latest message of the mailbox
     * @return the latest message received by the mailbox
     */
    public Message retrievMessage(){
        Message currentMessage = newMessages.peek();
        return currentMessage;
    }
    /**
     * sets the value of the passcode to the new value sent
     * @param newPasscode the value to be set to the passcode of the mailbox
     * @return true if the passcode is successfully set and vice versa
     */
    public boolean setPasscode(String newPasscode){
        try{
            this.passcode = newPasscode;
            return true;
        }
        catch(Exception exception){
            return false;
        }
    }
    /**
     * Method to get the greeting from the mailbox
     * @return the current value of the greeting of the mail box
     */
    public String getGreeting(){
        return this.greeting;
    }
    /**
     * Method to set the new greeting to the mail box
     * @param newGreeting the new greeting string to be set
     * @return true if the greeting is set successfully else false
     */
    public boolean changeGreeting(String newGreeting){
        try{
            this.greeting = newGreeting;
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
    public int inboxID;
    private String greeting;
    private String passcode;
    private Queue<Message> newMessages;
    private Queue<Message> savedMessages;
}
