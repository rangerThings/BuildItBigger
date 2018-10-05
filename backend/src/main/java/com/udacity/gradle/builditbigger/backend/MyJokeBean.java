package com.udacity.gradle.builditbigger.backend;

/** The object model for the data we are sending through endpoints */
public class MyJokeBean {

    private String myJoke;


    public String getData() {
        return myJoke;
    }

    public void setData(String data) {
        myJoke = data;
    }

}