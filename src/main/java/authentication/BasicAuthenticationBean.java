package authentication;

public class BasicAuthenticationBean {

    private String message;

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BasicAuthenticationBean(String message) {
        this.message = message;
    }


}
