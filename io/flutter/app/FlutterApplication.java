package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import io.flutter.view.FlutterMain;
/* loaded from: classes9.dex */
public class FlutterApplication extends Application {
    private Activity mCurrentActivity = null;

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        FlutterMain.startInitialization(this);
    }

    public Activity getCurrentActivity() {
        return this.mCurrentActivity;
    }

    public void setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
    }
}
