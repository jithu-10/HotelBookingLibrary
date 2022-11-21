package hotelbooking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private final String userName;
    private final long phoneNumber;
    private final int userID;
    private final String mailID;


    public User(String userName,long phoneNumber,String mailID){
        Helper.validateString(userName,"User name can't be null or empty");
        Helper.validatePhoneNumber(phoneNumber);
        validateMailID(mailID);
        this.userID=UserDB.getInstance().generateId();
        this.userName=userName;
        this.phoneNumber=phoneNumber;
        this.mailID=mailID;
    }

    public String getUserName() {
        return userName;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public int getUserID() {
        return userID;
    }
    public String getMailID(){
        return  mailID;
    }



    private static void validateMailID(String mailID){
        Pattern pattern=Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        Matcher matcher=pattern.matcher(mailID);
        if(!matcher.matches()){
            throw  new RuntimeException("E-Mail is Not Valid");
        }
    }


}
