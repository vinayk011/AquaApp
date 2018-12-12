package com.aqua.bindingmodel;

import com.aqua.util.StringUtil;
import com.aqua.viewmodel.request.SignUpRequest;

import androidx.databinding.ObservableField;

public class RegisterUserErrorHandler extends UserDataErrorHolder {
    public final ObservableField<String> confirmPin =
            new ObservableField<>();
    public final ObservableField<String> confirmPinError =
            new ObservableField<>();

    public ObservableField<String> getConfirmPin() {
        confirmPinError.set(null);
        return confirmPin;
    }


    public boolean isValid() {
        confirmPinError.set(null);
        if (super.isValid() && StringUtil.checkLength(confirmPin.get(), 4)) {
            return true;
        } else {
            if (StringUtil.isEmpty(confirmPin.get())) {
                confirmPinError.set("Enter Confirm PIN.");
            } else if (!StringUtil.checkLength(confirmPin.get(), 4)) {
                confirmPinError.set("Enter valid PIN.");
            } else if (!pin.get().equals(confirmPin.get())) {
                confirmPinError.set("Please make sure your pins match.");
            }
        }
        return false;
    }

    public SignUpRequest getRegisterData() {
        if (isValid()) {
            return new SignUpRequest(mobile.get(), pin.get(), confirmPin.get()/*EncryptionUtil.encrypt(pin.get())*/);
        } else {
            return new SignUpRequest();
        }
    }
}
