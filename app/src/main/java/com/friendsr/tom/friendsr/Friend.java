package com.friendsr.tom.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;
    private float rating;

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    public String getFriendName() {
        return this.name;
    }

    public String getBio() {
        return this.bio;
    }

    public int getDrawableId() {
        return this.drawableId;
    }

    public Float getRate() {
        return this.rating;
    }

    public void setRate(float rate) {
        this.rating = rate;
    }
}
