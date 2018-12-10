package com.aqua.activity;

import android.os.Bundle;

import com.aqua.R;
import com.aqua.databinding.ActivitySignInBinding;

import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;

public class SignActivity extends BaseActivity<ActivitySignInBinding> {
    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.sign_nav_host_fragment).navigateUp();
    }
}
