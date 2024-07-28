import java.util.Scanner;

public class Telephone {
    /**
     * contructor that sets the mail system field of the telephone with an object of the type
     */
    public Telephone(MailSystem mailSystem){
        this.voiceMailSystem = mailSystem;
    }
    /**
     * Method that sends a particular message to a particular mailbox
     * @param message the text that is to be sent to the mailbox
     * @return true if sending is a success else false
     */
    public boolean sendMessageToMailBox(Message message){
        try{
            this.mailbox.receiveMessage(message);
            return true;
        } catch(Exception exception){
            System.out.println("Error while sending message to the said mailbox");
            return false;
        }
    }
    /**
     * Method that gets the user input for the message to be sent ot the mailbox
     * The message can be multiline too. It will end when user types in END.
     * @return the string containing the text entered by the user
     */
    public Message getMessageFromUser(){
        StringBuilder messageText = new StringBuilder();
        try {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            while(!str.equals("END")){
                messageText.append(str);
                str = sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Error while reading message data from user");
            return null;
        }
        return new Message(messageText.toString());
    }
    /**
     * Method that gets the mailbox corresponding to the mail box id entered by the user
     * Also prints out the greeting of the mail box
     * @return the mailbox that the user was referring to
     */
    public Mailbox getMailbox(int ID){
        this.mailbox = this.voiceMailSystem.getMailbox(ID);
        return this.mailbox;
    }
    /**
     * Method to get the user input for the mailbox number to be queried
     * @return the int value referring to the mail box that the user wants
     */
    public int getMailboxNumberFromUser(){
        Scanner sc = new Scanner(System.in);
        int boxNumber = sc.nextInt();
        return boxNumber;
    }
    /**
     * method that opens a connection with the main line
     * @return true if the connection opening was a success and vice versa
     */
    public boolean callTheMainLine(){
        try{
            System.out.println(this.voiceMailSystem.openConnection());
            return true;
        }
        catch(Exception exception){
            System.out.println("error opening connection with the mail system " + exception.getMessage());
            return false;
        }
    }
    private Mailbox mailbox;
    private MailSystem voiceMailSystem;
}
