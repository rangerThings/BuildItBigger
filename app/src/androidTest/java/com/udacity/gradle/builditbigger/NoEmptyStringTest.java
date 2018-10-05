package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.AsyncEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class NoEmptyStringTest{
    @Test
    public void AsyncTaskTest (){
        String randomJoke = "";
        Context context = InstrumentationRegistry.getTargetContext();
        AsyncTask<Context, Void, String> async = new AsyncEndpoint().execute(context);

        try {

            randomJoke = async.get();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (ExecutionException e){
            e.printStackTrace();
        }

        //joke is not empty or null
        assertNotNull(randomJoke);
        assertThat(randomJoke, not(isEmptyString()));

    }

}
