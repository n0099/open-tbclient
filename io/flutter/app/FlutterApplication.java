package io.flutter.app;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.CallSuper;
import io.flutter.view.FlutterMain;
/* loaded from: classes12.dex */
public class FlutterApplication extends Application {
    private Activity mCurrentActivity = null;

    @Override // android.app.Application
    @CallSuper
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
