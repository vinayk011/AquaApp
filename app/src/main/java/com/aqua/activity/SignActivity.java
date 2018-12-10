package com.aqua.activity;

import android.os.Bundle;

import com.aqua.R;
import com.aqua.databinding.ActivitySignInBinding;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class SignActivity extends BaseActivity<ActivitySignInBinding> {

    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        navController = Navigation.findNavController(this, R.id.sign_nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .build();

        // Set up ActionBar
        setSupportActionBar(binding.toolbar);
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.sign_nav_host_fragment).navigateUp();
    }
}
