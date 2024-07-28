import java.util.Scanner;

public class Telephone {
    /**
     * contructor that sets the mail system field of the telephone with an object of the type
     */
    public Telephone(MailSystem mailSystem){
        this.voiceMailSystem = mailSystem;
    }
    
    /**
     * Method that gets the mailbox corresponding to the mail box id entered by the user
     * Also prints out the greeting of the mail box
     * @return the mailbox that the user was referring to
     */
    public Mailbox getMailbox(){
        Mailbox mailbox = this.voiceMailSystem.getMailbox(getMailboxNumber());
        System.out.println(mailbox.getGreeting());
        return mailbox;
    }
    /**
     * Method to get the user input for the mailbox number to be queried
     * @return the int value referring to the mail box that the user wants
     */
    public int getMailboxNumber(){
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
            this.voiceMailSystem.openConnection();
            return true;
        }
        catch(Exception exception){
            System.out.println("error opening connection with the mail system " + exception.getMessage());
            return false;
        }
    }
    private MailSystem voiceMailSystem;
}
