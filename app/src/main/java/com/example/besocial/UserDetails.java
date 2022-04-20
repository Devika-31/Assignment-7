package com.example.besocial;

import java.io.Serializable;


//Model class

public class UserDetails implements Serializable {
    public static final String KEY_USER_DETAILS="userdetails";
    private String Bio;
    private String Description;
    private int pickedImageid;
    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public int getAvtarId() {
        return pickedImageid;
    }

    public void setAvtarId(int avtarid) {
        pickedImageid = avtarid;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public UserDetails(String bio, String description, int pickedImageid) {
        Bio = bio;
        Description = description;
        this.pickedImageid = pickedImageid;
    }


}
