package com.ex.vigo;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginButtonListner implements View.OnClickListener {
    Context Loginpagecontext;
    private String username;
    private String pswd;

    private AppCompatActivity loginActivity;

    public String getUsername() {
        return username;
    }

    public String getPswd() {
        return pswd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public LoginButtonListner(Context loginpagecontext, String username, String pswd, AppCompatActivity callingActivity) {
        this.Loginpagecontext = loginpagecontext;
        this.username = username;
        this.pswd = pswd;
        this.loginActivity = callingActivity;
    }

    @Override
    public void onClick(View v) {
        EditText username = this.loginActivity.findViewById(R.id.username);
        EditText passtext = this.loginActivity.findViewById(R.id.passtext);
        this.pswd = String.valueOf(passtext.getText());
        this.username = String.valueOf(username.getText());
        switchToSecondActivity(v);
    }


    private JSONObject authenticate() {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<JSONObject> response = executorService.submit(new LoginCall<>(this.username, this.pswd));
            return response.get();
        } catch (Exception ex) {
            Log.e("tag", "message", ex);
            return null;
        }
    }

    private void switchToSecondActivity(View view) {
        try {


            JSONObject response = authenticate();
            if (response.has("response") && response.getString("response").equalsIgnoreCase("OK")) {
                Intent intent;
                intent = new Intent(this.Loginpagecontext, DashboardActivity.class);
                //intent.putExtra("authToken", response.getString("authToken"));
                this.Loginpagecontext.startActivity(intent);
            } else {
                showErrorPopup(response.getString("response"));
            }
        } catch (Exception ex) {
            Log.e("tag", "message", ex);
        } finally {

        }
    }

    private void showErrorPopup(String messageToDisplay){
        AlertDialog.Builder alert =new AlertDialog.Builder(this.Loginpagecontext);
        alert.setTitle("Login Failed");
        alert.setMessage(messageToDisplay);
        alert.setPositiveButton("OK",null);
        alert.show();
    }
}
