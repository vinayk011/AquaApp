package com.aqua.viewmodel.request;

public class SignUpRequest {
    private String mobile;
    private String pin;
    private String confirmPin;

    public SignUpRequest(String mobile, String pin, String confirmPin) {
        this.mobile = mobile;
        this.pin = pin;
        this.confirmPin = confirmPin;
    }

    public SignUpRequest() {
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getConfirmPin() {
        return confirmPin;
    }

    public void setConfirmPin(String confirmPin) {
        this.confirmPin = confirmPin;
    }
}
