package com.ex.vigo;

import android.util.Log;

import org.json.JSONObject;

import java.util.concurrent.Callable;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginCall<JSONObject> implements Callable<JSONObject> {

    private String username;

    private String pswd;

    public LoginCall(String username, String pswd) {
        this.username = username;
        this.pswd = pswd;
    }

    @Override
    public JSONObject call() throws Exception {
        try {
            org.json.JSONObject requestObject = new org.json.JSONObject();
            requestObject.put("userId", this.username);
            requestObject.put("password", this.pswd);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, requestObject.toString());
            Request request = new Request.Builder()
                    .url("http://10.0.2.2:8080/vigoapp/authenticate")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            org.json.JSONObject jsonObject = new org.json.JSONObject(response.body().string());
            response.close();
            return (JSONObject) jsonObject;
        } catch (Exception ex) {
            Log.e("tag", "message", ex);
            return null;
        }
    }
}
