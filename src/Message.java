public class Message {
    /**
     * contructor
     */
    public Message(String message){
        this.value = message;
    }
    /**
     * method to get the message string
     */
    public String getText(){
        return this.value;
    }
    private String value;
}
