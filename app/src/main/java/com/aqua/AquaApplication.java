package com.aqua;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.aqua.preference.AppPreference;
import com.aqua.util.SnackbarHelper;
import com.aqua.util.Trace;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class AquaApplication extends MultiDexApplication {
    private static AquaApplication application;
    private static Toast mToast;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        AppPreference.init(application);
       // AppDatabase.getDatabase(getApplicationContext());
        //DataHandler.init();
    }

    public static synchronized AquaApplication getInstance() {
        return application;
    }

    public static void showToast(@NonNull final String msg) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (mToast != null) {
                    mToast.cancel();
                }
                Trace.i("toast :" + String.valueOf(msg));
                mToast = Toast.makeText(application, msg, Toast.LENGTH_SHORT);
                mToast.show();
            }
        });
    }

    public static Snackbar snackBarView(Context context, String msg) {
        Snackbar snackbar = Snackbar.make(((Activity) context).findViewById(android.R.id.content), msg,
                Snackbar.LENGTH_LONG);
        SnackbarHelper.configSnackbar(context, snackbar);
        return snackbar;
    }
}
