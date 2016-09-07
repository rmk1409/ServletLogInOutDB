package classes;

/**
 * Created by Roma on 07.09.2016.
 */
public class User {
    private int id;
    private String login, password, citizenship, interests, moreInterests;

    public User(String login, String password, String citizenship, String interests, String moreInterests) {
        this.login = login;
        this.password = password;
        this.citizenship = citizenship;
        this.interests = interests;
        this.moreInterests = moreInterests;
    }

    public User(int id, String login, String password, String citizenship, String interests, String moreInterests) {
        this(login, password, citizenship, interests, moreInterests);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getMoreInterests() {
        return moreInterests;
    }

    public void setMoreInterests(String moreInterests) {
        this.moreInterests = moreInterests;
    }
}
