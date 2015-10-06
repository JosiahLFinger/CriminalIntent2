package com.example.josiahwilliams.criminalintent2;

import java.util.UUID;

/**
 * Created by Josiah Williams on 10/5/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        //Generate unique identifier
        mId = UUID.randomUUID();

    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
}
