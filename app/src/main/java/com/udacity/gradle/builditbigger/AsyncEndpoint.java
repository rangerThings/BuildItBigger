package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.rangerthings.jokelibrary.MainJokeActivity;
import com.udacity.gradle.builditbigger.backend.myJokeApi.MyJokeApi;

import java.io.IOException;

public class AsyncEndpoint extends AsyncTask<Context, Void, String> {

    private static MyJokeApi myJokeApi = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {
        if (myJokeApi == null) {  // Only do this once
            MyJokeApi.Builder builder = new
                    MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // ­ 10.0.2.2 is localhost's IP address in Android emulator
                    // ­ turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?>
                                                       abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myJokeApi = builder.build();
        }
        context = params[0];


        try {
            return myJokeApi.telljoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        Intent myIntent = new Intent(context, MainJokeActivity.class);
        myIntent.putExtra("jokes", result);
        context.startActivity(myIntent);

        Toast.makeText(context, "Async: " + result, Toast.LENGTH_LONG).show();
    }
}

