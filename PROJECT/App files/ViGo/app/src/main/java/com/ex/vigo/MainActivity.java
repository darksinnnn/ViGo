package com.ex.vigo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText passtext;
    //private CheckBox rememberMeCheckBox;
    private MaterialButton LoginButton; // Use MaterialButton instead of Button
    private TextView ForgotPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.navigation_home:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
//                }
//                return false;
//            }
//        });

        username = findViewById(R.id.username);
        passtext = findViewById(R.id.passtext);
        //rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);
        LoginButton = findViewById(R.id.LoginButton); // Use MaterialButton
        ForgotPass = findViewById(R.id.ForgotPass);
        String userid= String.valueOf(username.getText());
        String pswd= String.valueOf(passtext.getText());
        LoginButton.setOnClickListener(new LoginButtonListner(this,userid,pswd, this));

    }
}