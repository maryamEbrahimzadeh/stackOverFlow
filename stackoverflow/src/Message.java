import java.io.*;

public class Message implements Serializable {

    static final int SEARCH = 0, LOGIN = 1, LOGOUT = 2, REGISTER = 3;
    private int type;
    private String message;

    // constructor
    Message(int type, String message) {
        this.type = type;
        this.message = message;
    }

    // getters
    int getType() {
        return type;
    }
    String getMessage() {
        return message;
    }
}

