package hello;


public class Response {

    private final long id;
    private final String code;

    public Response(long id, String code) {
        this.id = id;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }
}
