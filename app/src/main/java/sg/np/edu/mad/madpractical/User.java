package sg.np.edu.mad.madpractical;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    // Getter
    public String getName() {
        return name;
    }
    // Setter
    public void setName(String newName) {
        this.name = newName;
    }
    private String descirption; // private = restricted access
    // Getter
    public String getDescription() {
        return descirption;
    }
    // Setter
    public void setDescirption(String newDescription) {
        this.descirption = newDescription;
    }
    private int id; // private = restricted access
    // Getter
    public int getId() {
        return id;
    }
    // Setter
    public void setId(int newId) {
        this.id = newId;
    }
    private boolean followed; // private = restricted access
    // Getter
    public boolean getFollowed() {
        return followed;
    }
    // Setter
    public void setFollowed(boolean newFollowed) {
        this.followed = newFollowed;
    }
// Constructor
    User(){ }
    User(String n, String d,  boolean f){
        setName(n);
        setDescirption(d);

        setFollowed(f);
    }

}
