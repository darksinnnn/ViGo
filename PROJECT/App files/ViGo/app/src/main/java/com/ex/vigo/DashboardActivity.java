package com.ex.vigo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ex.vigo.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDashboardBinding binding;



    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(binding.toolbar);
//
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
//        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        switchToYourFragment(new HomeFragment());
        binding.bottomNavigation.setOnItemSelectedListener(item -> {
//            switch (item) {
//
//            }
            if(item.getItemId() == R.id.navigation_home){
                switchToYourFragment(new HomeFragment());
                Log.d("Home", "In Home");
                return true;
            } else if (item.getItemId() == R.id.navigation_profile){
                switchToYourFragment(new ProfileFragment());
                Log.d("Profile", "In Profile");
                return true;
            } else if (item.getItemId() == R.id.navigation_about_us) {
                switchToYourFragment(new AboutUsFragment());
                Log.d("About us", "In About Us");
                return true;
            } else {
                return false;
            }
        });

        // Remove or comment out the following block to remove the Snackbar
        /*
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
        */
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_dashboard);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    private void switchToYourFragment(Fragment fragmentTowSwitch) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.dashboard_frame_layout, fragmentTowSwitch);
        fragmentTransaction.commit();
    }
}
