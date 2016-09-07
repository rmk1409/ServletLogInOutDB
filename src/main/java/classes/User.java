package classes;

/**
 * Created by Roma on 07.09.2016.
 */
public class User {
    private int id;
    private String name, password, citizenship, interests, moreInterests;

    public User(String name, String password, String citizenship, String interests, String moreInterests) {
        this.name = name;
        this.password = password;
        this.citizenship = citizenship;
        this.interests = interests;
        this.moreInterests = moreInterests;
    }

    public User(int id, String name, String password, String citizenship, String interests, String moreInterests) {
        this(name, password, citizenship, interests, moreInterests);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
