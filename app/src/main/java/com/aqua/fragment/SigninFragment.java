package com.aqua.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.aqua.R;
import com.aqua.bindingmodel.UserDataErrorHolder;
import com.aqua.databinding.FragmentSigninBinding;
import com.aqua.listener.SignInListener;
import com.aqua.widget.Pinview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

public class SigninFragment extends BaseFragment<FragmentSigninBinding> {

    private UserDataErrorHolder userDataErrorHolder = new UserDataErrorHolder();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = (FragmentSigninBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false);
        binding.setUserDataErrorHolder(userDataErrorHolder);
        binding.setCallback(signInListener);
        binding.otpView.getPinView().setOnDone(new Pinview.OnDone() {
            @Override
            public void done() {
                hideKeyboard(context);
                signInListener.onClickSignIn();
            }
        });
        observeClick(binding.getRoot());
        return binding.getRoot();
    }

    private SignInListener signInListener = new SignInListener() {
        @Override
        public void onClickSignIn() {
            hideKeyboard(context);
            if (userDataErrorHolder.isValid() && binding.mobileNumber.isValid()) {
                callLogin();
            }
        }

        @Override
        public void onClickForgotPin() {
            /*new ForgotPinDialog(context, userDataErrorHolder.mobile.get(), new OnForgotPIN() {
                @Override
                public void sendTo(String number) {
                    sendPIN(number);
                }
            }).show();*/
        }
    };

    private void callLogin() {
        /*SignInModel signInModel = new SignInModel(false);
        signInModel.run(context, userDataErrorHolder.getData()).getData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean response) {
                if (response) {
                    ((HomeActivity) context).setDrawerLocked(false);
                    AppUtil.dashboard(context);
                } else {
                    binding.otpView.getPinView().clearOTP();
                }

            }
        });*/
    }

}
