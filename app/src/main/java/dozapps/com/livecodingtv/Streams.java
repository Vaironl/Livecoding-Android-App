package dozapps.com.livecodingtv;

/**
 * Created by vaironl on 4/21/16.
 */
public class Streams {

    private String title, username, programmingLanguage;
    private int viewCount;

    public Streams() {
        title = "NULLOBJECT";
        username = "NULLOBJECT";
        programmingLanguage = "NULLOBJECT";
        viewCount = 0;
    }

    public Streams(String title, String username) {

        this.title = title;
        this.username = username;

        programmingLanguage = "NULLOBJECT";
        viewCount = 0;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
