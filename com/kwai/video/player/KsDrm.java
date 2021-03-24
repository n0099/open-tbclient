package com.kwai.video.player;

import android.app.Application;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes6.dex */
public class KsDrm {
    public static final String APP_CONFIG = "wasabi";
    public static final String TAG = "KsDrm";

    public static String getMarlindrmPath() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            return ((Application) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0])).getDir(APP_CONFIG, 0).getAbsolutePath();
        } catch (Exception e2) {
            Log.w(TAG, e2);
            return null;
        }
    }
}
