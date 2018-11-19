package ldj.spring.boot.exceptionhandler;

public class AppError {

    private  String Message;

    private  String Reason;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}
