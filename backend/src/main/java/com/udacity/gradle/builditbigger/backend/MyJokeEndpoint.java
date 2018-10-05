package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.rangerthings.libjokes.MyJokes;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myJokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyJokeEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
   /* @ApiMethod(name = "sayHi")
    public MyJokeBean sayHi(@Named("name") String name) {
        MyJokeBean response = new MyJokeBean();
        response.setData("Hi, " + name);

        return response;
    }*/
    @ApiMethod(name = "telljoke")
    public MyJokeBean tellJoke() {
        MyJokeBean response = new MyJokeBean();
        MyJokes myJokes;
        response.setData(MyJokes.getRandomJoke());

        return response;
    }



}
