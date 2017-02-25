package barron.pw.myapplication;

/**
 * Created by hp on 2/24/2017.
 */


/**
 * Created by hp on 2/20/2017.
 */


public class ChatNew {

    private String message;
    private String author;
    private String author_id;
    private String timeMillis;

    // Required default constructor for Firebase object mapping
    @SuppressWarnings("unused")
    private ChatNew() {
    }

    public ChatNew(String message) {
        this.message = message;
        this.author = author;
        this.timeMillis = timeMillis;
        this.author_id = author_id;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor_id(){return author_id;}

    public String getTimeMillis(){return timeMillis;}
}
