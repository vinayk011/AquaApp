package com.aqua.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aqua.R;
import com.aqua.databinding.FragmentSignUpLandingBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;

public class SignUpLandingFragment extends BaseFragment<FragmentSignUpLandingBinding>{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = (FragmentSignUpLandingBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up_landing, container, false);
        observeClick(binding.getRoot());
        init();
        //setHasOptionsMenu(true);
        return binding.getRoot();
    }

    private void init() {
        binding.btnLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_login, null));
      //  binding.btnSignUp.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signup, null))
    }
}
