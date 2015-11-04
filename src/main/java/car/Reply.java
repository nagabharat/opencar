package car;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by hadoop on 28/10/15.
 */
@XmlRootElement
public class Reply {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
