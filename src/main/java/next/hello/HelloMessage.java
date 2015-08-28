package next.hello;

import java.io.Serializable;

public class HelloMessage implements Serializable {
    private final String message;

    public HelloMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
