package com.aqua.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aqua.R;
import com.aqua.bindingmodel.RegisterUserErrorHandler;
import com.aqua.databinding.FragmentSignUpBinding;
import com.aqua.listener.SignInListener;
import com.aqua.util.ImageUtil;
import com.aqua.widget.Pinview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class SignUpFragment extends BaseFragment<FragmentSignUpBinding> {

    private RegisterUserErrorHandler userDataErrorHolder = new RegisterUserErrorHandler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = (FragmentSignUpBinding) DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false);
        binding.setUserDataErrorHolder(userDataErrorHolder);
        binding.setCallback(signInListener);
        binding.confirmPin.getPinView().setOnDone(new Pinview.OnDone() {
            @Override
            public void done() {
                hideKeyboard(context);
                signInListener.onClickSignIn();
            }
        });
        binding.imgBg.setImageBitmap(ImageUtil.decodeSampledBitmapFromResource(getResources(), R.drawable.ic_shrimp, 200, 400));
        observeClick(binding.getRoot());
        return binding.getRoot();
    }

    private SignInListener signInListener = new SignInListener() {
        @Override
        public void onClickSignIn() {
            hideKeyboard(context);
            if (userDataErrorHolder.isValid() && binding.mobileNumber.isValid()) {
                callSignUp();
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

    private void callSignUp() {
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
