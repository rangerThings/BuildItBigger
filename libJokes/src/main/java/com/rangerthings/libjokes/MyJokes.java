package com.rangerthings.libjokes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyJokes{

    //jokes from http://pun.me/pages/dad-jokes.php

    static List<String> jokeList = Arrays.asList("Did you hear about the restaurant on the moon? Great food, no atmosphere.",
            "What do you call a fake noodle? An Impasta.",
            "How many apples grow on a tree? All of them.",
            "Want to hear a joke about paper? Nevermind it's tearable.",
            "I just watched a program about beavers. It was the best dam program I've ever seen.",
            "Why did the coffee file a police report? It got mugged.",
            "How does a penguin build it's house? Igloos it together.",
            "Dad, did you get a haircut? No I got them all cut.",
            "Dad, can you put my shoes on? No, I don't think they'll fit me.",
            "Why did the scarecrow win an award? Because he was outstanding in his field.",
            "Why don't skeletons ever go trick or treating? Because they have no body to go with.",
            "Ill call you later. Don't call me later, call me Dad.",
            "What do you call an elephant that doesn't matter? An irrelephant",
            "Want to hear a joke about construction? I'm still working on it.",
            "What do you call cheese that isn't yours? Nacho Cheese.",
            "Why couldn't the bicycle stand up by itself? It was two tired.",
            "What did the grape do when he got stepped on? He let out a little wine.",
            "I wouldn't buy anything with velcro. It's a total rip-off.");

    public static List<String> getJokeList(){
        return jokeList;
    }

    public static String getRandomJoke() {
        Random random = new Random();
        int randJokeIndex = random.nextInt(jokeList.size());
        return jokeList.get(randJokeIndex);
    }



}
